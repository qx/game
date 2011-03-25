package com.fullwish.action;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

public class Page_p678_Activity extends ActivityGroup{
	private ScrollView container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p6);
//		setContentView(R.layout.list_skill);
		container = (ScrollView) findViewById(R.id.p6_containerBody);
		container.removeAllViews();
		container.addView(getLocalActivityManager().startActivity(
				"list skill",
				new Intent(Page_p678_Activity.this, Kid_tab.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView());
	}
}
