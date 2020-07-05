package com.edu.ping.pingcrawler.webcrawler;

import com.edu.ping.pingcrawler.config.WebCrawlConfig;
import com.edu.ping.pingcrawler.handler.PostgresCrawlerFactory;
import com.edu.ping.pingcrawler.pojo.CrawlCondition;
import com.edu.ping.pingcrawler.pojo.PageUrl;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;

import java.util.Set;

/**
 * @author liu_wp
 * @date 2020/7/3 19:11
 * @see
 */
public class WebCrawlController extends CrawlController {
	private final CrawlConfig crawlConfig;
	private final WebPageFetcher pageFetcher;
	private final WebRobotstxtServer robotstxtServer;

	/**
	 * @param webPageFetcher
	 * @throws Exception
	 */
	public WebCrawlController(WebPageFetcher webPageFetcher) throws Exception {
		this(webPageFetcher.getWebCrawlConfig().getCrawlConfig(), webPageFetcher, getWebRobotstxtServer(webPageFetcher));
	}

	/**
	 * @param crawlConfig
	 * @param pageFetcher
	 * @param robotstxtServer
	 * @throws Exception
	 */
	public WebCrawlController(CrawlConfig crawlConfig, WebPageFetcher pageFetcher, WebRobotstxtServer robotstxtServer) throws Exception {
		super(crawlConfig, pageFetcher, robotstxtServer);
		this.crawlConfig = crawlConfig;
		this.pageFetcher = pageFetcher;
		this.robotstxtServer = robotstxtServer;
	}

	private void addPageUrl(Set<PageUrl> pageUrls) {
		if (pageUrls != null && pageUrls.size() > 0) {
			for (PageUrl pageUrl : pageUrls) {
				this.addSeed(pageUrl.getUrl(), pageUrl.getDocId());
			}
		}
	}

	/**
	 * @param crawlCondition
	 * @param postgresCrawlerFactory
	 */
	public void start(CrawlCondition crawlCondition, PostgresCrawlerFactory postgresCrawlerFactory) {
		addPageUrl(crawlCondition.getPageUrls());
//		if (!crawlCondition.isBlocking()) {
//			this.startNonBlocking(postgresCrawlerFactory, crawlCondition.getNumberOfCrawlers());
//		} else {
//		}
		this.start(postgresCrawlerFactory, crawlCondition.getNumberOfCrawlers(), false);
	}

	private static WebRobotstxtServer getWebRobotstxtServer(WebPageFetcher webPageFetcher) {
		WebCrawlConfig webCrawlConfig = webPageFetcher.getWebCrawlConfig();
		RobotstxtConfig robotstxtConfig = webCrawlConfig.getRobotstxtConfig();
		return new WebRobotstxtServer(robotstxtConfig, webPageFetcher);
	}

	@Override
	protected <T extends WebCrawler> void start(final WebCrawlerFactory<T> crawlerFactory, final int numberOfCrawlers, final boolean isBlocking) {
		super.start(crawlerFactory, numberOfCrawlers, isBlocking);
	}

	/**
	 * Wait until this crawling session finishes.
	 */
	@Override
	public void waitUntilFinish() {
		super.waitUntilFinish();
	}
}
