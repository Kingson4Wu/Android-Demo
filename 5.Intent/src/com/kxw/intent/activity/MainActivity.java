package com.kxw.intent.activity;



import android.net.Uri;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button mainBtn=null;
	private Button sendSms=null;
	private Button nextActivity=null;
	
	private final static int REQUEST_CODE=1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mainBtn=(Button)findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(listener);
        
        sendSms=(Button)findViewById(R.id.sendSms);
        sendSms.setOnClickListener(listener2);
        
        nextActivity=(Button)findViewById(R.id.nextActivity);
        nextActivity.setOnClickListener(listener3);
        
    }
    private OnClickListener listener = new OnClickListener()
	{
		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:110"));
			startActivity(intent);
			
			

		}
	};
	
	
	 private OnClickListener listener2 = new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("smsto:5554"));
				intent.putExtra("sms_body", "You are a beautiful man.");
				startActivity(intent);
				
				

			}
		};
		
		
		
		
		
		
	
		private OnClickListener listener3 = new OnClickListener()
			{
				@Override
				public void onClick(View v) {
					Intent intent=new Intent();
					intent.setClass(MainActivity.this, SecondActivity.class);
					intent.putExtra("str", "life lose passion");//´«µÝ²ÎÊý
					
					//startActivity(intent);
					startActivityForResult(intent, REQUEST_CODE);
					

				}
			};

			
			 @Override
				protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				
				 
				 if(requestCode==REQUEST_CODE){
					 if(resultCode==SecondActivity.RESULT_CODE)
					 {
						 Bundle bundle=data.getExtras();
						 String str=bundle.getString("back");
						 Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
					 }
					 
					 
					 
					 
				 }
				 
				 
				}
			
			
			
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
