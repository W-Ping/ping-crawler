package com.edu.ping.pingcrawler.service.webpage;

import com.edu.ping.pingcrawler.pojo.entity.WebPageEntity;
import com.edu.ping.pingcrawler.pojo.res.ResultRes;

/**
 * @author lwp
 * @create 2020/07/04 19:43
 */
public interface IWebPageService {
	/**
	 * @param webPageEntity
	 * @return
	 */
	ResultRes saveWebPage(WebPageEntity webPageEntity);
}
