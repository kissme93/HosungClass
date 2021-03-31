package com.example.hosungclass;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends Activity {
	private Button mButton01;
	private TextView mTextView01;
	private int mCount;
	private boolean mTimeWorking=false;
	private Handler mHandler=new Handler() {
		@Override
		public void handleMessage(Message msg) {
			mCount --;
			mTextView01.setText(""+mCount);
			if (mTimeWorking) {
				mHandler.sendMessageDelayed(mHandler.obtainMessage(), 1000);
			}
			if (mCount==0) {
				Toast.makeText(getBaseContext(),"Time Over!", Toast.LENGTH_LONG).show();
				mTimeWorking = false;
				mCount = 11;
			}
			super.handleMessage(msg);
		}		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCount=10;
		setContentView(R.layout.timer);
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mButton01.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				if (mTimeWorking==false) {
					mHandler.sendMessageDelayed(mHandler.obtainMessage(), 1000);	
					mButton01.setText("Stop");
				} else {
					mButton01.setText("Start");
				}
				mTimeWorking = !mTimeWorking;				
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
