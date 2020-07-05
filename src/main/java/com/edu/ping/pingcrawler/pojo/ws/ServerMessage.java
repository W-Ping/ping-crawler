package com.edu.ping.pingcrawler.pojo.ws;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lwp
 * @create 2020/07/05 09:02
 */
@Data
@AllArgsConstructor
public class ServerMessage {
	private String content;

	public ServerMessage() {
	}

	@Override
	public String toString() {
		return content;
	}
}
