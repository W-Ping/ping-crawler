package com.edu.ping.pingcrawler.handler;


import com.edu.ping.pingcrawler.service.webpage.IWebPageService;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

/**
 * @author liu_wp
 * @date Created in 2020/7/3 20:36
 * @see
 */
public interface IWebCrawler {

	/**
	 * @return
	 */
	default <T extends WebCrawler> Class<T> getCurrClass() {
		return (Class<T>) this.getClass();
	}

	/**
	 *
	 */
	<T extends WebCrawler> T init(IWebPageService iWebPageService);

}
