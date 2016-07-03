package com.kxw.activity.activity;

import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
	private final static String TAG="MainActivity";
	private static final String CONTENT = "content";
	private Button secondBtn=null;
	private EditText txt=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		secondBtn=(Button)findViewById(R.id.secondBtn);
		secondBtn.setOnClickListener(listener);
		
	txt=(EditText)findViewById(R.id.txt);
	
	if(null!=savedInstanceState&&savedInstanceState.containsKey(CONTENT)){
		
		txt.setText(savedInstanceState.getString(CONTENT));
	}
		
		
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
		if(btn.getId()==R.id.secondBtn)
			intent.setClass(MainActivity.this, SecondActivity.class);
		
		startActivity(intent);
	}
};



	@Override
protected void onSaveInstanceState(Bundle outState) {
	// TODO Auto-generated method stub
	super.onSaveInstanceState(outState);
	String context=txt.getText().toString();
	outState.putString(CONTENT, context);
	
	
	
}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} 

}
