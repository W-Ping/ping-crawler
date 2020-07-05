package com.edu.ping.pingcrawler.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author liu_wp
 * @date 2020/7/3 18:01
 * @see
 */
@Data
@Entity
@Table(name = "webpage",schema="public")
public class WebPageEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long  id;
    @Column(name = "title")
    private String title;
    @Column(name = "html")
    private String html;
    @Column(name = "text")
    private String text;
    @Column(name = "url")
    private String url;
    @Column(name = "seen")
    private Timestamp seen;
}
