package com.mochasoft.config;

import java.util.Properties;

public class SecondConfig {
	private static Properties props;
	// 认证类型
	private static String authType;
	// 编号
	private static String identifier;
	// 密钥
	private static String secret;

	public static void init() {
		props = new Properties();
		props = new Properties();
		try {
			props.load(CommonConfig.class.getClassLoader().getResourceAsStream(
					"second.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		authType = props.getProperty("auth_type");
		identifier = props.getProperty("identifier");
		secret = props.getProperty("secret");
	}

	public static void destroy() {
		props.clear();
		props = null;
	}

	public static String getAuthType() {
		return authType;
	}

	public static String getIdentifier() {
		return identifier;
	}

	public static String getSecret() {
		return secret;
	}

}
