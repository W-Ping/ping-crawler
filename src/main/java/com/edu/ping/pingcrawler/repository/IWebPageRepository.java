package com.edu.ping.pingcrawler.repository;

import com.edu.ping.pingcrawler.pojo.entity.WebPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lwp
 * @create 2020/07/04 21:50
 */
@Repository
public interface IWebPageRepository extends JpaRepository<WebPageEntity,Long> {
}
