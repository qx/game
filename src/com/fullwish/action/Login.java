package com.fullwish.action;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fullwish.util.ConnUtil;
import com.fullwish.util.JsonUtil;
import com.fullwish.util.MD5;
import com.fullwish.util.PATH;

public class Login extends Activity {
    private EditText login_account;

    private EditText login_password;

    /* 登录 */
    private Button login_login;

    /* 注册 */
    private Button login_register;

    /* 取回密码 */
    private Button login_findpassword;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login_login = (Button) this.findViewById(R.id.login_login);
        login_register = (Button) this.findViewById(R.id.login_register);
        login_findpassword = (Button) this
                .findViewById(R.id.login_findpassword);
        /* 获取checkbox,记住账户 */
        /* 获取checkbox,记住密码 */
        /* 获取账户输入栏 */
        login_account = (EditText) this.findViewById(R.id.login_account);
        /* 获取密码栏 */
        login_password = (EditText) this.findViewById(R.id.login_password);
        /* shareperference看是否为空 */
        /* 账号非空,账号输入栏.setText */
        /* 密码非空,密码输入栏放入密码 */
        OnClickListener clicklistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.login_login:
                    /**
                     * 获取用户名,密码
                     */
                    String username = login_account.getText().toString();
                    String password = MD5.MD5Encode(login_password.getText().toString());
                    /* 转化为json */
                    HashMap<String, String> user_map = new HashMap<String, String>();
                    user_map.put("user_email", username);
                    user_map.put("user_password", password);
                    String user_string = JsonUtil.map2Json((Map)user_map);
                    Toast.makeText(Login.this, user_string, Toast.LENGTH_SHORT)
                            .show();
                     ConnUtil.userLogin(user_string, PATH.BASE+PATH.LOGIN);
                    // Intent intent1 = new Intent(Login.this,
                    // Start_page_country.class);
                    // startActivityForResult(intent1, 1);
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
                /**
                 * 
                 */
            }
        };
        login_login.setOnClickListener(clicklistener);
        login_register.setOnClickListener(clicklistener);
        login_findpassword.setOnClickListener(clicklistener);
    }
}
