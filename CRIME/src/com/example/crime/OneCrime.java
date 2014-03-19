package com.example.crime;

import java.sql.Date;
import java.util.UUID;

import android.provider.ContactsContract.Data;

public class OneCrime {
	UUID mId;
	String mTitle;
	Date mDate;
	boolean mSolved;
	
	OneCrime(){
		mId = UUID.randomUUID();
		long curTime = System.currentTimeMillis();
		mDate = new Date(curTime);
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public UUID getmId() {
		return mId;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public boolean ismSolved() {
		return mSolved;
	}

	public void setmSolved(boolean mSolved) {
		this.mSolved = mSolved;
	}
	
	@Override
	public String toString(){
		return mTitle;
	}
	
	

}
