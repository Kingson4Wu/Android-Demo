package com.kxw.statusbar.activity;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private Button btnStartService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStartService=(Button)findViewById(R.id.btnStartService);
		btnStartService.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,StatusService.class);
				startService(intent);
			}
		});
	}
	
	

	@Override
	protected void onStart() {
		super.onStart();
		NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		manager.cancel(R.layout.activity_main);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
