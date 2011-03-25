package com.fullwish.action;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

public class Page_p12_Activity extends ActivityGroup {
	private ScrollView container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p12);
//		setContentView(R.layout.list_skill);
		container = (ScrollView) findViewById(R.id.p12_containerBody);
		container.removeAllViews();
		container.addView(getLocalActivityManager().startActivity(
				"list skill",
				new Intent(Page_p12_Activity.this, Blog_kill_tab.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView());
	}
}
