package com.edu.ping.pingcrawler.pojo;

import lombok.Data;

import java.util.Set;

/**
 * @author liu_wp
 * @date 2020/7/3 19:29
 * @see
 */
@Data
public class CrawlCondition {
	/**
	 *
	 */
	private Set<PageUrl> pageUrls;
	/**
	 *
	 */
	private int numberOfCrawlers;

	/**
	 *
	 */
	private boolean isBlocking;

	/**
	 *
	 */
	private boolean storeWebPage = true;
}
