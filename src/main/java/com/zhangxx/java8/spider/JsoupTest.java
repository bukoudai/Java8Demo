package com.zhangxx.java8.spider;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.lang.String.format;


public class JsoupTest {

    public static void main(String[] args) {
        String url = "https://www.baidu.com/s?wd=jsoup&rsv_spt=1&rsv_iqid=0x9f8f8f8f&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=1&rsv_sug1=1&rsv_sug2=1&inputT=0";
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Elements newsHeadlines = doc.select("#content_left .c-title a");
        for (Element headline : newsHeadlines) {
           String title =     headline.text();

            System.out.println(format("%s\n\t%s",
                    title, headline.absUrl("href")))   ;
        }
    }
}
