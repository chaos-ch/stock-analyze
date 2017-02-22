package com.ch.sa.crawl.crawl.service;

import com.ch.base.lang.net.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by he.chen on 11/12/16.
 */
public abstract class AbstractCrawler<T> implements Crawler<T> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public T fetch(String param) {

        try {
            String content = HttpUtil.getContent(url(param), 3);
            return parseResponse(content);
        } catch (Exception e) {
            logger.error("http get content error", e);
        }
        return null;

    }


    public static void main(String[] args) {
        try {
            System.out.println(System.currentTimeMillis());
            String content = HttpUtil.getContent("http://nufm.dfcfw.com%2fEM_Finance2014NumericApplication%2fJS.aspx%3ftype%3dCT%26cmd%3dC._A%26sty%3dFCOIATA%26sortType%3dC%26sortRule%3d-1%26page%3d1%26pageSize%3d4000%26js%3dvar%2520quote_123%253d%7brank%3a%5b(x)%5d%2cpages%3a(pc)%7d%26token%3d7bc05d0d4c3c22ef9fca8c2a912d779c%26jsName%3dquote_123%26_g%3d0.055224825584601955");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
