package com.edu.ping.pingcrawler.handler;

import com.edu.ping.pingcrawler.pojo.CrawlCondition;
import com.edu.ping.pingcrawler.webcrawler.WebCrawlController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liu_wp
 * @date 2020/7/3 20:13
 * @see
 */
public class CrawStartHandler {
    @Autowired
    private WebCrawlController webCrawlController;
    @Autowired
    private IWebCrawlHandler iWebCrawlHandler;

    protected void start(CrawlCondition crawlCondition) {
        webCrawlController.start(crawlCondition, iWebCrawlHandler.getWebCrawlerClass());
    }
}
