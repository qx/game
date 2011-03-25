package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Post_tab extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
//		LayoutInflater.from(this).inflate(R.layout.module1,
//				tabHost.getTabContentView(), true);
		Intent tablist1 = new Intent(Post_tab.this, Post_show.class);
		Intent tablist2 = new Intent(Post_tab.this, Post_post.class);
		Intent tablist3 = new Intent(Post_tab.this, Post_kill.class);

		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(
				"ä¯ÀÀ").setContent(tablist1));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("·¢Ìû")
				.setContent(tablist2));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("¿ì±¨")
				.setContent(tablist3));
	}

}