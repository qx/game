package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Page_p1_Activity extends Activity {
    private Button qiangdipan;

    private TextView larentou;

    private ImageButton ji;

    private ImageButton quan;

    private ImageButton  sha;

    private Button zhuangbei;

    private Button hanhua;

    private Button haoyou;

    private Button shengyi;

    private Button dafu;

    private Button qianzhuang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);
        qiangdipan = (Button) this.findViewById(R.id.rob);
        larentou = (TextView) this.findViewById(R.id.invite);
        ji = (ImageButton) this.findViewById(R.id.skills);
        quan = (ImageButton) this.findViewById(R.id.kid);
        sha = (ImageButton) this.findViewById(R.id.kill);
        zhuangbei = (Button) this.findViewById(R.id.equi);
        hanhua = (Button) this.findViewById(R.id.blog);
        haoyou = (Button) this.findViewById(R.id.friend);
        shengyi = (Button) this.findViewById(R.id.business);
        dafu = (Button) this.findViewById(R.id.docter);
        qianzhuang = (Button) this.findViewById(R.id.bank);
        OnClickListener clicklistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.rob:/** Start a new Activity MyCards.java */
                    // Intent intent = new Intent(this, MyCards.class);
                    // this.startActivity(intent);
                    Intent intent31 = new Intent(Page_p1_Activity.this,
                            Page_p31_Activity.class);
                    startActivityForResult(intent31, 1);
                    System.out.println("click rob");
                    break;
                case R.id.invite:/** AlerDialog when click on Exit */
                    Intent intent3 = new Intent(Page_p1_Activity.this,
                            Page_p3_Activity.class);
                    startActivityForResult(intent3, 1);
                    System.out.println("click invite");
                    break;
                case R.id.skills:/** AlerDialog when click on Exit */
                    Intent intent5 = new Intent(Page_p1_Activity.this,
                            Page_p5_Activity.class);
                    startActivityForResult(intent5, 1);
                    System.out.println("skills");
                    break;
                case R.id.kid:/** AlerDialog when click on Exit */
                    Intent intent678 = new Intent(Page_p1_Activity.this,
                            Page_p678_Activity.class);
                    startActivityForResult(intent678, 1);
                    System.out.println("kid");
                    break;
                case R.id.kill:/** AlerDialog when click on Exit */
                    Intent intent12 = new Intent(Page_p1_Activity.this,
                            Page_p12_Activity.class);
                    startActivityForResult(intent12, 1);
                    System.out.println("kill");
                    break;
                case R.id.equi:/** AlerDialog when click on Exit */
                    Intent intent25 = new Intent(Page_p1_Activity.this,
                            Page_p25_Activity.class);
                    startActivityForResult(intent25, 1);
                    System.out.println("equi");
                    break;
                case R.id.blog:/** AlerDialog when click on Exit */
                    Intent intent14 = new Intent(Page_p1_Activity.this,
                            Page_p14_Activity.class);
                    startActivityForResult(intent14, 1);
                    System.out.println("blog");
                    break;
                case R.id.friend:
                    Intent intent16 = new Intent(Page_p1_Activity.this,
                            Page_p16_Activity.class);
                    startActivityForResult(intent16, 1);
                    System.out.println("friend");
                    break;
                case R.id.business:/** AlerDialog when click on Exit */
                    Intent intent23 = new Intent(Page_p1_Activity.this,
                            Page_p23_Activity.class);
                    startActivityForResult(intent23, 1);
                    System.out.println("business");
                    break;
                case R.id.docter:/** AlerDialog when click on Exit */
                    Intent intent20 = new Intent(Page_p1_Activity.this,
                            Page_p20_Activity.class);
                    startActivityForResult(intent20, 1);
                    System.out.println("docter");
                    break;
                case R.id.bank:/** AlerDialog when click on Exit */
                    Intent intent24 = new Intent(Page_p1_Activity.this,
                            Page_p24_Activity.class);
                    startActivityForResult(intent24, 1);
                    System.out.println("bank");
                    break;
                }
            }
        };
        qiangdipan.setOnClickListener(clicklistener);
        larentou.setOnClickListener(clicklistener);
        ji.setOnClickListener(clicklistener);
        quan.setOnClickListener(clicklistener);
        sha.setOnClickListener(clicklistener);
        zhuangbei.setOnClickListener(clicklistener);
        hanhua.setOnClickListener(clicklistener);
        haoyou.setOnClickListener(clicklistener);
        shengyi.setOnClickListener(clicklistener);
        dafu.setOnClickListener(clicklistener);
        qianzhuang.setOnClickListener(clicklistener);
    }
}
