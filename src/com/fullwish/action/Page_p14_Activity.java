package com.fullwish.action;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

public class Page_p14_Activity extends ActivityGroup {
	private ScrollView container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p14);
		container = (ScrollView) findViewById(R.id.p14_containerBody);
		container.removeAllViews();
		container.addView(getLocalActivityManager().startActivity(
				"list skill",
				new Intent(Page_p14_Activity.this, Post_tab.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView());
	}
}