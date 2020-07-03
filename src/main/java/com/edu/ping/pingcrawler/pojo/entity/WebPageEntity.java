package com.edu.ping.pingcrawler.pojo.entity;

import lombok.Data;

/**
 * @author liu_wp
 * @date 2020/7/3 18:01
 * @see
 */
@Data
public class WebPageEntity {
    private int id;
    private String html;
    private String text;
    private String createTime;
}
