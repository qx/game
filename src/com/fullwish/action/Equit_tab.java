package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

public class Equit_tab  extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // ���ر���
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // ����ȫ��
		super.onCreate(savedInstanceState);
		setTitle("Tab����");
		TabHost tabHost = getTabHost();
//		LayoutInflater.from(this).inflate(R.layout.module1,
//				tabHost.getTabContentView(), true);
		Intent testlist = new Intent(Equit_tab.this, Equit.class);

		tabHost.addTab(tabHost.newTabSpec("tab1_TabSpec").setIndicator(
				"����װ��").setContent(testlist));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("ר���ֿ�")
				.setContent(testlist));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("�ӻ���")
				.setContent(testlist));
	}

}