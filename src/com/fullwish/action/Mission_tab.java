package com.fullwish.action;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Mission_tab  extends TabActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tab测试");
        TabHost tabHost = getTabHost();
        Intent testlist = new Intent(Mission_tab.this, Mission_list.class);

        tabHost.addTab(tabHost.newTabSpec("tab1_TabSpec").setIndicator(
                "技能类壹").setContent(testlist));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("貳")
                .setContent(testlist));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("叁")
                .setContent(testlist));
    }

}