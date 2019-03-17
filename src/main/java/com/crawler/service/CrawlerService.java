package com.crawler.service;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.crawler.bean.ResultBean;
import com.crawler.bean.WebPage;

/**
 * 
 * @author Aman kumar
 *
 */
public class CrawlerService {
	private String fileName;

	public CrawlerService(String fileName) {
		this.fileName = fileName;
	}
	
	/*buildData method is used for parse the JSON from internet.json and building the data in the form of array of webPage */
	public WebPage[] buildData() {
		JSONParser jsonParser = new JSONParser();
		WebPage[] data = null;
		try {
			ClassLoader classLoder = ClassLoader.getSystemClassLoader();
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new InputStreamReader(new FileInputStream(classLoder.getResource(this.fileName).getPath())));
			JSONArray jsonarray = (JSONArray) jsonObject.get("pages");
			data = new WebPage[jsonarray.size()];
			for (int i = 0; i < jsonarray.size(); i++) {
				JSONObject object = (JSONObject) jsonarray.get(i);
				ArrayList<String> list = new ArrayList<>();
				JSONArray array = (JSONArray) object.get("links");
				for (int j = 0; j < array.size(); j++) {
					list.add((String) array.get(j));
				}
				data[i] = new WebPage((String) object.get("address"), list);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ResultBean response(WebPage[] data) {
		ResultBean result = new ResultBean();
		List<String> success = new ArrayList<>();
		List<String> skipped = new ArrayList<>();
		List<String> error = new ArrayList<>();

		success.add(data[0].getAddress());

		createData(data, data[0].getLinks(), success, skipped, error);

		result.setSuccess(success);
		result.setSkipped(skipped);
		result.setError(error);

		return result;
	}
/* main logic */
	private void createData(WebPage[] data, List<String> list, List<String> success, List<String> skipped,
			List<String> error) {

		for (String link : list) {
			WebPage page = containsLink(data, link);
			if (page == null) {
				if (!error.contains(link))
					error.add(link);
			} else if (!success.contains(link)) {
				success.add(link);
				if (!link.isEmpty())
					/* in case of success link, createData method calling recursively calling*/
					createData(data, page.getLinks(), success, skipped, error);
			} else {
				if (!skipped.contains(link)) {
					skipped.add(link);
				}
			}
		}

	}

	public WebPage containsLink(WebPage[] data, String address) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].getAddress().equals(address)) {
				return data[i];
			}
		}
		return null;
	}

}
