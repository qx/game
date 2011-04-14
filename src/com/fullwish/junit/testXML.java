package com.fullwish.junit;

import android.test.AndroidTestCase;
import android.util.Log;

import com.fullwish.utils.NetTrans;

public class testXML extends AndroidTestCase {
	private static final String TAG = "testXML";

	public void testxml() throws Exception{
	String path = "http://192.168.2.100:8080/user/reg_regUI.action";
	Log.i(TAG,NetTrans.getHtml(path));
	}
}
