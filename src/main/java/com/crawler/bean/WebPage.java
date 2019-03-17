package com.crawler.bean;

import java.util.List;

/**
 * 
 * @author Aman kumar
 *
 */
public class WebPage {
	private String address;
	private List<String> links;
	
	public WebPage(String address, List<String> links) {
		this.address = address;
		this.links = links;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getLinks() {
		return links;
	}
	public void setLinks(List<String> links) {
		this.links = links;
	}

}
