package com.mochasoft.second.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mochasoft.util.UploaderFile;
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
 *	动态
 **/
@Controller
@RequestMapping(value = "/assignment")
public class AssignController {

	@Autowired
	private BazaarClassifyService bazaarClassifyService;
	@Autowired
	private DealMessageService dealMessageService;
	@Autowired
	private DealPayService dealPayService;
	@Autowired
	private ReplyMessageService replyMessageService;
	private static final Logger logger = LoggerFactory.getLogger(AssignController.class);
	/**
	 * 我要转
	 */
	@RequestMapping(value = "/makeassignment", method = RequestMethod.GET)
	public void getAssignment(Model model,String flag) {
		int status = 1;
		List<BazaarClassify> allClassify = bazaarClassifyService.getAllClassify(status);
		model.addAttribute("allClassify",allClassify);
		model.addAttribute("flag",flag);
	}
	
	/**
	 * 编辑转让
	 * @param model
	 */
	@RequestMapping(value = "/editAssign", method = RequestMethod.GET)
	public void editAssignment(Model model,String assignId) {
		int status = 1;
		DealMessage dealMessage = dealMessageService.getDealMessageOne(assignId);
		
		List<BazaarClassify> allClassify = bazaarClassifyService.getAllClassify(status);
		model.addAttribute("allClassify",allClassify);
		model.addAttribute("dealMessage",dealMessage);
	}
	
	/**
	 * 编辑交易
	 * @param model
	 */
	@RequestMapping(value = "/editAssignmentDeal", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> editAssignmentDeal(DealMessage dealMessage,HttpSession session,HttpServletRequest request) {
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
	 * 同意交易
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/assignagree", method = RequestMethod.GET)
	public String assignagree(String payId,String dealDesc,String dealId,HttpSession session) throws UnsupportedEncodingException{
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		dealDesc = new String(dealDesc.getBytes("ISO-8859-1"),"utf-8");
		DealPay dealMessage = new DealPay();
		dealMessage.setPayId(payId);
		dealMessage.setDealDesc(dealDesc);
		dealMessage.setDealUser(user.getUserId());
		dealMessage.setDealStatus(1);
		int i = dealPayService.agreeDealPay(dealMessage);
		return "redirect:../deal/assignDetail?dealId="+dealId;
	}
	
	/**
	 * 评论回复
	 */
	@RequestMapping(value = "/assignreply", method = RequestMethod.GET)
	public String assignreply(String context,String dealId,HttpSession session) throws UnsupportedEncodingException{
		UserInfo user = (UserInfo)session.getAttribute(Constants.SESSION_USERVO);
		ReplyMessage replyMessage = new ReplyMessage();
		replyMessage.setReplyId(UUID.randomUUID().toString());
		context = new String(context.getBytes("ISO-8859-1"),"utf-8");
		replyMessage.setReplyContent(context);
		replyMessage.setCreateUser(user.getUserId());
		replyMessage.setDealId(dealId);
		replyMessage.setStatus(1);
		int i =	replyMessageService.indexReply(replyMessage);
		return "redirect:../deal/assignDetail?dealId="+dealId;
	}
	
	/**
	 *出价转让
	 */
	@RequestMapping(value = "/indexassignPay", method = RequestMethod.GET)
	public String indexassignPay(String offerDesc,String telphone,String payImage,String dealId,HttpSession session) throws UnsupportedEncodingException{
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
		return "redirect:../deal/assignDetail?dealId="+dealId;
	}
	
	//上传图片
	@RequestMapping(value="/upOneImg" ,method = RequestMethod.POST)
	@ResponseBody
	public String upOneImg(HttpServletRequest request) throws ParseException{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file= multipartRequest.getFile("fileimage");
		Map<String, String> results = UploaderFile.uploading(file, "images/goods",request);
		if(results.get("result").equals("true")){
			return results.get("appURL");
		}else{
			return null;
		}
	}
	
	//上传图片
	@RequestMapping(value="/upImg" ,method = RequestMethod.POST)
	@ResponseBody
	public String upImg(HttpServletRequest request,String oldImg) throws ParseException{
		if(oldImg!=null&&!oldImg.equals("")){
			String path=request.getRealPath(oldImg);
			File oldfile = new File(path);
		    if(oldfile.exists()){
			     boolean d = oldfile.delete();
			     if(!d){
			    	 logger.debug("删除失败！");
			     }
		    }
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file= multipartRequest.getFile("fileimage");
		Map<String, String> results = UploaderFile.uploading(file, "images/goods",request);
		if(results.get("result").equals("true")){
			return results.get("appUrl");
		}else{
			return null;
		}
	}
}
