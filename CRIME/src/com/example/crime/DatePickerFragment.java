package com.example.crime;

import java.sql.Date;
import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class DatePickerFragment extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mDate = (Date)getArguments().getSerializable(EXTRA_DATE);
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(mDate);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
	
	
	View v = getActivity().getLayoutInflater()
			.inflate(R.layout.dialog_date, null);
			
			return new AlertDialog.Builder(getActivity())
			.setView(v)
			.setTitle(R.string.date_picker_title)
			.setPositiveButton(android.R.string.ok, null)
			.create();
	
}
	
	public static final String EXTRA_DATE =
			"com.bignerdranch.android.criminalintent.date";
			private Date mDate;
			
			
			public static DatePickerFragment newInstance(Date date) {
			Bundle args = new Bundle();
			args.putSerializable(EXTRA_DATE, date);
			
			DatePickerFragment fragment = new DatePickerFragment();
			fragment.setArguments(args);
			
			return fragment;
}
}
