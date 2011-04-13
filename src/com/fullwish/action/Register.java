package com.fullwish.action;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fullwish.util.ConnUtil;
import com.fullwish.util.MD5;
import com.fullwish.util.PATH;

public class Register extends Activity {
    /** Called when the activity is first created. */
    private EditText register_username;

    private Button register_register;

    private EditText register_password1;

    private EditText register_password2;
    private JSONObject user_json;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        register_username = (EditText) this
                .findViewById(R.id.register_username);
        register_password1 = (EditText) this
                .findViewById(R.id.register_password1);
        register_password2 = (EditText) this
                .findViewById(R.id.register_password2);
        register_register = (Button) this.findViewById(R.id.register_register);

        /* 监听注册按钮 */
        register_register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 取得用户名email */
                String username = register_username.getText().toString();
                /* 取得密码 */
                String userpassword1 = register_password1.getText().toString();
                /* 取得第二次密码 */
                String userpassword2 = register_password2.getText().toString();
                /* 两次密码判断 */
                System.out.println(userpassword1+"\n"+userpassword2);
                if (userpassword1.equals(userpassword2)) {
                  
                    String password = MD5.MD5Encode(userpassword1);
                    /* true */
                    /* 组拼json */
                    /*
                     *JSONObject user_json = (JSONObject) new
                     * JSONParser().parse
                     * ("{\"name\":\"MyNode\", \"width\":200, \"height\":100}");
                     */
                    
                    try {
                        /**
                         * {"user_email":username,"user_password":password}
                         */
                        user_json=new JSONObject("{\"user_email\":"+username
                                +",\"user_password\":"+password+"}") ;
                     /*   user_json.put("user_email", username);
                        user_json.put("user_password", password);*/
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    /* 用户名,密码,email存入httpentity */
                    System.out.println(PATH.BASE+PATH.REGISTER);
                    System.out.println(user_json.toString());
                    ConnUtil.addUser(user_json, PATH.BASE + PATH.REGISTER);
                    Toast.makeText(Register.this, user_json.toString(), Toast.LENGTH_SHORT).show();
                    /* 返回登录界面 */
                }
                /* false */
                /* 吐司提示,两次密码不同,重新输入 */

            }
        });
    }
}