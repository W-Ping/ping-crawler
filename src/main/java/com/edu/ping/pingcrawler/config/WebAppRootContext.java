package com.edu.ping.pingcrawler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.WebAppRootListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author lwp
 * @create 2020/07/05 23:15
 */
@Configuration
public class WebAppRootContext implements ServletContextInitializer {
	@Value("${websocket.bufferSize:1024000}")
	private String bufferSize;
	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
		servletContext.addListener(WebAppRootListener.class);
		servletContext.setInitParameter("org.apache.tomcat.websocket.textBufferSize", bufferSize);
	}
}
