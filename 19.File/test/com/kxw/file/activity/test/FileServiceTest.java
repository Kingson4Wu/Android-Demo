package com.kxw.file.activity.test;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.kxw.file.service.FileService;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;


public class FileServiceTest extends AndroidTestCase
{

	private static final String TAG = "FileServiceTest";

	public void testSave() throws IOException  {
		OutputStream outputStream=this.getContext().openFileOutput("kxw.txt", Context.MODE_PRIVATE);
	FileService fileService=new FileService();
	fileService.save(outputStream, "wo yao fei");
	
	}

	public void testRead() throws IOException {
		InputStream inputStream=this.getContext().openFileInput("kxw.txt");
		FileService fileService=new FileService();
		String content=fileService.read(inputStream);
		Log.i(TAG, content);
	}

}
