package com.spider;

public class SpiderUtil {

	public static void fetch(ISpider mISpider,String url)
	{
		if(null!=mISpider && null!=url)
		{
			mISpider.fetch(url);
			mISpider.onHandle();
			mISpider.onResponse();
		}
	}

}
