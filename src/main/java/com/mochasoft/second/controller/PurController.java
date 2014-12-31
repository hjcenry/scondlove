package com.mochasoft.second.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
/**
 * 
 * @author Administrator
 *	白雪公主
 **/
@Controller
@RequestMapping(value = "/purchase")
public class PurController {

	@Autowired
	private BazaarClassifyService bazaarClassifyService;
	@Autowired
	private DealMessageService dealMessageService;
	@Autowired
	private DealPayService dealPayService;
	@Autowired
	private ReplyMessageService replyMessageService;
	
	/**
	 * 白雪公主
	 */
	@RequestMapping(value = "/makepurchase", method = RequestMethod.GET)
	public void getPurchase(Model model,String flag) {
		int status = 1;
		List<BazaarClassify> allClassify = bazaarClassifyService.getAllClassify(status);
		model.addAttribute("allClassify",allClassify);
		model.addAttribute("flag",flag);
	}
	
	/**
	 * 编辑白雪公主
	 * @param model
	 */
	@RequestMapping(value = "/editPurchase", method = RequestMethod.GET)
	public void editPurchase(Model model,String dealId) {
		int status = 1;
		DealMessage dealMessage = dealMessageService.getDealMessageOne(dealId);
		
		List<BazaarClassify> allClassify = bazaarClassifyService.getAllClassify(status);
		model.addAttribute("allClassify",allClassify);
		model.addAttribute("dealMessage",dealMessage);
	}
	
	/**
	 * 编辑白雪公主活动
	 * @param model
	 */
	@RequestMapping(value = "/editPurchaseDeal", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> editPurchaseDeal(DealMessage dealMessage,HttpSession session,HttpServletRequest request) {
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		Map<String,String> result = new HashMap<String, String>();
		dealMessage.setDealStatus(1);
		dealMessage.setStatus(1);
		dealMessage.setCreateUser(user.getUserId());
		
		if(dealMessage.getDealImage()!=null){
			String contextPath = request.getContextPath();
			dealMessage.setDealImage(dealMessage.getDealImage().substring(contextPath.length()));
		}
		
		int status = dealMessageService.updateDealMessage(dealMessage);
		if(status!=1){
			result.put("type", "error");
		}else{
			result.put("type", "success");
		}
		return result;
	}
	
	/**
	 * 白雪公主同意邀请
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/puragree", method = RequestMethod.GET)
	public String puragree(String payId,String dealDesc,String dealId,HttpSession session) throws UnsupportedEncodingException{
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		dealDesc = new String(dealDesc.getBytes("ISO-8859-1"),"utf-8");
		DealPay dealMessage = new DealPay();
		dealMessage.setPayId(payId);
		dealMessage.setDealDesc(dealDesc);
		dealMessage.setDealUser(user.getUserId());
		dealMessage.setDealStatus(1);
		int i = dealPayService.agreeDealPay(dealMessage);
		return "redirect:../deal/purDetail?dealId="+dealId;
	}
	
	/**
	 * 评论回复
	 */
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public String reply(String context,String dealId,HttpSession session) throws UnsupportedEncodingException{
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		ReplyMessage replyMessage = new ReplyMessage();
		replyMessage.setReplyId(UUID.randomUUID().toString());
		context = new String(context.getBytes("ISO-8859-1"),"utf-8");
		replyMessage.setReplyContent(context);
		replyMessage.setCreateUser(user.getUserId());
		replyMessage.setDealId(dealId);
		replyMessage.setStatus(1);
		int i =	replyMessageService.indexReply(replyMessage);
		return "redirect:../deal/purDetail?dealId="+dealId;
	}
	
	/**
	 *接受白雪公主邀请
	 */
	@RequestMapping(value = "/indexPay", method = RequestMethod.GET)
	public String indexPay(String offerDesc,String telphone,String payImage,String dealId,HttpSession session) throws UnsupportedEncodingException{
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		DealPay dealPay = new DealPay();
		dealPay.setPayId(UUID.randomUUID().toString());
		dealPay.setDealId(dealId);
		if(payImage.indexOf("tupian.png")>0){
			payImage = null;
		}else{
			payImage=payImage.substring(Constants.APP_URL.length());
			dealPay.setPayImage(payImage);
		}
		if(null!=offerDesc && !"".equals(offerDesc)){
			offerDesc = new String(offerDesc.getBytes("ISO-8859-1"),"utf-8");
		}
		dealPay.setOfferDesc(offerDesc);
		dealPay.setTelphone(telphone);
		dealPay.setCreateUser(user.getUserId());
		dealPay.setDealStatus(0);
		int i = dealPayService.insertDealPay(dealPay);
		return "redirect:../deal/purDetail?dealId="+dealId;
	}
}
