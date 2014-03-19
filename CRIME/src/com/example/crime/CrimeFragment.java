package com.example.crime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	
	private OneCrime mCrime;
	private	EditText mTitle;
	Button mBut;
	CheckBox cBox;
	
	public static final String EXTRA_CRIME_ID =
			"com.example.crime.crime_id";
	
	private static final String DIALOG_DATE = "date";
	

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
	
	mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_fragment,parent, false);
		
		mTitle = (EditText)v.findViewById(R.id.crime_title);
		mTitle.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				mCrime.setmTitle(s.toString());
				
			}
			
		});
		
		mTitle.setText(mCrime.getmTitle());
		
		
		
		mBut = (Button)v.findViewById(R.id.button1);
		cBox = (CheckBox)v.findViewById(R.id.checkBox1);
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yy hh:mm:ss", Locale.ENGLISH);
		String strTime = simpleDateFormat.format(d);
		
				mBut.setText(mCrime.getmDate().toString());
				
				mBut.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						android.support.v4.app.FragmentManager fm = getActivity()
					.getSupportFragmentManager();
						DatePickerFragment dialog = DatePickerFragment
								.newInstance(mCrime.getmDate());
					dialog.show(fm, DIALOG_DATE);
					}
					});
				
			cBox.setChecked(mCrime.ismSolved());
		cBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mCrime.setmSolved(isChecked);
				
			}
			
		});
		
		return v;
	}
	
	public static CrimeFragment newInstance(UUID crimeId){
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeId);
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	

}
