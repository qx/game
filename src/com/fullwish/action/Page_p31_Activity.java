package com.fullwish.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fullwish.tools.Ftools;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Page_p31_Activity extends ListActivity {

	public Integer[] we = new Integer[] { R.drawable.i1, R.drawable.i2,
			R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6,
			R.drawable.i7, R.drawable.i8, R.drawable.i9, };
	private ListView mylist_31;
	private Ftools tools;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p31);
		tools = new Ftools(this.getApplicationContext());
		mylist_31 = this.getListView();
		mylist_31.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				tools.DisplayToast("选中了" + Integer.toString(arg2 + 1) + "项目");
				Intent intent1 = new Intent(Page_p31_Activity.this,
						Page_p32_Activity.class);
				startActivityForResult(intent1, 1);
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.place, new String[] { "title", "info", "img" },
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
