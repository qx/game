package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Mission_tab  extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Tab≤‚ ‘");
		TabHost tabHost = getTabHost();
		Intent testlist = new Intent(Mission_tab.this, Mission_list.class);

		tabHost.addTab(tabHost.newTabSpec("tab1_TabSpec").setIndicator(
				"ººƒ‹¿‡“º").setContent(testlist));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("ŸE")
				.setContent(testlist));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("»˛")
				.setContent(testlist));
	}

}