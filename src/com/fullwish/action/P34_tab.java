package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class P34_tab extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
		Intent map = new Intent(P34_tab.this, P34_tab_map.class);
		LayoutInflater.from(this).inflate(R.layout.p34_tab_content,
				tabHost.getTabContentView(), true);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("·¢Ìû")
				.setContent(R.id.tab1));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("µØÍ¼")
				.setContent(map));
//		MapView mapView;
//		mapView = new MapView(this, "0yj6uRdj9p0rck2ViKnXBB2EUAwHIewegAmKhMA");
	}

}