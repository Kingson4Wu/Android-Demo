package com.kxw.textview.activity;

import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;


public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TextView tv=new TextView(this);
		// tv.setText("��ã�");
		// setContentView(tv);
		//------------------------------------------------------------------------
		// (������ɫ�ĵڶ��ַ���)
		// TextView tv=(TextView) findViewById(R.id.tv);
		// tv.setText(Html.fromHtml("��Һð���������<font color=blue>�Ҷ���</font>"));
		//------------------------------------------------------------------------
//		TextView tv = (TextView) findViewById(R.id.tv);
//		String str = "����ʽ���أ��蹷ʽ�����������ҵ��!";
//		SpannableStringBuilder style = new SpannableStringBuilder(str);
//		style.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		style.setSpan(new ForegroundColorSpan(Color.RED), 6, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		style.setSpan(new ForegroundColorSpan(Color.GREEN), 12, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		tv.setText(style);
		// (������ɫ�ĵ����ַ���)
		//------------------------------------------------------------------------
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
