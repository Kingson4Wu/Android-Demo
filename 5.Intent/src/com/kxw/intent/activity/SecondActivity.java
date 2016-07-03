package com.kxw.intent.activity;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity
{
	
	private TextView secondTxt;
	private Button secondBtn;
	
	public final static int RESULT_CODE=1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String str=bundle.getString("str");
        secondTxt=(TextView)findViewById(R.id.secondTxt);
        secondTxt.setText(str);
        
        
        secondBtn=(Button)findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(listener);
        
	}
	
	
	 private OnClickListener listener = new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
			intent.putExtra("back", "i am back.");
			setResult(RESULT_CODE, intent);
				finish();
	
			}
		};
	
	

}

