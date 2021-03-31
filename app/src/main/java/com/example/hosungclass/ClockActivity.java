package com.example.hosungclass;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class ClockActivity extends Activity {
	private TextView mTextView01;
	private int[] mClock = {
			1, 59, 34
	};
	
	private Handler mHandler=new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Log.d("hosung.kim", "handleMessage()");
			mClock[2]++;
			if (mClock[2] == 60) {
				mClock[1]++;
				mClock[2]=0;
				
			}
			if (mClock[1] == 60) {
				mClock[0]++;
				mClock[1]=0;
			}
			if (mClock[0] == 12) {
				mClock[0]=1;				
			}
			
			mTextView01.setText(mClock[0]+":"+mClock[1]+":"+mClock[2]);
			mHandler.sendMessageDelayed(mHandler.obtainMessage(), 500);
			super.handleMessage(msg);
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clock);
		mTextView01=(TextView)findViewById(R.id.textView1);		
		mHandler.sendMessageDelayed(mHandler.obtainMessage(), 500);
		Log.d("hosung.kim", "onCreate()");		
	}
}
