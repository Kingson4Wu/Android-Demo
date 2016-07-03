package com.kxw.sqlite.activity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.view.Menu;

public class MainActivity extends Activity
{

	private static final int ONE = 1;
	private static final int TWO = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected void update(int type) {
		ContentResolver contentResolver=getContentResolver();
		Uri uri=null;
		ContentValues values=new ContentValues();
		String where="";
		String[] selectionArgs=null;
		switch (type)
		{
		case ONE:
			
			uri=Uri.parse("content://com.kxw.privider.studentprovider/student");
			values.put("name", "KAKA");
			values.put("age", "31");
			where ="sid=?";
			selectionArgs=new String[]{"1"};
			contentResolver.update(uri, values, where, selectionArgs);
			break;

		case TWO:

			uri=Uri.parse("content://com.kxw.privider.studentprovider/student/2");
			values.put("name", "KAKA");
			values.put("age", "31");
			where =null;
			selectionArgs=null;
			contentResolver.update(uri, values, where, selectionArgs);
			//参数uri找到对应的provider
			break;
		
		}
		
		
		
	}
	
	
	
	

}
