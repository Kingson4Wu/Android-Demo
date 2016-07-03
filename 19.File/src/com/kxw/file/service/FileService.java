package com.kxw.file.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class FileService
{
	
	public void save(OutputStream outputStream,String content) throws IOException{
		
		outputStream.write(content.getBytes());
		outputStream.close();
	}
	
	public String read(InputStream inputStream) throws IOException{
		
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		byte[] buffer=new byte[1024];
		int len;
		while ((len=inputStream.read(buffer))!=-1)//从文件中读入到数组buffer，返回所读取的字节数，若为-1，表示文件已读完
		{
			
			outputStream.write(buffer,0,len);//把数组buffer中的数据保存到缓冲区中
		}
		
		byte[] data =outputStream.toByteArray();//把缓冲区中的所有数据保存到data中
		outputStream.close();
		inputStream.close();
		return new String(data);
		
	}

}
