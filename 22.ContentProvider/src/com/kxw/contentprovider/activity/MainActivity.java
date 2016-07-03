package com.kxw.contentprovider.activity;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.DownloadManager.Query;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{

	protected static final int ONE = 1;
	protected static final int TWO = 2;
	private static final String TAG = "MainActivity";
	private Button btnAdd1;
	private Button btnAdd2;
	private Button btnUpdate1;
	private Button btnUpdate2;
	private Button btnQuery1;
	private Button btnQuery2;
	private Button btnDelete1;
	private Button btnDelete2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAdd1 = (Button) findViewById(R.id.btnAdd1);
		btnAdd2 = (Button) findViewById(R.id.btnAdd2);
		btnUpdate1 = (Button) findViewById(R.id.btnUpdate1);
		btnUpdate2 = (Button) findViewById(R.id.btnUpdate2);
		btnQuery1 = (Button) findViewById(R.id.btnQuery1);
		btnQuery2 = (Button) findViewById(R.id.btnQuery2);
		btnDelete1 = (Button) findViewById(R.id.btnDelete1);
		btnDelete2 = (Button) findViewById(R.id.btnDelete2);

		btnAdd1.setOnClickListener(listener);
		btnAdd2.setOnClickListener(listener);
		btnUpdate1.setOnClickListener(listener);
		btnUpdate2.setOnClickListener(listener);
		btnQuery1.setOnClickListener(listener);
		btnQuery2.setOnClickListener(listener);
		btnDelete1.setOnClickListener(listener);
		btnDelete2.setOnClickListener(listener);

	}

	private OnClickListener listener =	new OnClickListener()
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId())
			{
			case R.id.btnAdd1:
				add(ONE);
				break;

			case R.id.btnAdd2:
				add(TWO);
				break;
			case R.id.btnUpdate1:
				update(ONE);
				break;
			case R.id.btnUpdate2:
				update(TWO);
				break;
			case R.id.btnQuery1:
				query(ONE);
				break;
			case R.id.btnQuery2:
				query(ONE);
				break;
			case R.id.btnDelete1:
				delete(ONE);
				break;
			case R.id.btnDelete2:
				delete(TWO);
				break;

		
			}

		}

	};

	
	
	protected void add(int type){
		
		ContentResolver contentResolver=getContentResolver();
		Uri uri=null;
		ContentValues values=new ContentValues();
		
		switch (type)
		{
		case ONE:
			uri=Uri.parse("content://com.kxw.provider.studentprovider/student");
			values.put("name","Rooney");
			values.put("age", "27");
			Log.i(TAG, contentResolver.insert(uri, values).toString());
			break;
		case TWO:
			uri=Uri.parse("content://com.kxw.provider.studentprovider/student/1");//添加时指定id
			values.put("name","van Persie");
			values.put("age", "29");
			Log.i(TAG, contentResolver.insert(uri, values).toString());
			break;

		
		}
		
	}
	
	
protected void update(int type){
		
		ContentResolver contentResolver=getContentResolver();
		Uri uri=null;
		ContentValues values=new ContentValues();
		
		String where ="";
		String[] selectionArgs=null;
		switch (type)
		{
		case ONE:
			uri=Uri.parse("content://com.kxw.provider.studentprovider/student");
			values.put("name","Rooney");
			values.put("age", "27");
			where="sid=?";
			selectionArgs=new String[]{"1"};
			
			contentResolver.update(uri, values, where, selectionArgs);
			
			break;
		case TWO:
			uri=Uri.parse("content://com.kxw.provider.studentprovider/student/2");//添加时指定id
			values.put("name","van Persie");
			values.put("age", "29");
			where=null;
			selectionArgs=null;
			
			contentResolver.update(uri, values, where, selectionArgs);
			break;

		
		}
		
	}
	
	
protected void query(int type){
	
	ContentResolver contentResolver=getContentResolver();
	Uri uri=null;
	String[] projection=new String[]{"sid","name","age"};
	String selection="";
	String[] selectionArgs=null;
	String sortOrder="";
	Cursor cursor=null;
	ContentValues values=new ContentValues();
	
	switch (type)
	{
	case ONE:
		uri=Uri.parse("content://com.kxw.provider.studentprovider/student");
		selection="sid<?";
		selectionArgs=new String[]{"3"};
		cursor=contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
		while (cursor.moveToNext())
		{
	Log.i(TAG, "sid="+cursor.getInt(0)+";name="+cursor.getString(1)+";age="+cursor.getShort(2));			
		}
		break;
	case TWO:
		uri=Uri.parse("content://com.kxw.provider.studentprovider/student/1");
		
		cursor=contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
		while (cursor.moveToNext())
		{
	Log.i(TAG, "sid="+cursor.getInt(0)+";name="+cursor.getString(1)+";age="+cursor.getShort(2));			
		}
		break;

	
	}
	
}
	
	
protected void delete(int type){
	
	ContentResolver contentResolver=getContentResolver();
	Uri url=null;
	String where ="";
	String[] selectionArgs=null;
	
	switch (type)
	{
	case ONE:
		url=Uri.parse("content://com.kxw.provider.studentprovider/student");
		where="sid in (?,?)";
		selectionArgs=new String[]{"1","2"};
		contentResolver.delete(url, where, selectionArgs);
		break;
	case TWO:
		url=Uri.parse("content://com.kxw.provider.studentprovider/student/2");
		where=null;
		selectionArgs=null;
		contentResolver.delete(url, where, selectionArgs);
		break;

	
	}
	
}
	
	
	}

	


