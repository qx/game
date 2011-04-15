package com.fullwish.action;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.fullwish.utils.ConnUtil;
import com.fullwish.utils.DisplayTools;
import com.fullwish.utils.JsonUtil;
import com.fullwish.utils.PATH;

public class Login extends Activity {
    private EditText login_account;

    private EditText login_password;

    /* 登录 */
    private Button login_login;

    private CheckBox login_saveaccount;

    private CheckBox login_savepassword;

    /* 注册 */
    private Button login_register;

    /* 取回密码 */
    private Button login_findpassword;

    private Bundle extras_login;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // extras_login = this.getIntent().getExtras();
        extras_login = new Bundle();
        login_login = (Button) this.findViewById(R.id.login_login);
        login_register = (Button) this.findViewById(R.id.login_register);
        login_findpassword = (Button) this.findViewById(R.id.login_findpassword);
        /* 获取checkbox,记住账户 */
        login_saveaccount = (CheckBox) this.findViewById(R.id.login_saveaccount);
        /* 获取checkbox,记住密码 */
        login_savepassword = (CheckBox) this.findViewById(R.id.login_savepassword);
        /* 获取账户输入栏 */
        login_account = (EditText) this.findViewById(R.id.login_account);
        String save_account = login_account.getText().toString();
        System.out.println(save_account);
        /* 获取密码栏 */
        login_password = (EditText) this.findViewById(R.id.login_password);
        String save_password = login_password.getText().toString();
        System.out.println(save_password);
        /* shareperference看是否为空 */
        final SharedPreferences prefs = this.getSharedPreferences("save_user_account", MODE_WORLD_WRITEABLE);
        if (prefs.getString("save_account", "") != null) {
            login_account.setText(prefs.getString("save_account", ""));
        }
        /* 密码非空,密码输入栏放入密码 */
        if (prefs.getString("save_password", "") != null) {
            login_password.setText(prefs.getString("save_password", ""));
        }

        OnCheckedChangeListener checklistener = new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // System.out.println(buttonView.getId() ==
                    // R.id.login_saveaccount);
                    // System.out.println(buttonView.getText());
                    if (buttonView.getId() == R.id.login_saveaccount) {// 账号checkbox被点击
                        String save_account = login_account.getText().toString();
                        Editor editor = prefs.edit();
                        editor.putString("save_account", save_account);
                        editor.commit();
                    }
                    if (buttonView.getId() == R.id.login_savepassword) {
                        String save_password = login_password.getText().toString();
                        Editor editor = prefs.edit();
                        editor.putString("save_password", save_password);
                        editor.commit();
                    }
                } else {// 清空share
                    System.out.println("unchecked click");
                }
            }
        };

        OnClickListener clicklistener = new OnClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.login_login:
                    /**
                     * 获取用户名,密码
                     */
                    String username = login_account.getText().toString();
                    String password = login_password.getText().toString();
                    /* 转化为json */
                    HashMap<String, String> user_map = new HashMap<String, String>();
                    user_map.put("user_email", username);
                    user_map.put("user_password", password);
                    String user_string = JsonUtil.map2Json((Map) user_map);
                    // Toast.makeText(Login.this, user_string,
                    // Toast.LENGTH_SHORT).show();
                    DisplayTools.show(user_string);

                    Boolean ispass = ConnUtil.userLogin(user_string, PATH.BASE + PATH.LOGIN);// 验证用户
                    System.out.println(ConnUtil.getSsid());
                    if (ispass) {
                        System.out.println("extras_login " + ConnUtil.getUser());
                        System.out.println(ConnUtil.getSsid());
                        extras_login.putString("user", ConnUtil.getUser());
                        extras_login.putString("ssid", ConnUtil.getSsid());
                        Intent intent1 = new Intent(Login.this, Start_page_country.class);
                        intent1.putExtras(extras_login);
                        startActivityForResult(intent1, 1);
                    } else {
                        // Toast.makeText(Login.this, "登录失败,请检查用户名或者密码",
                        // Toast.LENGTH_SHORT).show();
                        DisplayTools.show("登录失败,请检查用户名或者密码");
                    }
                    break;
                case R.id.login_register:
                    Intent intent2 = new Intent(Login.this, Register.class);
                    startActivityForResult(intent2, 1);
                    break;
                case R.id.login_findpassword:
                    Intent intent3 = new Intent(Login.this, Getpassword.class);
                    startActivityForResult(intent3, 1);
                    break;
                }
            }
        };
        login_login.setOnClickListener(clicklistener);
        login_register.setOnClickListener(clicklistener);
        login_findpassword.setOnClickListener(clicklistener);
        login_saveaccount.setOnCheckedChangeListener(checklistener);
        login_savepassword.setOnCheckedChangeListener(checklistener);
    }
}
