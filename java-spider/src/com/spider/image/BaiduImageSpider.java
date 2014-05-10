package com.spider.image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.ISpider;
import com.spider.net.NetUtil;

public class BaiduImageSpider implements ISpider {

	String httpData;
	
	
	@Override
	public void fetch(String... param) {
		
		httpData=NetUtil.XHttp(param[0], 80);
		
	}

	@Override
	public void onHandle() {
		
		String tagData=getTags(httpData);
		httpData=null;
		System.out.println(tagData);
	}

	@Override
	public void onResponse() {
		// TODO Auto-generated method stub
		
	}

	private String getTags(String httpData)
	{
		String ret = "";
		Pattern p = Pattern.compile("[^(tags\\-box)][^</ul>]*",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(httpData);
		if(m.find())
		{
			ret=m.group();
		}
		return ret;
	}

}
