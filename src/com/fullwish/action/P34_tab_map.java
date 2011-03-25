package com.fullwish.action;

import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class P34_tab_map extends MapActivity {
  
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p34_tab_map);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


}
