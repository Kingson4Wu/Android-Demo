package com.kxw.handler.service;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class ExampleService extends Service
{

	private static final int kxw=1;
	private static final int KINGSON=2;
	private static final String TAG = "ExampleService";
	
	private ServiceHandler handler;
	
	private class ServiceHandler extends Handler{
		public ServiceHandler(Looper looper){
			
			super(looper);		
		}

		@Override
		public void handleMessage(Message msg) {
			
			switch (msg.what)
			{
			case kxw:
				Log.i(TAG, "handleMessage-->"+msg.obj);
				break;
			case KINGSON:
				Log.i(TAG, "handleMessage-->"+msg.obj);

			default:
				break;
			}
			
			stopSelf(msg.arg1);
		
		}
		
		
		
		
	}
	
	
	
	
	
	@Override
	public void onCreate() {
		Log.i(TAG, "ExampleService-->onCreate()");
		Looper looper=Looper.getMainLooper();
		handler=new ServiceHandler(looper);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		
		Log.i(TAG, "ExampleService-->onStartCommand");
		Message msg=handler.obtainMessage();
		msg.what=KINGSON;
		msg.arg1=startId;
		msg.obj="kingson";
		handler.sendMessage(msg);
		
		return START_STICKY;
	}





	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
