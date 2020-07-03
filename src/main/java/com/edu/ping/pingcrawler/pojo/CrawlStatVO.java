package com.edu.ping.pingcrawler.pojo;

import lombok.Data;

/**
 * @author liu_wp
 * @date 2020/7/3 12:11
 * @see
 */
@Data
public class CrawlStatVO {
    /**
     * 总链接数
     */
    private long totalLinks;
    /**
     *
     */
    private int totalProcessedPages;
    /**
     *
     */
    private long totalTextSize;
}
