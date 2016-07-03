package com.kxw.service.activity;

import com.kxw.service.activity.BinderService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BinderActivity extends Activity
{
private Button btnStartBinderService=null;
private Button btnStopBinderService=null;

private boolean isConnected=false;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.binder);
	
	
	btnStartBinderService=(Button)findViewById(R.id.btnStartBinderService);
	btnStopBinderService=(Button)findViewById(R.id.btnStopBinderService);
	
	btnStartBinderService.setOnClickListener(listener);
	btnStopBinderService.setOnClickListener(listener);
	
	
}
private OnClickListener listener=new OnClickListener()
{
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		switch (v.getId())
		{
		case R.id.btnStartBinderService:
			
			bindService();
			
			break;

			case R.id.btnStopBinderService:
			unBind();
			break;
		}
		
		
		
	}

	
};
private void unBind() {
	// TODO Auto-generated method stub
	
	if(isConnected)
	{unbindService(conn);
	}
	
}

private void bindService() {
	// TODO Auto-generated method stub
	Intent intent=new Intent(BinderActivity.this,BinderService.class);
	bindService(intent,conn,Context.BIND_AUTO_CREATE);
}

private ServiceConnection conn=new ServiceConnection()
{
	
	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		// TODO Auto-generated method stub
		
		isConnected=false;
		
	}
	
	@Override
	public void onServiceConnected(ComponentName name, IBinder binder) {
		// TODO Auto-generated method stub
		
		MyBinder myBinder=(MyBinder)binder;
		BinderService service=myBinder.getService();
		service.MyMethod();
		
		isConnected=true;
	}
};







}
