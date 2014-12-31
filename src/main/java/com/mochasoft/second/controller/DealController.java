package com.mochasoft.second.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mochasoft.second.model.BazaarClassify;
import com.mochasoft.second.model.DealMessage;
import com.mochasoft.second.model.DealPay;
import com.mochasoft.second.model.ReplyMessage;
import com.mochasoft.second.model.UserInfo;
import com.mochasoft.second.service.BazaarClassifyService;
import com.mochasoft.second.service.DealMessageService;
import com.mochasoft.second.service.DealPayService;
import com.mochasoft.second.service.ReplyMessageService;
import com.mochasoft.util.Constants;
import com.mochasoft.util.Paging;
/**
 * 
 * @author Administrator
 *	动态加载
 **/
@Controller
@RequestMapping(value = "/deal")
public class DealController {

	@Autowired
	private BazaarClassifyService bazaarClassifyService;
	@Autowired
	private DealMessageService dealMessageService;
	@Autowired
	private DealPayService dealPayService;
	@Autowired
	private ReplyMessageService replyMessageService;
	
	/**
	 * 获取王子动态列表
	 */
	@RequestMapping(value = "/assignment", method = RequestMethod.GET)
	public void getAssignment(Model model,String page,String rows,String classify) {
		if(classify!=null&&(classify.equals("0")||classify.equals(""))){
			classify=null;
		}
		
		
		int count=dealMessageService.geDealMessageCount(Constants.DEAL_SEXO, classify);
		
		Paging pages=new Paging(rows,count,page);
		List<DealMessage> dealMessageList=dealMessageService.geDealMessageList(Constants.DEAL_SEXO,pages.getPageStartRow(),pages.getCountPerPage(), classify);
		model.addAttribute("dealMessageList",dealMessageList);
		model.addAttribute("page",pages);
		model.addAttribute("classify",classify);
		
	}
	
	/**
	 * 加载王子动态列表
	 */
	@RequestMapping(value = "/getmoreAssignment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getmoreAssignment(String page,String rows,String count,String classify) {
		if(classify!=null&&(classify.equals("0")||classify.equals(""))){
			classify=null;
		}
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		Paging pages=new Paging(rows,Integer.parseInt(count),page);
		List<DealMessage> dealMessageList=dealMessageService.geDealMessageList(Constants.DEAL_SEXO,pages.getPageStartRow(),pages.getCountPerPage(), classify);
		map.put("dealMessageList",dealMessageList);
		map.put("page",pages);
		return map;
	}
	
	/**
	 * 获取公主动态列表
	 */
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public void getPurchase(Model model,String page,String rows,String classify) {
		if(classify!=null&&(classify.equals("0")||classify.equals(""))){
			classify=null;
		}
		
		int count=dealMessageService.geDealMessageCount(Constants.DEAL_SEXT, classify);
		Paging pages=new Paging(rows,count,page);
		List<DealMessage> dealMessageList=dealMessageService.geDealMessageList(Constants.DEAL_SEXT,pages.getPageStartRow(),pages.getCountPerPage(), classify);
		model.addAttribute("dealMessageList",dealMessageList);
		model.addAttribute("page",pages);
		model.addAttribute("classify",classify);
	}
	
	/**
	 * 加载公主动态列表
	 */
	@RequestMapping(value = "/getmorePurchase", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getmorePurchase(String page,String rows,String count,String classify) {
		
		if(classify!=null&&(classify.equals("0")||classify.equals(""))){
			classify=null;
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		Paging pages=new Paging(rows,Integer.parseInt(count),page);
		List<DealMessage> dealMessageList=dealMessageService.geDealMessageList(Constants.DEAL_SEXT,pages.getPageStartRow(),pages.getCountPerPage(), classify);
		map.put("dealMessageList",dealMessageList);
		map.put("page",pages);
		
		return map;
	}
	
	/**
	 * 获取分类列表
	 */
	@RequestMapping(value = "/classify", method = RequestMethod.GET)
	public void getClassify(Model model,String dealtype) {
		int status = 1;
		List<BazaarClassify> allClassify = bazaarClassifyService.getAllClassify(status);
		model.addAttribute("allClassify",allClassify);
		model.addAttribute("dealtype",dealtype);
	}
	
	//提交出售/购买的信息
	@RequestMapping(value="/insertMessageByAjax" ,method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> insertMessageByAjax(DealMessage dealMessage,HttpSession session){
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		Map<String,String> result = new HashMap<String, String>();
		dealMessage.setDealId(UUID.randomUUID().toString());
		if(dealMessage.getDealHope()==null){
			dealMessage.setDealHope("");
		}
		
		dealMessage.setDealStatus(1);
		dealMessage.setStatus(1);
		dealMessage.setCreateUser(user.getUserId());
		if(dealMessage.getDealImage()!=null){
			dealMessage.setDealImage(dealMessage.getDealImage().substring(Constants.APP_URL.length()));
		}
		int i = dealMessageService.insertDealMessage(dealMessage);
		if(i!=1){
			result.put("type", "error");
		}else{
			result.put("type", "success");
		}
		return result;
	}
	
	
	/**
	 * 获取转让详情
	 */
	@RequestMapping(value = "/assignDetail", method = RequestMethod.GET)
	public void assignDetail(Model model,String dealId) {
		DealMessage dealMessage = dealMessageService.getDealMessageOne(dealId);
		List<DealPay> dealPays = dealPayService.getAllDealPaysById(dealId);
		List<ReplyMessage> replyMessages = replyMessageService.getAllReplyMessagesByDealId(dealId);
		model.addAttribute("dealMessage",dealMessage);
		model.addAttribute("dealPays",dealPays);
		model.addAttribute("replyMessages",replyMessages);	
	}
	
	/**
	 * 获取求购详情
	 */
	@RequestMapping(value = "/purDetail", method = RequestMethod.GET)
	public void purDetail(Model model,String dealId) {
		DealMessage dealMessage = dealMessageService.getDealMessageOne(dealId);
		List<DealPay> dealPays = dealPayService.getAllDealPaysById(dealId);
		List<ReplyMessage> replyMessages = replyMessageService.getAllReplyMessagesByDealId(dealId);
		model.addAttribute("dealMessage",dealMessage);
		model.addAttribute("dealPays",dealPays);
		model.addAttribute("replyMessages",replyMessages);
	}
	
	/**
	 * 更改交易状态
	 */
	 @RequestMapping(value = "/updateDealStatus", method = RequestMethod.GET)
	 public String updateDealStatus(String bianjiId,String dealId,String dealType){
		 int dealStatus;
		 if(bianjiId.equals("2")){
			 dealStatus = 2;
		 }else if(bianjiId.equals("3")){
			 dealStatus = 1;
		 }else{
			 dealStatus = 0;
		 }
		 int i = dealMessageService.updateDealStatus(dealStatus,dealId);
		 if(dealType.equals("2")){
			 if(!bianjiId.equals("4")){
				 return "redirect:purDetail?dealId="+dealId;
			 }else{
				 return "redirect:purchase";
			 } 
		 }else{
			 if(!bianjiId.equals("4")){
				 return "redirect:assignDetail?dealId="+dealId;
			 }else{
				 return "redirect:assignment";
			 } 
		 }
	 }
}
