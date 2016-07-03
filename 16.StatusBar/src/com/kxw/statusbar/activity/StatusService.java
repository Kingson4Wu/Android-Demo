package com.kxw.statusbar.activity;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

public class StatusService extends IntentService
{

	private static final String TAG = "StatusService";
	//private static final int KINGSON = 0;

	public StatusService()
	{
		super("StatusService");
		
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		
		
		Log.i(TAG, "开始下载。。。");
		showNotification();
		try
		{
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.i(TAG, "下载完毕");
	}

	private void showNotification() {
		// TODO Auto-generated method stub
		
		Notification notification=new Notification(R.drawable.real_madrid,"开始下载",System.currentTimeMillis());
		Intent intent=new Intent(this,MainActivity.class);
		PendingIntent contentIntent=PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
		notification.setLatestEventInfo(this, "下载", "开始下载中", contentIntent);
		NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		//manager.notify(KINGSON,notification);
		manager.notify(R.layout.activity_main,notification);
	}

}
