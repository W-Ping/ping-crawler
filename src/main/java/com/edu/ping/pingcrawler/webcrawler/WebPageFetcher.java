package com.edu.ping.pingcrawler.webcrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author liu_wp
 * @date 2020/7/3 19:01
 * @see
 */
@Configuration
@ConditionalOnBean(CrawlConfig.class)
public class WebPageFetcher extends PageFetcher {
    public WebPageFetcher(CrawlConfig config) {
        super(config);
    }
}
