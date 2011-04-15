package com.fullwish.action;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.fullwish.utils.ConnUtil;
import com.fullwish.utils.DisplayTools;
import com.fullwish.utils.JsonUtil;
import com.fullwish.utils.PATH;
import com.fullwish.utils.SHARE;

public class Start_page_introduce extends Activity {
    private Button introduce_start;

    private Button introduce_exit;

    private Bundle extras_introduce;

    private String content;

    private TextView textContent;// 显示内容

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_introduce);
        // final SharedPreferences session =
        // this.getSharedPreferences("session", MODE_WORLD_WRITEABLE);//
        // 获取存储会话的shareperference
        extras_introduce = this.getIntent().getExtras();
        content = "尊敬的  " + extras_introduce.getString("user_nickname") + "\n" + "    您好,欢迎来到移动三国:" + "您所选择的国家是:"
                + extras_introduce.getString("user_country") + "\n" + "职业是:"
                + extras_introduce.getString("user_carrer");
        textContent = (TextView) this.findViewById(R.id.introduce_1);
        introduce_start = (Button) this.findViewById(R.id.introduce_2);
        introduce_exit = (Button) this.findViewById(R.id.introduce_3);

        textContent.setText(content);

        introduce_start.setOnClickListener(new OnClickListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void onClick(View v) {

                Intent introduce = new Intent(Start_page_introduce.this, Page_p1_Activity.class);
                introduce.putExtras(extras_introduce);
                /* user_country,user_carrer,user_nickname保存到服务器 */
                /* 转成jsonString */
                HashMap<String, String> user_map = new HashMap<String, String>();
                user_map.put("user_country", extras_introduce.getString("user_country"));// 从Bundle取数据
                user_map.put("user_carrer", extras_introduce.getString("user_carrer"));// 从Bundle取数据
                user_map.put("user_nickname", extras_introduce.getString("user_nickname"));// 从Bundle取数据

                DisplayTools.show(SHARE.SESSION.getString("user_email", "") + SHARE.SESSION.getString("ssid", ""));
                user_map.put("user_email", SHARE.SESSION.getString("user_email", ""));// 从shareperference取user_email
                user_map.put("ssid", SHARE.SESSION.getString("ssid", ""));// 从shareperference取ssid
                String user_string = JsonUtil.map2Json((Map) user_map);
                /** user_string 提交数据库存储ConnUtil.updateUser() */
                ConnUtil.userUpdate(user_string, PATH.P1_UPDATE);
                System.out.println(user_string);
                startActivityForResult(introduce, 1);
            }
        });
        introduce_exit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DisplayTools.show(extras_introduce.getString("user_country") + ":   "
                + extras_introduce.getString("user_carrer") + ":  " + extras_introduce.getString("user_nickname"));// test

    }
}