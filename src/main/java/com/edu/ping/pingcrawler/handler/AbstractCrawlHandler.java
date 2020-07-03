package com.edu.ping.pingcrawler.handler;

import com.edu.ping.pingcrawler.exception.CrawlerRuntimeException;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.regex.Pattern;

/**
 * @author liu_wp
 * @date 2020/7/3 18:19
 * @see
 */
public abstract class AbstractCrawlHandler<T extends WebCrawler> extends WebCrawler implements IWebCrawlHandler {

    private static final Pattern FILE_ENDING_EXCLUSION_PATTERN = Pattern.compile(".*(\\.(" +
            "css|js" +
            "|bmp|gif|jpe?g|JPE?G|png|tiff?|ico|nef|raw" +
            "|mid|mp2|mp3|mp4|wav|wma|flv|mpe?g" +
            "|avi|mov|mpeg|ram|m4v|wmv|rm|smil" +
            "|pdf|doc|docx|pub|xls|xlsx|vsd|ppt|pptx" +
            "|swf" +
            "|zip|rar|gz|bz2|7z|bin" +
            "|xml|txt|java|c|cpp|exe" +
            "))$");

    @Override
    public final boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILE_ENDING_EXCLUSION_PATTERN.matcher(href).matches() && shouldVisit();
    }
    @Override
    public boolean shouldVisit() {
        return true;
    }

    @Override
    public void visit(Page page) {
        try {
            webPage(page);
        } catch (CrawlerRuntimeException e) {
            logger.error("Storing failed", e);
        }
    }

    abstract void webPage(Page webPage) throws CrawlerRuntimeException;

    public Class<T> getWebCrawlerClass(){
        return null;
    }
}
