package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Page_p1_Activity extends Activity {
    private ImageButton qiangdipan;
    private TextView p1_tv_14;
    private ImageButton larentou;

    private ImageButton ji;

    private ImageButton quan;

    private ImageButton sha;

    private ImageButton zhuangbei;

    private ImageButton hanhua;

    private ImageButton haoyou;

    private ImageButton shengyi;

    private ImageButton dafu;

    private ImageButton qianzhuang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);
        qiangdipan = (ImageButton) this.findViewById(R.id.p1_ib_03);
        larentou = (ImageButton) this.findViewById(R.id.p1_ib_04);
        ji = (ImageButton) this.findViewById(R.id.p1_ib_05);
        quan = (ImageButton) this.findViewById(R.id.p1_ib_06);
        sha = (ImageButton) this.findViewById(R.id.p1_ib_07);
        zhuangbei = (ImageButton) this.findViewById(R.id.p1_ib_08);
        hanhua = (ImageButton) this.findViewById(R.id.p1_ib_09);
        haoyou = (ImageButton) this.findViewById(R.id.p1_ib_10);
        shengyi = (ImageButton) this.findViewById(R.id.p1_ib_11);
        dafu = (ImageButton) this.findViewById(R.id.p1_ib_12);
        qianzhuang = (ImageButton) this.findViewById(R.id.p1_ib_13);
        p1_tv_14= (TextView) this.findViewById(R.id.p1_tv_14);  
        p1_tv_14.setSelected(true);  // Set focus to the textview
        OnClickListener clicklistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.p1_ib_03:/** Start a new Activity MyCards.java */
                    // Intent intent = new Intent(this, MyCards.class);
                    // this.startActivity(intent);
                    
                    Intent intent31 = new Intent(Page_p1_Activity.this,
                            Page_p31_Activity.class);
                    startActivityForResult(intent31, 1);
                    System.out.println("click rob");
                    break;
                case R.id.p1_ib_04:/** AlerDialog when click on Exit */
                    Intent intent3 = new Intent(Page_p1_Activity.this,
                            Page_p3_Activity.class);
                    startActivityForResult(intent3, 1);
                    System.out.println("click invite");
                    break;
                case R.id.p1_ib_05:/** AlerDialog when click on Exit */
                    Intent intent5 = new Intent(Page_p1_Activity.this,
                            Page_p5_Activity.class);
                    startActivityForResult(intent5, 1);
                    System.out.println("skills");
                    break;
                case R.id.p1_ib_06:/** AlerDialog when click on Exit */
                    Intent intent678 = new Intent(Page_p1_Activity.this,
                            Page_p678_Activity.class);
                    startActivityForResult(intent678, 1);
                    System.out.println("kid");
                    break;
                case R.id.p1_ib_07:/** AlerDialog when click on Exit */
                    Intent intent12 = new Intent(Page_p1_Activity.this,
                            Page_p12_Activity.class);
                    startActivityForResult(intent12, 1);
                    System.out.println("kill");
                    break;
                case R.id.p1_ib_08:/** AlerDialog when click on Exit */
                    Intent intent25 = new Intent(Page_p1_Activity.this,
                            Page_p25_Activity.class);
                    startActivityForResult(intent25, 1);
                    System.out.println("equi");
                    break;
                case R.id.p1_ib_09:/** AlerDialog when click on Exit */
                    Intent intent14 = new Intent(Page_p1_Activity.this,
                            Page_p14_Activity.class);
                    startActivityForResult(intent14, 1);
                    System.out.println("blog");
                    break;
                case R.id.p1_ib_10:
                    Intent intent16 = new Intent(Page_p1_Activity.this,
                            Page_p16_Activity.class);
                    startActivityForResult(intent16, 1);
                    System.out.println("friend");
                    break;
                case R.id.p1_ib_11:/** AlerDialog when click on Exit */
                    Intent intent23 = new Intent(Page_p1_Activity.this,
                            Page_p23_Activity.class);
                    startActivityForResult(intent23, 1);
                    System.out.println("business");
                    break;
                case R.id.p1_ib_12:/** AlerDialog when click on Exit */
                    Intent intent20 = new Intent(Page_p1_Activity.this,
                            Page_p20_Activity.class);
                    startActivityForResult(intent20, 1);
                    System.out.println("docter");
                    break;
                case R.id.p1_ib_13:/** AlerDialog when click on Exit */
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
