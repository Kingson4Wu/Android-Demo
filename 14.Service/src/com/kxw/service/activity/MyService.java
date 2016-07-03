package com.kxw.service.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
	protected static final String TAG = "IntentActivity";
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		new MyThread().start();
		
		return START_STICKY;
	}
	
	
	private class MyThread extends Thread {

		@Override
		public void run() {
			try
			{
				Log.i(TAG, "MyService线程ID："+Thread.currentThread().getId());
				Log.i(TAG, "文件下载。。。");
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	

}
