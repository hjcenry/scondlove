package com.mochasoft.config;

import java.util.Properties;

public class CommonConfig {

	private static Properties props;
	// 认证接口
	private static String authUrl;
	// 数据源接口
	private static String datasourceUrl;
	// 下载接口
	private static String downloadUrl;

	public static void init() {
		props = new Properties();
		try {
			props.load(CommonConfig.class.getClassLoader().getResourceAsStream(
					"common.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		authUrl = props.getProperty("auth_url");
		datasourceUrl = props.getProperty("datasource_url");
		downloadUrl = props.getProperty("download_url");
	}

	public static void destroy() {
		props.clear();
		props = null;
	}

	public static String getAuthUrl() {
		return authUrl;
	}

	public static String getDatasourceUrl() {
		return datasourceUrl;
	}

	public static String getDownloadUrl() {
		return downloadUrl;
	}

}
