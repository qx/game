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
 * �÷�������Toast��ʽ��ʾ�������
 * @param ��Ҫ��ʾ������
 */
	public  void DisplayToast(String str) {
		Toast
				.makeText(context, str,
						Toast.LENGTH_SHORT).show();
	}
}
