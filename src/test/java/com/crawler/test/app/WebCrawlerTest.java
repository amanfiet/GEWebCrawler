package com.crawler.test.app;

import org.junit.Test;

import com.crawler.bean.ResultBean;
import com.crawler.bean.WebPage;
import com.crawler.service.CrawlerService;

/**
 * 
 * @author Aman kumar
 *
 */
public class WebCrawlerTest {
	
	static final String internet_1="internet_1.json";
	static final String internet_2="internet_2.json";
	static final String internet_3="internet_3.json";
/* for test internet_1.json data */
	@Test
	public void testInternet_1()
	{
		CrawlerService service = new CrawlerService(internet_1);
		WebPage[] data = service.buildData();
		ResultBean result = new ResultBean();
		result = service.response(data);
		System.out.println("Success : "+result.getSuccess());
		System.out.println("Skipped : "+result.getSkipped());
		System.out.println("Error : "+result.getError());
        System.out.println();

		
	}
	/* for test internet_2.json data */
	@Test
	public void testInternet_2()
	{
		CrawlerService service = new CrawlerService(internet_2);
		WebPage[] data = service.buildData();
		ResultBean result = new ResultBean();
		result = service.response(data);
		System.out.println("Success : "+result.getSuccess());
		System.out.println("Skipped : "+result.getSkipped());
		System.out.println("Error : "+result.getError());
        System.out.println();
		
	}
	/* for test internet_3.json data */
     @Test
	public void testInternet_3()
	{
		CrawlerService service = new CrawlerService(internet_3);
		WebPage[] data = service.buildData();
		ResultBean result = new ResultBean();
		result = service.response(data);
		System.out.println("Success : "+result.getSuccess());
		System.out.println("Skipped : "+result.getSkipped());
		System.out.println("Error : "+result.getError());

		
	}


}
