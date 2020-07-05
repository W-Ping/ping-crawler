package com.edu.ping.pingcrawler.webcrawler;

import com.edu.ping.pingcrawler.config.WebCrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;

/**
 * @author liu_wp
 * @date 2020/7/3 19:01
 * @see
 */
public class WebPageFetcher extends PageFetcher {
	private final WebCrawlConfig webCrawlConfig;

	public WebPageFetcher(WebCrawlConfig webCrawlConfig) {
		super(webCrawlConfig.getCrawlConfig());
		this.webCrawlConfig = webCrawlConfig;
	}

	public final WebCrawlConfig getWebCrawlConfig() {
		return this.webCrawlConfig;
	}
}
