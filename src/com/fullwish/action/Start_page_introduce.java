package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.fullwish.utils.DisplayTools;

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
        extras_introduce = this.getIntent().getExtras();
        content = "尊敬的  " + extras_introduce.getString("user_nickname") + "\n" + "    您好,欢迎来到移动三国:" + "您所选择的国家是:"
                + extras_introduce.getString("user_country") + "\n" + "职业是:"
                + extras_introduce.getString("user_carrer");
        textContent = (TextView) this.findViewById(R.id.introduce_1);
        introduce_start = (Button) this.findViewById(R.id.introduce_2);
        introduce_exit = (Button) this.findViewById(R.id.introduce_3);

        textContent.setText(content);

        introduce_start.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent introduce = new Intent(Start_page_introduce.this, Page_p1_Activity.class);
                /*
                 * Socket socket = null; String message =
                 * mEditText.getText().toString() + "\r\n"; //创建Socket socket =
                 * new Socket("192.168.1.110",54321); //向服务器发送消息 PrintWriter out
                 * = new PrintWriter( new BufferedWriter( new
                 * OutputStreamWriter(socket.getOutputStream())),true);
                 * out.println(message);
                 * 
                 * //接收来自服务器的消息 BufferedReader br = new BufferedReader(new
                 * InputStreamReader(socket.getInputStream())); String msg =
                 * br.readLine();
                 * 
                 * if ( msg != null ) { mTextView.setText(msg); } else {
                 * mTextView.setText("数据错误!"); } //关闭流 out.close(); br.close();
                 * //关闭Socket socket.close();
                 */

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