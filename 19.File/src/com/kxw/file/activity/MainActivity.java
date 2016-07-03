package com.kxw.file.activity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.kxw.file.service.FileService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
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
	private Button btnRead;
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSave=(Button)findViewById(R.id.btnSave);
		btnRead=(Button)findViewById(R.id.btnRead);
		btnSave.setOnClickListener(listener);
		btnRead.setOnClickListener(listener);
	}

	
	private OnClickListener listener=new OnClickListener()
	{
		
		FileService service=new FileService();
		EditText editName=(EditText)findViewById(R.id.editName);
		EditText editConTent=(EditText)findViewById(R.id.editContent);
		
		TextView textResult=(TextView)findViewById(R.id.textResult);
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.btnSave:
				
				try
				{
					OutputStream outputStream=MainActivity.this.openFileOutput(editName.getText().toString()+".txt", Context.MODE_APPEND);
					service.save(outputStream,editConTent.getText().toString());
					Toast.makeText(MainActivity.this, "±£´æ³É¹¦£¡", Toast.LENGTH_LONG).show();
					
				} catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

			case R.id.btnRead:
				
				InputStream inputStream;
				try
				{
					inputStream = MainActivity.this.openFileInput(editName.getText().toString());
					
					String content=service.read(inputStream);
					
					textResult.setText(content);
				
				} catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
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
