package com.edu.ping.pingcrawler.config;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu_wp
 * @date 2020/7/3 18:42
 * @see
 */
@Configuration
public class WebCrawlConfig {
    @Value("${crawler.crawlConfig.politenessDelay:100}")
    private int politenessDelay;
    @Value("${crawler.crawlConfig.maxPagesToFetch:20}")
    private int maxPagesToFetch;
    @Value("${crawler.robotstxtConfig.enabled:true}")
    private boolean enabled;

    @Bean
    public CrawlConfig getCrawlConfig() {
        CrawlConfig crawlConfig = new CrawlConfig();
        crawlConfig.setPolitenessDelay(politenessDelay);
        crawlConfig.setMaxPagesToFetch(maxPagesToFetch);
        return crawlConfig;
    }
    @Bean
    public RobotstxtConfig getRobotstxtConfig() {
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        robotstxtConfig.setEnabled(enabled);
        return robotstxtConfig;
    }
}
