package com.fullwish.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Start_page_introduce extends Activity {
    private Button introduce_start;

    private Button introduce_exit;

    private Bundle extras4;

    private String content;
    
    private TextView textContent;//��ʾ����

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_introduce);
        extras4 = this.getIntent().getExtras();
        content = "�𾴵�" + extras4.getString("�ǳ�") + ",����,��ӭ�����ƶ�����:"
                + "����ѡ��Ĺ�����" + extras4.getString("����") + ",ְҵ��,"
                + extras4.getString("ְҵ");
        
        textContent=(TextView)this.findViewById(R.id.introduce_1);
        introduce_start = (Button) this.findViewById(R.id.introduce_2);
        introduce_exit = (Button) this.findViewById(R.id.introduce_3);
        
        textContent.setText(content);
        
        introduce_start.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                                
                Intent introduce = new Intent(Start_page_introduce.this,
                        Page_p1_Activity.class);
           /*     Socket socket = null;
                String message = mEditText.getText().toString() + "\r\n"; 
                    //����Socket
                    socket = new Socket("192.168.1.110",54321); 
                    //�������������Ϣ
                    PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);      
                    out.println(message); 
                    
                    //�������Է���������Ϣ
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                    String msg = br.readLine(); 
                    
                    if ( msg != null )
                    {
                        mTextView.setText(msg);
                    }
                    else
                    {
                        mTextView.setText("���ݴ���!");
                    }
                    //�ر���
                    out.close();
                    br.close();
                    //�ر�Socket
                    socket.close(); 
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
        // ////////////////test//////////////////
        // ////////////////////////////////
        Toast.makeText(
                this,
                extras4.getString("����") + ":   " + extras4.getString("ְҵ")
                        + ":  " + extras4.getString("�ǳ�"), Toast.LENGTH_SHORT)
                .show();// test
        // ////////////////test//////////////////////////////////////////////////

    }
}