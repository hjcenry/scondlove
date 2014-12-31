package com.mochasoft.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.mochasoft.util.Constants;

public class UploaderFile {
	
	// 文件允许格式
	public final static String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",
			".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
		
	public final static String fileName = "";
	
	public static File uploadFile = null;
	
	//上传文件主调用方法
	public final static Map<String, String> uploading(MultipartFile file,String path,HttpServletRequest request){
		Map<String,String> result = new HashMap<String, String>();
		if(null!=file && null!= path && !"".equals(path)){
			String oldFileName = file.getOriginalFilename();
			if(!path.startsWith("/")){
				path = "/"+path;
			}
			if(!UploaderFile.checkFileType(oldFileName)){
				result.put("result","false");
				result.put("session", "上传文件格式不支持");
			}else{
				String realPath = UploaderFile.getPhysicalPath(path,request);
				String newFileName = UploaderFile.getName(oldFileName);
				if(!realPath.endsWith("/")){
					realPath = realPath+"/";
				}
				uploadFile = new File(realPath+newFileName);
				if(!uploadFile.exists()){  
					uploadFile.mkdirs();  
		        }
				try {
					file.transferTo(uploadFile);
				} catch (Exception e) {
					result.put("result","false");
					result.put("session", "创建文件失败");
					return result;
				}
				if(!path.endsWith("/")){
					path = path + "/";
				}
				String appUrl = Constants.APP_URL+path+newFileName;
				result.put("appURL", appUrl);
				result.put("appUrl", path+newFileName);
				result.put("realUrl",realPath+newFileName);
				result.put("oldFileName",oldFileName);
				result.put("newFileName",newFileName);
				result.put("result","true");
			}
		}else{
			result.put("result","false");
			result.put("session", "参数为空");
		}
		return result;
	}
	
	//文件类型判断
	public final static boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(UploaderFile.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
	
	//根据传入的虚拟路径获取物理路径
	public final static String getPhysicalPath(String path, HttpServletRequest request) {
		String servletPath = request.getServletPath();
		int length = servletPath.length();
		String realPath = request.getSession().getServletContext()
				.getRealPath(servletPath);
		return new File(realPath).getParent().substring(0,realPath.length()-length)+ path;
	}
	
	//依据原始文件名生成新文件名
	public final static String getName(String fileName) {
		Random random = new Random();
		return fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + UploaderFile.getFileExt(fileName);
	}
	
	//获取文件扩展名
	private final static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	public static void main(String[] args){
		HttpServletRequest request = null;
		Map<String, String> results = UploaderFile.uploading(null, "images/login",request);
		if(results.get("result").equals("true")){
			System.out.print("获取上传文件真实地址:");
			System.out.println(results.get("realUrl"));
			System.out.print("获取上传文件完整虚拟地址:");
			System.out.println(results.get("appURL"));
			System.out.print("获取上传文件截取虚拟地址:");
			System.out.println(results.get("appUrl"));
			System.out.print("获取上传文件原始名称:");
			System.out.println(results.get("oldFileName"));
			System.out.print("获取上传文件最新名称:");
			System.out.println(results.get("newFileName"));
		}else{
			System.out.print("获取上传失败的原因:");
			System.out.println(results.get("session"));
		}
	}
}

