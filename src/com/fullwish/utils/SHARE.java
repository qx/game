/**
 * 
 */
package com.fullwish.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author fullwish 用于获取sharedpreference 实例
 */
public class SHARE {
    private static Context context = MyApplication.getInstance();

    @SuppressWarnings("static-access")
    public static final SharedPreferences ACCOUNT = context.getSharedPreferences("save_user_account",
            context.MODE_WORLD_WRITEABLE);

    @SuppressWarnings("static-access")
    public static final SharedPreferences SESSION = context.getSharedPreferences("session",
            context.MODE_WORLD_WRITEABLE);

    /*
     * public void initShare() { account =
     * MyApplication.getInstance().getSharedPreferences("save_user_account",
     * MODE_WORLD_WRITEABLE); session =
     * MyApplication.getInstance().getSharedPreferences("session",
     * MODE_WORLD_WRITEABLE); }
     */
}
