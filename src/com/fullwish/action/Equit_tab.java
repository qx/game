package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

public class Equit_tab  extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置全屏
		super.onCreate(savedInstanceState);
		setTitle("Tab测试");
		TabHost tabHost = getTabHost();
//		LayoutInflater.from(this).inflate(R.layout.module1,
//				tabHost.getTabContentView(), true);
		Intent testlist = new Intent(Equit_tab.this, Equit.class);

		tabHost.addTab(tabHost.newTabSpec("tab1_TabSpec").setIndicator(
				"身上装备").setContent(testlist));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("专属仓库")
				.setContent(testlist));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("杂货店")
				.setContent(testlist));
	}

}