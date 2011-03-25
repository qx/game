package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
 * android:id="@+id/nickname_3"
android:layout_width="99px"
android:layout_height="wrap_content"
android:text="������һ��"
android:id="@+id/nickname_4"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="��һ��"
 */
public class Start_page_nickname  extends Activity {
	private Button nickname_next;
	private Button nickname_back;
	private Bundle extras3;
	private String content;
	private EditText nickname;//nickname input weight
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_page_nickname);
		extras3=this.getIntent().getExtras();
		nickname=(EditText)this.findViewById(R.id.nickname_1);
		
		
		nickname_back = (Button) this.findViewById(R.id.nickname_3);
		nickname_next = (Button) this.findViewById(R.id.nickname_4);
		nickname_next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent introduce = new Intent(Start_page_nickname.this,
						Start_page_introduce.class);
				content=nickname.getEditableText().toString();
				extras3.putString("�ǳ�", content);
				introduce.putExtras(extras3);
				startActivityForResult(introduce, 1);
			}
		});
		nickname_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	      Toast.makeText(this, extras3.getString("����")+":   "+extras3.getString("ְҵ"),
	                Toast.LENGTH_SHORT).show();//test
	}
}

