package com.example.crime;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {
	private ArrayList<OneCrime> mCrimes;
	private static CrimeLab crimeLab;
	private Context context;
	
	
	private CrimeLab(Context appContext){
		context = appContext;
		
		mCrimes = new ArrayList<OneCrime>();
		
		for (int i = 0; i < 100; i++) {
			OneCrime c = new OneCrime();
			c.setmTitle("Crime #" + i);
			c.setmSolved(i % 2 == 0); // Для каждого второго объекта
			mCrimes.add(c);
			}
		
	}
	
	public static CrimeLab get(Context c) {
		if (crimeLab == null) {
		crimeLab = new CrimeLab(c.getApplicationContext());
		}
		return crimeLab;
		}
	
	
	public ArrayList<OneCrime>  getCrimes(){
		return mCrimes;
	}
	
	public OneCrime getCrime(UUID id) {
		for (OneCrime c : mCrimes) {
		if (c.getmId().equals(id))
		return c;
		}
		return null;
		}
	
	 
	

}
