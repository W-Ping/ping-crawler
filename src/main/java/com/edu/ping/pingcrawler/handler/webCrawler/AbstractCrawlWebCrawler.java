package com.edu.ping.pingcrawler.handler.webCrawler;

import com.edu.ping.pingcrawler.exception.CrawlerRuntimeException;
import com.edu.ping.pingcrawler.handler.IWebCrawler;
import com.edu.ping.pingcrawler.pojo.entity.WebPageEntity;
import com.edu.ping.pingcrawler.pojo.res.ResultRes;
import com.edu.ping.pingcrawler.service.webpage.IWebPageService;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.ParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

/**
 * @author liu_wp
 * @date 2020/7/3 18:19
 * @see
 */
public abstract class AbstractCrawlWebCrawler extends WebCrawler implements IWebCrawler {

	protected IWebPageService iWebPageService;

	/**
	 *
	 */
	private static final Pattern FILE_ENDING_EXCLUSION_PATTERN = Pattern.compile(".*(\\.(" +
			"css|js" +
			"|bmp|gif|jpe?g|JPE?G|png|tiff?|ico|nef|raw" +
			"|mid|mp2|mp3|mp4|wav|wma|flv|mpe?g" +
			"|avi|mov|mpeg|ram|m4v|wmv|rm|smil" +
			"|pdf|doc|docx|pub|xls|xlsx|vsd|ppt|pptx" +
			"|swf" +
			"|zip|rar|gz|bz2|7z|bin" +
			"|xml|txt|java|c|cpp|exe" +
			"))$");

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILE_ENDING_EXCLUSION_PATTERN.matcher(href).matches();
	}

	@Override
	public final <T extends WebCrawler> T init(IWebPageService iWebPageService) {
		this.iWebPageService = iWebPageService;
		return (T) this;
	}

	@Override
	public final void visit(final Page page) {
		storeWebPage(page);
		visitWebPage(page);
	}

	/**
	 * @param page
	 */
	public void visitWebPage(final Page page) {

	}

	/**
	 * @param page
	 */
	private void storeWebPage(Page page) {
		try {
			ParseData parseData = page.getParseData();
			if (page.getParseData() != null && parseData instanceof HtmlParseData) {
				HtmlParseData htmlParseData = (HtmlParseData) parseData;
				WebPageEntity webPageEntity = new WebPageEntity();
				webPageEntity.setTitle(htmlParseData.getTitle());
				webPageEntity.setHtml(htmlParseData.getHtml());
				webPageEntity.setText(htmlParseData.getText());
				webPageEntity.setUrl(page.getWebURL().getURL());
				webPageEntity.setSeen(Timestamp.valueOf(LocalDateTime.now()));
				System.out.println("【" + Thread.currentThread().getName() + "】:=>>>>" + webPageEntity.getTitle() + "<<<=");
				System.out.println("【" + Thread.currentThread().getName() + "】:=>>>>" + webPageEntity.getUrl() + "<<<=");
				ResultRes resultRes = iWebPageService.saveWebPage(webPageEntity);
				if (!ResultRes.SUCCESS_CODE.equals(resultRes.getCode())) {
					throw new CrawlerRuntimeException("save web page failed");
				}
			}
		} catch (CrawlerRuntimeException e) {
			logger.error("store html page failed", e);
		}

	}


}
