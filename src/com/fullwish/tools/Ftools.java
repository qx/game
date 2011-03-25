package com.fullwish.tools;

import android.content.Context;
import android.widget.Toast;

public class Ftools {

	private Context context;
	public Ftools(){
		
	}

	public Ftools(Context context) {
		super();
		this.context = context;
	}

/**
 * 该方法用于Toast方式显示输出内容
 * @param 需要显示的内容
 */
	public  void DisplayToast(String str) {
		Toast
				.makeText(context, str,
						Toast.LENGTH_SHORT).show();
	}
}
