package com.spider.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetUtil {
	
	public static final int FORMAT_IMAGE=1;
	public static final int FORMAT_VIDEO=2;
	public static final int FORMAT_TEXT=3;
	
	public static String Http(String url)
	{
		return null;
	}
	
	public static String XHttp(String url,int port)
	{
		String ret = null;
		
		Socket mSocket=null;
		OutputStream os=null;
		InputStream ins=null;
		try {
			String host=getHost(url);
			
			mSocket=new Socket(host, port);
			os=mSocket.getOutputStream();
			ins=mSocket.getInputStream();
			
			StringBuffer sb=new StringBuffer();
			sb.append("GET ").append(url).append(" HTTP/1.1").append("\r\n");
			sb.append("Host").append(": ").append(host).append("\r\n");
			sb.append("Connection").append(": ").append("Close").append("\r\n");
			sb.append("Accept").append(": ").append("*/*").append("\r\n");
			sb.append("\r\n");//end
			
			os.write(sb.toString().getBytes());
			os.flush();
			
			sb=new StringBuffer();
			BufferedReader br=new BufferedReader(new InputStreamReader(ins));  
			String str=null;  
			while((str=br.readLine())!=null)  
			{  
				sb.append(str);
				System.out.println(str);  
			};
			br.close();
			ret=sb.toString();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=mSocket)
			{
				try {
					mSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(null!=os)
			{
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(null!=ins)
			{
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return ret;
	}
	
	
	public static String getHost(String url)
	{
		String ret = "/";
		Pattern p = Pattern.compile("[^http://][^/]*",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(url);
		if(m.find())
		{
			ret=m.group();
		}
		else
		{
			ret=url;
		}
		return ret;
	}

}
