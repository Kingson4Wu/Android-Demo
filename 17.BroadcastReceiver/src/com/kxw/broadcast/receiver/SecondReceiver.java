package com.kxw.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SecondReceiver extends BroadcastReceiver
{

	private static final String TAG = "MyReceiver";

	
	
	
	
	public SecondReceiver()
	{
		Log.i(TAG, "SecondReceiver");
	}





	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub

		Log.i(TAG, "onReceive");
	}

}
