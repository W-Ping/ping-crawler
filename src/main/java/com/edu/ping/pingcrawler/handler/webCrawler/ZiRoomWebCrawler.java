package com.edu.ping.pingcrawler.handler.webCrawler;

import com.edu.ping.pingcrawler.exception.CrawlerRuntimeException;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.ParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.springframework.stereotype.Service;

/**
 * 自如租房
 *
 * @author lwp
 * @create 2020/07/04 12:19
 */
@Service(value = "ziRoomWebCrawler")
public class ZiRoomWebCrawler extends AbstractCrawlWebCrawler {
	/**
	 * @param webPage
	 * @throws CrawlerRuntimeException
	 */
	@Override
	public void visitWebPage(final Page webPage) throws CrawlerRuntimeException {
		ParseData parseData = webPage.getParseData();
		if (parseData instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) parseData;
			String title = htmlParseData.getTitle();
			WebURL webURL = webPage.getWebURL();
		}
	}
}
