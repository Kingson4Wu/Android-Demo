package com.kxw.service.activity;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BinderService extends Service
{
	private static final String TAG = "BinderService";
	private MyBinder binder =new MyBinder();
	
	public class MyBinder extends Binder{
		
		public BinderService getService(){
			
			return BinderService.this;
		}
		
	}
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return binder;
	}
	
	public void MyMethod(){
		
		
		Log.i(TAG, "MyMethod()");
	}
	
	

}
