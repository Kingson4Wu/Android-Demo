package com.kxw.service.activity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentActivity extends Activity
{

protected static final String TAG = "IntentActivity";
private Button btnStartNormalService=null;
private Button btnStartIntentService=null;


@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.intent);
	
	
	btnStartNormalService=(Button)findViewById(R.id.btnStartNormalService);
	btnStartIntentService=(Button)findViewById(R.id.btnStartIntentService);
	
	btnStartNormalService.setOnClickListener(listener);
	btnStartIntentService.setOnClickListener(listener);
	
	
}
private OnClickListener listener=new OnClickListener()
{
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent;
		switch (v.getId())
		{
		case R.id.btnStartNormalService:
			
			intent=new Intent(IntentActivity.this,MyService.class);
			Log.i(TAG, "主线程ID："+Thread.currentThread().getId());
			startService(intent);
			
			break;

			case R.id.btnStartIntentService:
				
			intent=new Intent(IntentActivity.this,ExampleIntentService.class);
			Log.i(TAG, "主线程ID："+Thread.currentThread().getId());
			startService(intent);			
				
			
			break;
		}
		
		
		
	}

	
};


}
