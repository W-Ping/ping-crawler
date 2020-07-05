package com.edu.ping.pingcrawler.handler;

import com.edu.ping.pingcrawler.service.webpage.IWebPageService;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

/**
 * @author lwp
 * @create 2020/07/05 11:09
 */
public class PostgresCrawlerFactory<T extends WebCrawler> implements CrawlController.WebCrawlerFactory<T> {
	private IWebPageService iWebPageService;
	/**
	 *
	 */
	private IWebCrawler iWebCrawler;

	public PostgresCrawlerFactory(IWebPageService iWebPageService, IWebCrawler iWebCrawler) {
		this.iWebPageService = iWebPageService;
		this.iWebCrawler = iWebCrawler;
	}

	@Override
	public T newInstance() throws Exception {
		return iWebCrawler.init(iWebPageService);
	}
}
