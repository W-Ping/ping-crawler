package com.edu.ping.pingcrawler.service.webpage.impl;

import com.edu.ping.pingcrawler.pojo.entity.WebPageEntity;
import com.edu.ping.pingcrawler.pojo.res.ResultRes;
import com.edu.ping.pingcrawler.repository.IWebPageRepository;
import com.edu.ping.pingcrawler.service.webpage.IWebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lwp
 * @create 2020/07/04 19:43
 */
@Service
public class WebPageServiceImpl implements IWebPageService {
	@Autowired
	private IWebPageRepository iWebPageRepository;

	/**
	 * @param webPageEntity
	 * @return
	 */
	@Override
	public ResultRes saveWebPage(final WebPageEntity webPageEntity) {
		if (webPageEntity != null) {
			WebPageEntity save = iWebPageRepository.save(webPageEntity);
			return ResultRes.success(save);
		}
		return ResultRes.fail("保存失败");
	}
}
