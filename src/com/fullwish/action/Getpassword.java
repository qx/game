package com.fullwish.action;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Getpassword extends Activity {
    /** Called when the activity is first created. */
    private Button getpassword_btn;
    private EditText getpassword_account;
    private EditText getpassword_email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getpassword);
        getpassword_btn=(Button)this.findViewById(R.id.getpassword_btn);
        getpassword_account=(EditText)this.findViewById(R.id.getpassword_account);
        getpassword_email=(EditText)this.findViewById(R.id.getpassword_email);
        /*监听取回按钮*/
        getpassword_btn.setOnClickListener(new OnClickListener() {
            
            /*获取用户名*/
            /*获取email*/
            /*向服务器发送请求,查询密码
                    (服务器自动发送密码到指定邮箱(服务器端))*/
            /*吐司提示,已经发送,请查收邮件*/
            @Override
            public void onClick(View v) {
                String username=getpassword_account.getText().toString();
                String useremail=getpassword_email.getText().toString();
                
                Toast.makeText(Getpassword.this, "邮件已发送,请注意查收", 
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}