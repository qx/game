package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Friend_tab extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Tab����");
		TabHost tabHost = getTabHost();
//		LayoutInflater.from(this).inflate(R.layout.module1,
//				tabHost.getTabContentView(), true);
		Intent tablist1 = new Intent(Friend_tab.this, Friend_attention.class);
		Intent tablist2 = new Intent(Friend_tab.this, Friend_beattention.class);

		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(
				"�ҵĹ�ע").setContent(tablist1));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("�ҵķ�˿")
				.setContent(tablist2));
	}

}