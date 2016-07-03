package com.kxw.activity.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private final static String TAG="MainActivity";
	private Button secondBtn=null;
	private Button thirdBtn=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		secondBtn=(Button)findViewById(R.id.secondBtn);
		thirdBtn=(Button)findViewById(R.id.thirdBtn);
		
		secondBtn.setOnClickListener(listener);
		thirdBtn.setOnClickListener(listener);
		
		Log.i(TAG, "MainActivity-->onCreate");
				
	}

	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "MainActivity-->onDestroy");
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "MainActivity-->onPause");
	}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "MainActivity-->onRestart");
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "MainActivity-->onResume");
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "MainActivity-->onStart");
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "MainActivity-->onStop");
	}

private OnClickListener listener=new OnClickListener()
{
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button btn=(Button)v;
		Intent intent=new Intent();
		switch (btn.getId())
		{
		case R.id.secondBtn:
			intent.setClass(MainActivity.this, SecondActivity.class);
			break;
		case R.id.thirdBtn:
			intent.setClass(MainActivity.this, ThirdActivity.class);
			break;
		}
		startActivity(intent);
	}
};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} 

}
