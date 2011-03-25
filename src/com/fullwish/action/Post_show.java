package com.fullwish.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class Post_show  extends ListActivity{

	public Integer[] we = new Integer[] { R.drawable.i1, R.drawable.i2,
			R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6,
			R.drawable.i7, R.drawable.i8, R.drawable.i9, };

	// private List<String> data = new ArrayList<String>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setState(we);
		setContentView(R.layout.post_list);

		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.post_show_set, new String[] { "title", "info", "img" },
				new int[] { R.id.title, R.id.info, R.id.img });
		setListAdapter(adapter);
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


