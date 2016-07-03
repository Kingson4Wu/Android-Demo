package com.kxw.service.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ExampleService extends Service
{
	
	
	
	

	private static final String TAG = "ExampleService";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i(TAG, "ExampleService-->onCreate");
		super.onCreate();
	
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
		Log.i(TAG, "ExampleService-->onDestroy");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ExampleService-->onStartCommand");
		return START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
