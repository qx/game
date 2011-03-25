package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

public class Blog_kill_tab extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置全屏
		super.onCreate(savedInstanceState);
		setTitle("Tab测试");
		TabHost tabHost = getTabHost();
//		LayoutInflater.from(this).inflate(R.layout.module1,
//				tabHost.getTabContentView(), true);
		Intent tablist1 = new Intent(Blog_kill_tab.this, Blog_kill_near.class);
		Intent tablist2 = new Intent(Blog_kill_tab.this, Blog_kill_attention.class);
		Intent tablist3 = new Intent(Blog_kill_tab.this, Blog_kill_fans.class);

		tabHost.addTab(tabHost.newTabSpec("tab1_TabSpec").setIndicator(
				"附近的人").setContent(tablist1));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("关注")
				.setContent(tablist2));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("粉丝")
				.setContent(tablist3));
	}

}