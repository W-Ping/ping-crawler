package com.edu.ping.pingcrawler.controller;

import com.edu.ping.pingcrawler.handler.CrawStartHandler;
import com.edu.ping.pingcrawler.pojo.CrawlCondition;
import com.edu.ping.pingcrawler.pojo.res.ResultRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lwp
 * @create 2020/07/04 09:13
 */
@Controller
public class CrawlerWebController {
	@Autowired
	private CrawStartHandler crawStartHandler;

	@PostMapping(value = "/crawler/{webSiteId}")
	@ResponseBody
	public ResultRes crawler(@RequestBody CrawlCondition crawlCondition, @PathVariable("webSiteId") String webSiteId) {
		crawStartHandler.start(webSiteId, crawlCondition);
		return ResultRes.success(null);
	}

	/**
	 * @return
	 */
	@GetMapping(value = "/crawler/index")
	public String crawlerPage() {
		return "crawler_log_msg";
	}
}
