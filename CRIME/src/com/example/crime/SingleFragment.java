package com.example.crime;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class SingleFragment extends FragmentActivity {

	protected abstract android.support.v4.app.Fragment createFragment();
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime);
	
		android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		android.support.v4.app.Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
			.add(R.id.fragmentContainer, fragment)
			.commit();
			}
	}
}
	

