package com.fullwish.action;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

public class Page_p23_Activity extends ActivityGroup {
private ScrollView f1;
private ScrollView f2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p23);
		f1=(ScrollView)this.findViewById(R.id.business_land);
		f2=(ScrollView)this.findViewById(R.id.business_estate);
		f1.removeAllViews();
		f2.removeAllViews();
		f1.addView(getLocalActivityManager().startActivity(
				"list skill",
				new Intent(Page_p23_Activity.this, Business_land.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView());
		f2.addView(getLocalActivityManager().startActivity(
				"list skill2",
				new Intent(Page_p23_Activity.this, Business_estate.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView());
	}

}
