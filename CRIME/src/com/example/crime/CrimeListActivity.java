package com.example.crime;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class CrimeListActivity extends SingleFragment {

	@Override
	protected android.support.v4.app.Fragment createFragment() {
		android.support.v4.app.Fragment f  = new CrimeListFragment();
		return f;
	}

	
	}


