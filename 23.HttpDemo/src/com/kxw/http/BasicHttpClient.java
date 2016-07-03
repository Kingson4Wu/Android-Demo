package com.kxw.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;



public class BasicHttpClient
{
	
	private static final int TIME_OUT = 1000*6;//³¬Ê±
	private static final String METHOD_GET = "GET";
	private static final String METHOD_POST = "POST";
	private static final int HTTP_OK = 200;
	
	
	
	public String httpGet(String urlstr){
		
		URL url=null;
		HttpURLConnection conn=null;
		InputStream inputStream=null;
		String response=null;
		
		
		
			
			
				try
				{
					
					url=new URL(urlstr);
					conn=(HttpURLConnection)url.openConnection();
					conn.setDoInput(true);
					conn.setConnectTimeout(TIME_OUT);
					conn.setRequestMethod(METHOD_GET);
					conn.setRequestProperty("accept", "*/*");
					conn.connect();
					int responseCode=conn.getResponseCode();
					if (responseCode==HTTP_OK)
					{
						inputStream=conn.getInputStream();
						response=getResponse(inputStream);
						
					}
					else {
						return "·µ»ØÂë£º"+responseCode;
					}
					
					
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					
					conn.disconnect();
				}
				
				
				return response;
				
				
				
				
				
				
				
	}
			
	/*public String httpPost(String urlstr,String params){
		
		
		
		
		byte[] data =params.getBytes();

		URL url=null;
		HttpURLConnection conn=null;
		InputStream inputStream=null;
		String response=null;
		
		try
		{
			
		
		url=new URL(urlstr);
		conn=(HttpURLConnection)url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setConnectTimeout(TIME_OUT);
		conn.setRequestMethod(METHOD_POST);
		
		conn.connect();
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
			
		private String getResponse(InputStream inputStream) throws IOException{
			
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
			int len=-1;
			byte[] buffer=new byte[1024];
			
			while((len=inputStream.read(buffer))!=-1){
				
				outputStream.write(buffer, 0, len);
				
			}
			byte[] data=outputStream.toByteArray();
			return new String(data);
			
		}
	
		
		
	}
	
	
	
	
	
	
	

