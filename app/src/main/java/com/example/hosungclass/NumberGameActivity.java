package com.example.hosungclass;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NumberGameActivity extends Activity {
	private EditText mEditText01;
	private Button mButton01;
	private TextView mTextView01;
	private TextView mTextView02;
	private Random mRandom;
	private int mNumber;
	private int mCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numbergame);
		mRandom=new Random();
		mNumber=mRandom.nextInt(100)+1;
		
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mTextView02=(TextView)findViewById(R.id.textView2);
		mEditText01=(EditText)findViewById(R.id.editText1);
		mButton01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CharSequence cs = mEditText01.getText();
				int answer = Integer.parseInt(cs.toString());
				if (answer<mNumber) {
					mTextView02.setText(answer+" is smaller. try count : "+getScore(mCount));
				}else if (answer>mNumber) {
					mTextView02.setText(answer+"is bigger. try count : "+getScore(mCount));
				}else if (answer==mNumber) {
					mTextView02.setText("congratulation!!!! try count : "+getScore(mCount));
				}
				mEditText01.setText("");
				mCount=mCount+1;
			}
		});		
	}
	
	int getScore(int count) {
		return (90-mCount*10);
	}	
}
