package com.fullwish.action;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

public class Page_p25_Activity extends ActivityGroup {
	private ScrollView container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p25);
		container = (ScrollView) findViewById(R.id.p25_containerBody);
		container.removeAllViews();
		container.addView(getLocalActivityManager().startActivity(
				"list skill",
				new Intent(Page_p25_Activity.this, Equit_tab.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView());
	}
}