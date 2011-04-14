package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Start_page_career extends Activity {
    private Button career_next;

    private Button career_back;

    private Bundle extras_career;

    private RadioGroup m_RadioGroup;

    private RadioButton m_Radio1, m_Radio2, m_Radio3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_career);
        extras_career = this.getIntent().getExtras();
        career_back = (Button) this.findViewById(R.id.career_8);
        career_next = (Button) this.findViewById(R.id.career_9);

        m_RadioGroup = (RadioGroup) findViewById(R.id.RadioGroup01);
        m_Radio1 = (RadioButton) findViewById(R.id.career_2);
        m_Radio2 = (RadioButton) findViewById(R.id.career_4);
        m_Radio3 = (RadioButton) findViewById(R.id.career_6);

        m_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选择的数据,并将其发送给服务器(测试)
                if (checkedId == m_Radio1.getId()) {
                    extras_career.putString("user_carrer", "智力");
                } else if (checkedId == m_Radio2.getId()) {
                    extras_career.putString("user_carrer", "敏捷");
                } else if (checkedId == m_Radio3.getId()) {
                    extras_career.putString("user_carrer", "力量");
                }
            }
        });
        Toast.makeText(this, extras_career.getString("国家"), Toast.LENGTH_SHORT).show();// test
        career_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nickname = new Intent(Start_page_career.this, Start_page_nickname.class);
                nickname.putExtras(extras_career);
                startActivityForResult(nickname, 1);
            }
        });
        career_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
