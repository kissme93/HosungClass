package com.example.hosungclass;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeedNumberActivity extends Activity {
	private Button mButton01;
	private TextView mTextView01;
	private long mOldTime;
	 
	private Handler mHandler=new Handler() {
		@Override
		public void handleMessage(Message msg) {			
			long currentTime = System.currentTimeMillis();
			long elapsedTime = currentTime - mOldTime;
			mTextView01.setText(String.format("%.2f", (float)elapsedTime/1000));
			mHandler.sendMessageDelayed(mHandler.obtainMessage(), 10);
			super.handleMessage(msg);
		}		
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.speed_number);
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mButton01.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				mOldTime = System.currentTimeMillis(); 
				mHandler.sendMessageDelayed(mHandler.obtainMessage(), 10);
				
			}
		});
		super.onCreate(savedInstanceState);
	}

}
