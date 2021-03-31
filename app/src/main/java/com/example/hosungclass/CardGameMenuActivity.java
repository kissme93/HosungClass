package com.example.hosungclass;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class CardGameMenuActivity extends Activity {
	private Button mButton01;
	private Button mButton02;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cardgamemenu);
		mButton01 = (Button)findViewById(R.id.button1);
		mButton01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CardGameMenuActivity.this, CardGameActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getBaseContext().startActivity(intent);
			}
		});
		
		mButton02 = (Button)findViewById(R.id.button2);
		mButton02.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				finish();
			}
		});		
	}
}