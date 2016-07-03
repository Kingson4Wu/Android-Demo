package com.kxw.handler.activity;


import com.kxw.handledemo.activity.R;
import com.kxw.handler.service.ExampleService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	public Button btnStartService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStartService=(Button)findViewById(R.id.btnStartService);
		btnStartService.setOnClickListener(listener);
	}
	private OnClickListener listener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch (v.getId())
			{
			case R.id.btnStartService:
				Intent intent=new Intent(MainActivity.this,ExampleService.class);
				startService(intent);
				break;

			default:
				break;
			}
			
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
