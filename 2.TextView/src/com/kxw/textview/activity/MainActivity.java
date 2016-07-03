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
		// tv.setText("你好！");
		// setContentView(tv);
		//------------------------------------------------------------------------
		// (设置颜色的第二种方法)
		// TextView tv=(TextView) findViewById(R.id.tv);
		// tv.setText(Html.fromHtml("大家好啊！！！！<font color=blue>我饿了</font>"));
		//------------------------------------------------------------------------
//		TextView tv = (TextView) findViewById(R.id.tv);
//		String str = "暴力式防守，疯狗式进攻，这是我的最爱!";
//		SpannableStringBuilder style = new SpannableStringBuilder(str);
//		style.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		style.setSpan(new ForegroundColorSpan(Color.RED), 6, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		style.setSpan(new ForegroundColorSpan(Color.GREEN), 12, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		tv.setText(style);
		// (设置颜色的第三种方法)
		//------------------------------------------------------------------------
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
