package com.example.hosungclass;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LottoActivity extends Activity {	
	private Button mButton01;
	private TextView mTextView01;
	private int[] mLotto;
	private Random mRandom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lotto);
		
		mRandom=new Random();
		mLotto=new int[6];
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mButton01.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				for(int i=0;i<6;i++) {					
					do {
						mLotto[i]=mRandom.nextInt(45)+1;
					} while(isRepeatition(i));
				}				
				for(int i=0;i<5;i++) {
					for(int j=i+1;j<6;j++) {
						if( mLotto[i] > mLotto[j] ) {
							int temp;
							temp = mLotto[i];
							mLotto[i] = mLotto[j];
							mLotto[j] = temp;
						}
					}
				}
				String str="";
				for(int i=0;i<6;i++) {
					str=str+mLotto[i]+"  ";
				}					
				mTextView01.setText(str);				
			}
		});
	}
	
	public boolean isRepeatition(int num) {
		for(int i=0;i<num;i++) {
			if( mLotto[i]== mLotto[num] )
				return true;
		}
		return false;		
	}
}
