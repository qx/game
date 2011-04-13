package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity {
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
        login_findpassword = (Button) this.findViewById(R.id.login_findpassword);
        /*获取checkbox,记住账户*/
        /*获取checkbox,记住密码*/
        /*获取账户输入栏*/
        /*获取密码栏*/
        /*shareperference看是否为空*/
                /*账号非空,账号输入栏.setText*/
                /*密码非空,密码输入栏放入密码*/
        OnClickListener clicklistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.login_login:
                    /**
                     * 获取用户名,密码,发送服务器验证
                     * @param String username,String userpassword
                     * @return boolean
                     */
          //  ;
         /*           if(ConnUtil.checkUser(user.username,user.userpassword)){
          *                   //产生cookie
          *                  //cookie存入用户验证信息
          *                 //转向成功页面
          *             }
          *             else {
          *                  //弹出吐司对话,用户名密码错误或不存在
          *             }
          *             
          *             //获取checkbox状态,
          *             if(checkuseraccount==true){
          *               将account保存在sharepreference
          *             }
          *             if(checkusername==true){
          *                将username保存在sharepreference
          *             }
          * 
          * */
                    Intent intent1 = new Intent(Login.this, Start_page_country.class);
                    startActivityForResult(intent1, 1);
                    System.out.println("登陆成功");
                    break;
                case R.id.login_register:
                    Intent intent2 = new Intent(Login.this, Register.class);
                    startActivityForResult(intent2, 1);
                    System.out.println("去注册");
                    break;
                case R.id.login_findpassword:
                    Intent intent3 = new Intent(Login.this, Getpassword.class);
                    startActivityForResult(intent3, 1);
                    System.out.println("找回密码");
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
