package com.fullwish.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter;

public class Page_p32_Activity extends ListActivity {
	public Integer[] we = new Integer[] { R.drawable.i1, R.drawable.i2,
			R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6,
			R.drawable.i7, R.drawable.i8, R.drawable.i9, };
	private Button post_btn, map_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p32);
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.p32_list_set, new String[] { "title", "info", "img" },
				new int[] { R.id.title, R.id.info, R.id.img });
		setListAdapter(adapter);
		post_btn = (Button) this.findViewById(R.id.post_btn);
		map_btn = (Button) this.findViewById(R.id.map_btn);
		OnClickListener clicklistener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.post_btn:/** Start a new Activity MyCards.java */
					// Intent intent = new Intent(this, MyCards.class);
					// this.startActivity(intent);
					Intent intent1 = new Intent(Page_p32_Activity.this,
							Page_p34_Activity.class);
					startActivityForResult(intent1, 1);
					System.out.println("post");
					break;
				case R.id.map_btn:/** AlerDialog when click on Exit */
					Intent intent2 = new Intent(Page_p32_Activity.this,
							Page_p35_Activity.class);
					startActivityForResult(intent2, 1);
					System.out.println("map");
					break;
				}
			}
		};
		post_btn.setOnClickListener(clicklistener);
		map_btn.setOnClickListener(clicklistener);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 1; i < 10; i++) {
			map = new HashMap<String, Object>();
			map.put("title", "G" + i);
			map.put("info", "google  " + i);
			map.put("img", we[i - 1]);
			list.add(map);
		}

		return list;
	}
}
