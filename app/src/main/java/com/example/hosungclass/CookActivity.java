package com.example.hosungclass;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CookActivity extends Activity {
	private Button 		mButton01;
	private TextView	mTextView01;
	private Random		mRandom;
	private int			mNumber;
	private String[]	mMenu = {
			"김밥",
			"김치볶음밥",
			"김치찌게",
			"닭도리탕",
			"라면"	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mRandom=new Random(); 
		setContentView(R.layout.cook);
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mButton01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mNumber=mRandom.nextInt(5);				
				String str = "오늘의 메뉴는 ";				
				str = str + mMenu[mNumber]+"입니다.";
				mTextView01.setText(str);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
