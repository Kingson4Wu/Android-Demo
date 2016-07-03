package com.kxw.activity.activity;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity
{
	private final static String TAG="MainActivity";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		
		Log.i(TAG, "SecondActivity-->onCreate");
				
	}

	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "SecondActivity-->onDestroy");
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "SecondActivity-->onPause");
	}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "SecondActivity-->onRestart");
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "SecondActivity-->onResume");
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "SecondActivity-->onStart");
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "SecondActivity-->onStop");
	}





}

