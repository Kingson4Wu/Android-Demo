package com.kxw.broadcast.activity;

import com.kxw.broadcast.receiver.SecondReceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{

	protected static final String ACTION ="com.kxw.broadcast.ACTION";
	private Button btnBroadcast;
	
	private Button btnRegisterReceiver;
	private Button btnUnRegisterReceiver;
	
	private SecondReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBroadcast=(Button)findViewById(R.id.btnBroadcast);
		
		btnRegisterReceiver=(Button)findViewById(R.id.btnRegisterReceiver);
		btnUnRegisterReceiver=(Button)findViewById(R.id.btnUnRegisterReceiver);
		
		btnBroadcast.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				
				
				Intent intent=new Intent();
				intent.setAction(ACTION);
				sendBroadcast(intent);
			}
		});
		
		btnRegisterReceiver.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
			
				receiver=new SecondReceiver();
				IntentFilter filter=new IntentFilter();
				filter.addAction(ACTION);
				registerReceiver(receiver, filter);
				
			}
		});
		
		
		btnUnRegisterReceiver.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				
				unregisterReceiver(receiver);
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
