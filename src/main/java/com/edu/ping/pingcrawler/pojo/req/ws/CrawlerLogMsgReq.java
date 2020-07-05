package com.edu.ping.pingcrawler.pojo.req.ws;

import lombok.Data;

/**
 * @author lwp
 * @create 2020/07/05 21:21
 */
@Data
public class CrawlerLogMsgReq {
	private String crawlUrl;
	private String message;

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return this.crawlUrl + ":" + this.message;
	}
}
