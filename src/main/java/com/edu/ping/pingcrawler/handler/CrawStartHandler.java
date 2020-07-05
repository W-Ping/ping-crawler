package com.edu.ping.pingcrawler.handler;

import com.edu.ping.pingcrawler.config.WebCrawlConfig;
import com.edu.ping.pingcrawler.constant.WebSiteEnum;
import com.edu.ping.pingcrawler.pojo.CrawlCondition;
import com.edu.ping.pingcrawler.service.webpage.IWebPageService;
import com.edu.ping.pingcrawler.webcrawler.WebCrawlController;
import com.edu.ping.pingcrawler.webcrawler.WebPageFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liu_wp
 * @date 2020/7/3 20:13
 * @see
 */
@Component
public class CrawStartHandler {
	private static final Logger logger = LoggerFactory.getLogger(CrawStartHandler.class);
	private final IWebPageService iWebPageService;
	private final WebCrawlConfig webCrawlConfig;

	/**
	 * @param webCrawlConfig
	 * @param iWebPageService
	 */
	public CrawStartHandler(WebCrawlConfig webCrawlConfig, IWebPageService iWebPageService) {
		this.webCrawlConfig = webCrawlConfig;
		this.iWebPageService = iWebPageService;
	}

	/**
	 * @param webSiteId
	 * @param crawlCondition
	 */
	public void start(String webSiteId, CrawlCondition crawlCondition) {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
			IWebCrawler iWebCrawler = (IWebCrawler) webApplicationContext.getBean(WebSiteEnum.getWebCrawlerBeanId(webSiteId));
			WebPageFetcher webPageFetcher = new WebPageFetcher(webCrawlConfig);
			WebCrawlController webCrawlController = new WebCrawlController(webPageFetcher);
			webCrawlController.start(crawlCondition, new PostgresCrawlerFactory(iWebPageService, iWebCrawler));
			webCrawlController.waitUntilFinish();
		} catch (Exception e) {
			logger.error("start crawler failed 【{}】", e.getMessage());
		}
	}
}
