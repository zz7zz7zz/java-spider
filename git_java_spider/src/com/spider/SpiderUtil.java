package com.spider;

public class SpiderUtil {

	public static void fetch(ISpider mISpider,String url)
	{
		if(null!=mISpider && null!=url)
		{
			String []param={url};
			mISpider.fetch(param);
			mISpider.onHandle();
			mISpider.onResponse();
		}
	}

}
