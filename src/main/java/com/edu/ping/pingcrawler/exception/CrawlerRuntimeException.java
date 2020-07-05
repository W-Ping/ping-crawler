package com.edu.ping.pingcrawler.exception;

/**
 * @author liu_wp
 * @date 2020/7/3 20:04
 * @see
 */
public class CrawlerRuntimeException extends RuntimeException {
	/**
	 * @param message
	 */
	public CrawlerRuntimeException(String message){
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CrawlerRuntimeException(String message, Throwable cause){
		super(message, cause);
	}
}
