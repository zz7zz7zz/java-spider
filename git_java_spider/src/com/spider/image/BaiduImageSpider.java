package com.spider.image;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.IFetchResponse;
import com.spider.ISpider;
import com.spider.net.NetUtil;

public class BaiduImageSpider implements ISpider {

	IFetchResponse listener;
	String httpData;
	ArrayList<ClassBean> mList=new ArrayList<ClassBean>();
	
	
	public BaiduImageSpider(IFetchResponse listener) {
		super();
		this.listener = listener;
	}


	@Override
	public void fetch(String[] param) {
		httpData=NetUtil.XHttp(param[0], 80);
	}
	
	@Override
	public void onHandle() {
		
		String tagData=getTags(httpData);
		httpData=null;
		handleTagDetail(tagData);
	}

	@Override
	public void onResponse() {
		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i));
		}
		
		if(null !=listener)
		{
			listener.onResponse(mList);
		}
	}

	private String getTags(String httpData)
	{
		String ret = "";
		Pattern p = Pattern.compile("tags\\-box(.+?)</ul>",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(httpData);
		if(m.find())
		{
			ret=m.group(1);
		}
		return ret;
	}
	
	private void handleTagDetail(String tagData)
	{
		if(null!=tagData&&!tagData.isEmpty())
		{
			Pattern pattern = Pattern.compile("href=\"(.+?)\">(.+?)</a>");   
			while(true) 
			{   
				  Matcher matcher = pattern.matcher(tagData);
				  if(matcher.find())
				  {
					  tagData=tagData.substring(matcher.end());
					  
					  ClassBean item=new ClassBean();
					  item.title=matcher.group(2);
					  item.link="http://image.baidu.com/channel"+matcher.group(1);
					  mList.add(item);
				  }
				  else
				  {
					  break;
				  }
			} 
		}
	}
	
}
