package com.kxw.service.activity;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ExampleIntentService extends IntentService
{
	protected static final String TAG = "IntentActivity";

	public ExampleIntentService()
	{
		super("ExampleIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		try
		{
			Log.i(TAG, "MyService�߳�ID��"+Thread.currentThread().getId());
			Log.i(TAG, "�ļ����ء�����");
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}

	}

}
