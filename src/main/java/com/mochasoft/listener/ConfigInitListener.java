package com.mochasoft.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mochasoft.config.CommonConfig;
import com.mochasoft.config.SecondConfig;
/**
 * 系统初始化监听器
 * @author 大淼
 */
public class ConfigInitListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent event) {
		CommonConfig.init();
		SecondConfig.init();
	}

	public void contextDestroyed(ServletContextEvent event) {
		CommonConfig.destroy();
		SecondConfig.destroy();
	}

}
