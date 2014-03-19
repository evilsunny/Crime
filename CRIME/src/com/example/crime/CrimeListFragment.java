package com.example.crime;

import java.util.ArrayList;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends android.support.v4.app.ListFragment {
	private ArrayList<OneCrime> mCrimes;
	private static final String TAG = "CrimeListFragment";

	
	@Override
	public void onResume() {
	super.onResume();
	((CrimeAdapter)getListAdapter()).notifyDataSetChanged();//обновляем список
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	getActivity().setTitle("List");
	mCrimes = CrimeLab.get(getActivity()).getCrimes();

	
	CrimeAdapter adapter = new CrimeAdapter(mCrimes);
			setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	OneCrime c = ((CrimeAdapter)getListAdapter()).getItem(position);
	
	Intent  i = new Intent(getActivity(),CrimePagerActivity.class);
	i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
	startActivity(i);
	}
	
	private class CrimeAdapter extends ArrayAdapter<OneCrime> {
	
	public CrimeAdapter(ArrayList<OneCrime> crimes) {
	super(getActivity(), 0, crimes);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		
	if (convertView == null) {
	convertView = getActivity().getLayoutInflater()
	.inflate(R.layout.list_item_crime, null);
	}
	
	
	OneCrime c = getItem(position);
	TextView titleTextView =
	(TextView)convertView.findViewById(R.id.textView1);
	titleTextView.setText(c.getmTitle());
	TextView dateTextView =
	(TextView)convertView.findViewById(R.id.textView2);
	dateTextView.setText(c.getmDate().toString());
	CheckBox solvedCheckBox =
	(CheckBox)convertView.findViewById(R.id.checkBox1);
	solvedCheckBox.setChecked(c.ismSolved());
	
	
	return convertView;
	}
}
}