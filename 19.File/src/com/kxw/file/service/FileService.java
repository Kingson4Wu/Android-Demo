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
		while ((len=inputStream.read(buffer))!=-1)//���ļ��ж��뵽����buffer����������ȡ���ֽ�������Ϊ-1����ʾ�ļ��Ѷ���
		{
			
			outputStream.write(buffer,0,len);//������buffer�е����ݱ��浽��������
		}
		
		byte[] data =outputStream.toByteArray();//�ѻ������е��������ݱ��浽data��
		outputStream.close();
		inputStream.close();
		return new String(data);
		
	}

}
