package com.fullwish.action;

import java.util.HashMap;
import java.util.Map;

import com.fullwish.other.Choose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Start_page_country extends Activity {
    /** Called when the activity is first created. */
    private Button country_return;

    private Button country_next;

    private RadioGroup m_RadioGroup;

    private RadioButton m_Radio1, m_Radio2, m_Radio3;

    private Boolean isChoose;
  //  private Map user;
    private Bundle extras;
    //private String country_choose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_country);
            
       // extras=new HashMap<String, String>();
        extras=new Bundle();
        
        country_return = (Button) this.findViewById(R.id.country_8);
        country_next = (Button) this.findViewById(R.id.country_9);
        /**
         * ���RadioGroup���� ���4��RadioButton����
         */
        m_RadioGroup = (RadioGroup) findViewById(R.id.RadioGroup01);
        m_Radio1 = (RadioButton) findViewById(R.id.country_2);
        m_Radio2 = (RadioButton) findViewById(R.id.country_4);
        m_Radio3 = (RadioButton) findViewById(R.id.country_6);

        /* �����¼����� */
        m_RadioGroup
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // ��ȡѡ�������,�����䷢�͸�������(����)
                        if (checkedId == m_Radio1.getId()) {
                            extras.putString("����", "���");
                            isChoose = true;
                        } else if (checkedId == m_Radio2.getId()) {
                            extras.putString("����", "κ��");
                            isChoose = true;
                        } else if (checkedId == m_Radio3.getId()) {
                            extras.putString("����", "���");
                            isChoose =true;
                        } 
                    }
                });
        
            m_RadioGroup.getCheckedRadioButtonId();
        country_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChoose = true) {
                    
                    Intent career = new Intent(Start_page_country.this,
                            Start_page_career.class);
                    career.putExtras(extras);
                    startActivityForResult(career, 1);
                } else {
                    DisplayToast("����ѡ�����");
                }
            }
        });
        country_return.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /* ��ʾToast */
    public void DisplayToast(String str) {
        Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
        // ����toast��ʾ��λ��
        toast.setGravity(Gravity.TOP, 0, 220);
        // ��ʾ��Toast
        toast.show();
    }
}
