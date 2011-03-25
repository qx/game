package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

public class Kid_tab extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // ���ر���
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // ����ȫ��
		super.onCreate(savedInstanceState);
		setTitle("Tab����");
		TabHost tabHost = getTabHost();
//		LayoutInflater.from(this).inflate(R.layout.module1,
//				tabHost.getTabContentView(), true);
		Intent tablist1 = new Intent(Kid_tab.this, Kid_list.class);
		Intent tablist2 = new Intent(Kid_tab.this, Kid_save.class);
		Intent tablist3 = new Intent(Kid_tab.this, Kid_my.class);

		tabHost.addTab(tabHost.newTabSpec("tab1_TabSpec").setIndicator(
				"Ȧ����").setContent(tablist1));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("������Ʊ")
				.setContent(tablist2));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("�ҵ���Ʊ")
				.setContent(tablist3));
	}

}