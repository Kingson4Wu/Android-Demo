package com.kxw.activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends Activity

{
	private final static String TAG="MainActivity";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);

		
		Log.i(TAG, "ThirdActivity-->onCreate");
				
	}

	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "ThirdActivity-->onDestroy");
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "ThirdActivity-->onPause");
	}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "ThirdActivity-->onRestart");
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "ThirdActivity-->onResume");
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "ThirdActivity-->onStart");
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "ThirdActivity-->onStop");
	}





}

