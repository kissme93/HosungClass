package com.example.hosungclass;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NumberBaseBallActivity extends Activity {
	private Button		mButton01;
	private EditText	mEditText01;
	private TextView 	mTextView01;
	private Random 		mRandom;
	private int[] 	 	mBaseball;
	private String		mStrBaseball;
	private int mCount=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numberbaseball);
		mRandom=new Random();
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mEditText01=(EditText)findViewById(R.id.editText1);
		mBaseball=new int[3];

		for(int i=0; i<3; i++) {
			do {
				mBaseball[i]=mRandom.nextInt(9)+1;
			} while(isRepeat(i));
		}
		mStrBaseball = ""+mBaseball[0]+mBaseball[1]+mBaseball[2];
		
		mButton01.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String editText = mEditText01.getText().toString();
				if(editText.length() !=3) {
					Toast.makeText(getBaseContext(), "3자리수를 입력하시오.", Toast.LENGTH_LONG).show();
					return;					
				}
				mCount++;
				String str=calculateBallCount(mStrBaseball, editText);
				if (str.equals("3S0B")) {
					mTextView01.setText("정답입니다.\n"+mCount+"번만에 맞추셨습니다.");
					
				}else{
					mTextView01.setText("result ="+str);
					
				}
				mEditText01.setText("");
				
			}
		});
		
	}

	private String calculateBallCount(String str1, String str2) {
		String[] inputStr1=new String[3];
		String[] inputStr2=new String[3];
		for(int i=0; i<3; i++) {
			inputStr1[i]=str1.substring(i, i+1);
			inputStr2[i]=str2.substring(i, i+1);
		}
		int ball = 0;
		int strike = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (inputStr1[i].equals(inputStr2[j])) {
					if(i==j) {
						strike++;
					} else {
						ball++;
					}
				}
			}

		}
		return strike+"S"+ball+"B";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean isRepeat(int num) {
		for(int i=0; i<num; i++) {
			if(mBaseball[i]==mBaseball[num]) {
				return true;				 
			}
		}
		return false;		
	}
	
}
