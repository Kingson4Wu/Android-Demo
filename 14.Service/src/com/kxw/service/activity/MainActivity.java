package com.kxw.service.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{

	private Button btnStartService=null;
	private Button btnStopService=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStartService=(Button)findViewById(R.id.btnStartService);
		btnStopService=(Button)findViewById(R.id.btnStopService);
		
		btnStartService.setOnClickListener(listener);
		btnStopService.setOnClickListener(listener);
	}

	private OnClickListener listener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent=new Intent(MainActivity.this,ExampleService.class);
			switch (v.getId())
			{
			case R.id.btnStartService:
				
				startService(intent);
				
				break;

				case R.id.btnStopService:
				stopService(intent);
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
