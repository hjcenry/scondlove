package com.mochasoft.admin.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mochasoft.config.CommonConfig;
import com.mochasoft.config.SecondConfig;
import com.mochasoft.mportal.api.auth.SecurityTokenParser;
import com.mochasoft.mportal.api.auth.TokenParseException;
import com.mochasoft.mportal.api.utils.HttpClientUtil;
import com.mochasoft.second.model.UserInfo;
import com.mochasoft.second.service.UserInfoService;
import com.mochasoft.util.Constants;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private UserInfoService userInfoService;// 登录用户

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(){
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkToken(HttpServletRequest request, Model model)
			throws TokenParseException, IOException {
		String auth_token = request.getParameter("auth_token");
		String platform = request.getParameter("platform");
		String userToken = SecurityTokenParser.getUserToken(platform,auth_token);
		String authType = SecondConfig.getAuthType();
		String identifier = SecondConfig.getIdentifier();
		String secret = SecondConfig.getSecret();
		// 验证Token
		Map<String, String> params = new HashMap<String, String>();
		// 应用注册信息
		params.put("auth_type", authType);
		params.put("identifier", identifier);
		params.put("secret", secret);
		params.put("user_token", userToken);
		String jsonString = HttpClientUtil.sendRequest(CommonConfig.getAuthUrl(), params);
		JSONObject jsonObject = JSON.parseObject(jsonString);
		boolean success = jsonObject.getBooleanValue("success");
		if (success) {
			String userName = jsonObject.getString("userId");
			UserInfo userInfo = userInfoService.getUserInfoByUserNameAndStatus(userName, 1);
			if (userInfo != null) {
				request.getSession().setAttribute(Constants.SESSION_USERVO, userInfo);
				return "redirect:/deal/assignment";
			} else {
				userInfo = userInfoService.getUserInfoByUserNameAndStatus(userName, 0);
				if (userInfo != null) {
					request.setAttribute("userInfo", userInfo);
				} else {
					userInfo = new UserInfo();
            		userInfo.setUserId(UUID.randomUUID().toString());
            		userInfo.setUserName(userName);
            		userInfo.setCreateTime(new Date());
            		userInfo.setStatus(0);
            		userInfo.setMarrytype(0);
            		userInfoService.saveUserInfo(userInfo);
				}
				request.setAttribute("userName", userName);
				return "/auth/editUserInfoUI";
			}
		} else {
			return "";
		}
	}

	@RequestMapping(value = "/editUserInfoUI", method = RequestMethod.GET)
	public String editUserInfoUI(HttpServletRequest request) {
		String userName = "lipx1";
		UserInfo userInfo = userInfoService.getUserInfoByUserNameAndStatus(userName, 1);
		if (userInfo != null) {
			request.getSession().setAttribute(Constants.SESSION_USERVO, userInfo);
			return "redirect:/deal/assignment";
		} else {
			userInfo = userInfoService.getUserInfoByUserNameAndStatus(userName, 0);
			if (userInfo != null) {
				request.setAttribute("userInfo", userInfo);
			} else {
				userInfo = new UserInfo();
        		userInfo.setUserId(UUID.randomUUID().toString());
        		userInfo.setUserName(userName);
        		userInfo.setCreateTime(new Date());
        		userInfo.setStatus(0);
        		userInfo.setMarrytype(0);
        		userInfoService.saveUserInfo(userInfo);
			}
			request.setAttribute("userName", userName);
			return "/auth/editUserInfoUI";
		}
	}

	@RequestMapping(value = "/uploader", method = RequestMethod.POST)
	public void uploader(MultipartHttpServletRequest multipartRequest,HttpServletResponse response,String userName) throws Exception {
		response.setContentType("text/html;charset=UTF-8");  
	    Map<String, Object> result = new HashMap<String, Object>();  
	    //获取多个file  
	    for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {  
	        String key = (String) it.next();  
	        MultipartFile imgFile = multipartRequest.getFile(key);
	        if(imgFile.getOriginalFilename().endsWith(".jpg") || imgFile.getOriginalFilename().endsWith(".gif") || imgFile.getOriginalFilename().endsWith(".png") ||
	        		imgFile.getOriginalFilename().endsWith(".JPG") || imgFile.getOriginalFilename().endsWith(".GIF") || imgFile.getOriginalFilename().endsWith(".PNG")){
	        	if (imgFile.getOriginalFilename().length() > 0 && imgFile.getSize()<2097152) {  
		            String fileName = imgFile.getOriginalFilename();
		            String fileType = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		            String newFileName = UUID.randomUUID().toString()+"."+fileType;
		            String filePath = "/"+"upload"+"/"+newFileName;
		            //Constant.UPLOAD_GOODIMG_URL 是一个配置文件路径  
		            try {
		            	UserInfo userInfo = userInfoService.getUserInfoByUserNameAndStatus(userName, 0);
		            	if (userInfo.getUserImage() == null || userInfo.getUserImage().trim().equals("")) {
		            		String uploadFileUrl = multipartRequest.getSession().getServletContext().getRealPath(File.separator+"upload");  
		            		File _apkFile = saveFileFromInputStream(imgFile.getInputStream(), uploadFileUrl, newFileName);  
		            		if (_apkFile.exists()) {  
		            			//FileInputStream fis = new FileInputStream(_apkFile);  
		            		} else{  
		            			throw new FileNotFoundException("apk write failed:" + fileName);  
		            		}
		            		result.put("success", true);
		            		result.put("filePath", filePath);
		            		userInfo = new UserInfo();
		            		userInfo.setUserName(userName);
		            		userInfo.setUserImage(filePath);
		            		userInfoService.updateUserInfo(userInfo);
		            	} else {
		            		String uploadFileUrl = multipartRequest.getSession().getServletContext().getRealPath(userInfo.getUserImage());  
		            		File file = new File(uploadFileUrl);
		            		file.delete();
		            		uploadFileUrl = multipartRequest.getSession().getServletContext().getRealPath(File.separator+"upload");  
		            		File _apkFile = saveFileFromInputStream(imgFile.getInputStream(), uploadFileUrl, newFileName);  
		            		if (_apkFile.exists()) {  
		            			//FileInputStream fis = new FileInputStream(_apkFile);  
		            		} else{  
		            			throw new FileNotFoundException("apk write failed:" + fileName);  
		            		}
		            		result.put("success", true);
		            		result.put("filePath", filePath);
		            		userInfo = new UserInfo();
		            		userInfo.setUserName(userName);
		            		userInfo.setUserImage(filePath);
		            		userInfoService.updateUserInfo(userInfo);
		            	}
		            } catch (Exception e) {  
		                result.put("success", false);  
		                e.printStackTrace();  
		            }  
		        }else{
		        	result.put("success", false);
		        	result.put("msg", "请上传小于2M的图片");
		        }
	        }else{
	        	 result.put("success", false);
	        	 result.put("msg", "请上传JPEG、GIF、PNG格式图片");
	        }
	          
	    }  
	    response.getWriter().print(JSON.toJSONString(result)/*JsonUtils.objectToJson(result)*/);  
	}
	private File saveFileFromInputStream(InputStream stream, String path,  
	        String filename) throws IOException {  
	    File file = new File(path + File.separator + filename);  
	    FileOutputStream fs = new FileOutputStream(file);  
	    byte[] buffer = new byte[1024 * 1024];  
	    int bytesum = 0;  
	    int byteread = 0;  
	    while ((byteread = stream.read(buffer)) != -1) {  
	        bytesum += byteread;  
	        fs.write(buffer, 0, byteread);  
	        fs.flush();  
	    }  
	    fs.close();  
	    stream.close();  
	    return file;  
	}

	@RequestMapping(value = "/submitUserInfo", method = RequestMethod.POST)
	public void submitUserInfo(HttpServletRequest request, UserInfo userInfo, HttpServletResponse response) throws IOException { 
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			userInfo.setStatus(1);
			userInfo.setMarrytype(1);
			userInfo.setBirthday(new SimpleDateFormat("yyyy-MM-dd ").parse(userInfo.getBirthdays()));
			userInfoService.updateUserInfo(userInfo);
			result.put("success", true);
			result.put("msg", "提交成功！");
			userInfo = userInfoService.getUserInfoByUserNameAndStatus(userInfo.getUserName(), 1);
			request.getSession().setAttribute(Constants.SESSION_USERVO, userInfo);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "提交失败，请稍后重试！");
		}
		response.getWriter().print(JSON.toJSONString(result));
	}
	
	/**
	 * 查看个人详细信息
	 */
	@RequestMapping(value = "/userMessage", method = RequestMethod.GET)
	public void userMessage(Model model,String userName){
		UserInfo userMessage = userInfoService.getUserInfoByUserNameAndStatus(userName,1);
		model.addAttribute("userMessage",userMessage);
	}
}
