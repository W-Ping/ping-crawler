package com.edu.ping.pingcrawler.controller.ws;

import com.edu.ping.pingcrawler.constant.GlobalConsts;
import com.edu.ping.pingcrawler.pojo.req.ws.CrawlerLogMsgReq;
import com.edu.ping.pingcrawler.pojo.res.ResultRes;
import com.edu.ping.pingcrawler.pojo.ws.ClientMessage;
import com.edu.ping.pingcrawler.pojo.ws.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import websocket.CrawlerLogWebSocketServer;

/**
 * @author lwp
 * @create 2020/07/05 21:20
 */
@RestController
public class CrawlerWsLogMsgController {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	/**
	 * @param crawlerLogMsgReq
	 * @return
	 */
	@PostMapping(value = "/pushCrawPageLogMsg")
	public ResultRes pushCrawPageLogMsg(@RequestBody CrawlerLogMsgReq crawlerLogMsgReq) {
		CrawlerLogWebSocketServer.sendMessage2allClients("crawl page url===》" + crawlerLogMsgReq.toString());
		return ResultRes.success(crawlerLogMsgReq.getCrawlUrl());
	}

	@MessageMapping(GlobalConsts.HELLO_MAPPING)
	@SendTo(GlobalConsts.TOPIC)
	public ServerMessage greeting(ClientMessage message) throws Exception {
		// 模拟延时，以便测试客户端是否在异步工作
		Thread.sleep(1000);
		return new ServerMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

	@PostMapping(value = "/pushMsg")
	public void pushMsg(@RequestBody  ClientMessage message) throws Exception {
		ServerMessage serverMessage = new ServerMessage("你好！, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		messagingTemplate.convertAndSend(GlobalConsts.TOPIC, serverMessage);
	}
}
