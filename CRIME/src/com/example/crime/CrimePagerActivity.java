package com.example.crime;

import java.util.ArrayList;
import java.util.UUID;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class CrimePagerActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<OneCrime> mCrimes;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	mViewPager = new ViewPager(this);
	mViewPager.setId(R.id.viewPager);
	setContentView(mViewPager);
	
	
	
	mCrimes = CrimeLab.get(this).getCrimes();
	FragmentManager fm = getSupportFragmentManager();
	mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
	@Override
	public int getCount() {
	return mCrimes.size();
	
	}
	@Override
	public android.support.v4.app.Fragment getItem(int pos) {
	OneCrime crime = mCrimes.get(pos);
	return CrimeFragment.newInstance(crime.getmId());
	}
	});
	
	
	UUID crimeId = (UUID)getIntent()
			.getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
			for (int i = 0; i < mCrimes.size(); i++) {
			if (mCrimes.get(i).getmId().equals(crimeId)) {
			mViewPager.setCurrentItem(i);
			break;
}
}
	}
}
