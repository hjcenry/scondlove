package com.mochasoft.util;


public class Constants {

    private static ApplicationProperties properties = new ApplicationProperties();
    //SESSION
    public static String SESSION_USER = "user";
    
    public static String SESSION_USERVO = "userVO";
    
    public static String SESSION_FROM = "comeFrom";
    
    public static String SESSION_TOKEN = "enterToken";
    
    //国际化文件路径
    public static String MESSAGE_PATH = "messages/messages";
    public static String ECHO_STR = "echostr";
    public static String ENCODE_SERVER = "UTF-8";
    public static String PARAM_TOKEN = "token";
    public static String PARAM_OPENID = "openId";
    public static String PARAM_FROM = "from";
    //应用访问URL
    public static String APP_URL = properties.getProperty("app_url");

  
    //头像存放路径
    public static String PHOTO_PATH = ""; 
    //全局位置
    public static String WEB_APP_PATH = "";
    
    //交易类型
    public static String DEAL_SEXO="1";//王子
    public static String DEAL_SEXT="2";//公主
}
