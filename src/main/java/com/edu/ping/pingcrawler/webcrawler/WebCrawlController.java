package com.edu.ping.pingcrawler.webcrawler;

import com.edu.ping.pingcrawler.pojo.CrawlCondition;
import com.edu.ping.pingcrawler.pojo.PageUrl;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * @author liu_wp
 * @date 2020/7/3 19:11
 * @see
 */
@Configuration
public class WebCrawlController extends CrawlController {
    /**
     * @param config
     * @param pageFetcher
     * @param robotstxtServer
     * @throws Exception
     */
    public WebCrawlController(CrawlConfig config, WebPageFetcher pageFetcher, WebRobotstxtServer robotstxtServer) throws Exception {
        super(config, pageFetcher, robotstxtServer);
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
     * @param tClass
     * @param <T>
     */
    public <T extends WebCrawler> void start(CrawlCondition crawlCondition, Class<T> tClass) {
        addPageUrl(crawlCondition.getPageUrls());
        if (!crawlCondition.isBlocking()) {
            this.startNonBlocking(tClass, crawlCondition.getNumberOfCrawlers());
        } else {
            this.start(tClass, crawlCondition.getNumberOfCrawlers());
        }
    }
}
