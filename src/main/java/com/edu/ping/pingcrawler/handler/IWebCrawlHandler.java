package com.edu.ping.pingcrawler.handler;

/**
 * @author liu_wp
 * @date Created in 2020/7/3 20:36
 * @see
 */
public interface IWebCrawlHandler<T> {
    boolean shouldVisit();

    /**
     * @return
     */
    Class<T> getWebCrawlerClass();
}
