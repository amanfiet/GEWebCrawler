package com.crawler.app;

import com.crawler.bean.ResultBean;
import com.crawler.bean.WebPage;
import com.crawler.service.CrawlerService;
/**
 *  WebCrawler as software that requests pages from the Internet,
 *   parses the content to extract all the links in the page, 
 *   and visits the links to crawl those pages, to an infinite depth
 * 
 * @author Aman kumar
 *
 */
public class WebCrawler {
	public static void main(String[] args) {
		CrawlerService service = new CrawlerService("internet.json");
		WebPage[] data = service.buildData();
		ResultBean result = new ResultBean();
		result = service.response(data);
		System.out.println("Success : "+result.getSuccess());
		System.out.println("Skipped : "+result.getSkipped());
		System.out.println("Error : "+result.getError());
	}	
}
