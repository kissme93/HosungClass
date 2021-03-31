package com.example.hosungclass;

import com.example.hosungclass.R;
import com.example.hosungclass.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MoleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MoleView(getBaseContext()));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
