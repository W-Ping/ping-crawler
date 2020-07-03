package com.edu.ping.pingcrawler.webcrawler;

import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author liu_wp
 * @date 2020/7/3 18:56
 * @see
 */
@Configuration
@ConditionalOnBean(value = {RobotstxtConfig.class,PageFetcher.class})
public class WebRobotstxtServer extends RobotstxtServer {
    public WebRobotstxtServer(RobotstxtConfig config, PageFetcher pageFetcher) {
        super(config, pageFetcher);
    }
}
