/**
 * 
 */
package com.fullwish.utils;

import android.widget.Toast;

/**
 * @author fullwish
 * 
 */
public class DisplayTools {
    public static void show(String show) {
        Toast toast = Toast.makeText(MyApplication.getInstance(), show, Toast.LENGTH_LONG);
        // 设置toast显示的位置
        // toast.setGravity(Gravity.TOP, 0, 220);
        // toast.setDuration(Toast.LENGTH_LONG);
        // 显示该Toast
        toast.show();
    }
}
