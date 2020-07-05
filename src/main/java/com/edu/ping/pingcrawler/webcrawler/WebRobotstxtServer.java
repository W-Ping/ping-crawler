package com.edu.ping.pingcrawler.webcrawler;

import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @author liu_wp
 * @date 2020/7/3 18:56
 * @see
 */
public class WebRobotstxtServer extends RobotstxtServer {
	private final RobotstxtConfig robotstxtConfig;
	private final WebPageFetcher pageFetcher;

	public WebRobotstxtServer(RobotstxtConfig robotstxtConfig, WebPageFetcher pageFetcher) {
		super(robotstxtConfig, pageFetcher);
		this.robotstxtConfig = robotstxtConfig;
		this.pageFetcher = pageFetcher;
	}
}
