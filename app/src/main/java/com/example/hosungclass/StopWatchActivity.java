package com.example.hosungclass;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopWatchActivity extends Activity {
	private Button 		mButton01;
	private Button 		mButton02;
	private TextView 	mTextView01;
	private TextView 	mTextView02;
	private int 		mCount;
	private String		mStr = "";
	private boolean 	mTimerWorking = false;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			mCount++;
			mTextView01.setText(""+mCount);
			if(mTimerWorking) {
				mHandler.sendMessageDelayed(mHandler.obtainMessage(), 1000);
			}
			super.handleMessage(msg);
		}
		
	};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stopwatch);
		mButton01=(Button)findViewById(R.id.button1);
		mButton02=(Button)findViewById(R.id.button2);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mTextView02=(TextView)findViewById(R.id.textView2);
		mButton01.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				if(mTimerWorking == false) {				
					mHandler.sendMessageDelayed(mHandler.obtainMessage(), 1000);
					mButton01.setText("stop");
				} else {
					mButton01.setText("start");
				}
				mTimerWorking = !mTimerWorking;
				
			}
		});
		mButton02.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				if (mTimerWorking==true) {
					mStr=mStr+mCount+"\n";
					mTextView02.setText(mStr);		
				}				
			}
		});
	}

}
