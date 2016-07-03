package com.kxw.test.activity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity
{

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String str=test();
		Log.i(TAG, str);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public String test() {
		
		int i=10;
		int j=100;
		int k=i+j;
		String str="android"+k;
		return str;
		
	}
	
	
	
}
