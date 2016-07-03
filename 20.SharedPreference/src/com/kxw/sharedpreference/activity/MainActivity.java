package com.kxw.sharedpreference.activity;


import android.os.Bundle;

import android.app.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{

	private Button btnSave;
	private Button btnDisplay;
	private EditText editName;
	private EditText editAge;
	private TextView textResult;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 btnSave=(Button)findViewById(R.id.btnSave);
		 btnDisplay=(Button)findViewById(R.id.btnDisplay);
		 editName=(EditText)findViewById(R.id.editName);
		 editAge=(EditText)findViewById(R.id.editAge);
		 textResult=(TextView)findViewById(R.id.textResult);
		 
		 btnSave.setOnClickListener(listener);
		 btnDisplay.setOnClickListener(listener);
	}

	private OnClickListener listener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v) {
			SharedPreferences pres=MainActivity.this.getSharedPreferences("kxw", Context.MODE_PRIVATE);
			switch (v.getId())
			{
			case R.id.btnSave:
				
				Editor editor=pres.edit();
				editor.putString("name", editName.getText().toString());
				editor.putInt("age", Integer.valueOf(editAge.getText().toString()));
				editor.commit();
				Toast.makeText(MainActivity.this, "±£´æ³É¹¦£¡", Toast.LENGTH_LONG).show();
				
				
				break;

			case R.id.btnDisplay:
				
				String name=pres.getString("name", "cannot find£¡");
				int age=pres.getInt("age", 0);
				String Henry=pres.getString("Henry", "226 goals");
				textResult.setText("Name:"+name+";Age:"+age+";Henry:"+Henry);
				break;
				
			default:
				break;
			}
			
		}
	};
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
