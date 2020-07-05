package com.edu.ping.pingcrawler.constant;

/**
 * @author lwp
 * @create 2020/07/04 0:38
 */
public enum WebSiteEnum {
	/**
	 *
	 */
	ZIROOM("ziRoom","ziRoomWebCrawler");
	WebSiteEnum (String webSiteId,String webCrawlerBeanId){
		this.webSiteId=webSiteId;
		this.webCrawlerBeanId=webCrawlerBeanId;
	}
	private String webSiteId;
	private String webCrawlerBeanId;

	/**
	 * @param webSiteId
	 * @return
	 */
	public static String getWebCrawlerBeanId(String webSiteId){
		for (final WebSiteEnum value : values()) {
			if(value.getWebSiteId().equals(webSiteId)){
				return value.webCrawlerBeanId;
			}
		}
		return null;
	}
	public String getWebSiteId() {
		return webSiteId;
	}
	public String getWbCrawlerBeanId() {
		return webCrawlerBeanId;
	}

}
