package com.edu.ping.pingcrawler.pojo;

import lombok.Data;

/**
 * @author liu_wp
 * @date 2020/7/3 19:26
 * @see
 */
@Data
public class PageUrl {
	private String url;
	private int docId = -1;
}
