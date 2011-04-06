package com.fullwish.action;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fullwish.base.User;
import com.fullwish.util.ConnUtil;

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

    private RelativeLayout adapter;

    private RelativeLayout background;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);

        /* 初始化界面 */
        user = ConnUtil.getUser("mygoogle@gmail.com","http://127.0.0.1:8080/p1_get");// 查
//        ConnUtil.addUser("http//127.0.0.1/p1_add");// 增
//        ConnUtil.updateUser(user, "http//127.0.0.1/p1_update"); // 改
//        ConnUtil.deleteUserInfo(user, "http//127.0.0.1/p1_delete"); // 删

        qiangdipan = (ImageButton) this.findViewById(R.id.p1_ib_02);
        larentou = (ImageButton) this.findViewById(R.id.p1_ib_03);
        ji = (ImageButton) this.findViewById(R.id.p1_ib_04);
        quan = (ImageButton) this.findViewById(R.id.p1_ib_05);
        sha = (ImageButton) this.findViewById(R.id.p1_ib_06);
        zhuangbei = (ImageButton) this.findViewById(R.id.p1_ib_07);
        hanhua = (ImageButton) this.findViewById(R.id.p1_ib_08);
        haoyou = (ImageButton) this.findViewById(R.id.p1_ib_09);
        shengyi = (ImageButton) this.findViewById(R.id.p1_ib_10);
        dafu = (ImageButton) this.findViewById(R.id.p1_ib_11);
        qianzhuang = (ImageButton) this.findViewById(R.id.p1_ib_12);
        p1_tv_14 = (TextView) this.findViewById(R.id.p1_tv_14);
        adapter = (RelativeLayout) this.findViewById(R.id.adapter);
        background = (RelativeLayout) this.findViewById(R.id.background);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // crop png
        Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(),
                R.drawable.p1_bg_01);

        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        int newWidth = 320;
        int newHeight = 0;
        if (metrics.heightPixels == 533) {// 240Dip屏幕+53,背景不裁剪
            newHeight = 533;
            adapter.setMinimumHeight(53);
        } else if (metrics.heightPixels == 480) {// 160dip屏幕,背景裁剪53
            newHeight = 480;
        }

        // calculate the scale - in this case = 0.4f
        float scaleWidth = ((float) newWidth) / width;
        // float scaleHeight = ((float) newHeight) / height;
        float scaleHeight = (float) 1;
        // createa matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);

        // recreate the new Bitmap

        // Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width,
        // height, matrix, true);//不需要缩放

        Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width,
                newHeight);
        // make a Drawable from Bitmap to allow to set the BitMap
        // to the ImageView, ImageButton or what ever
        BitmapDrawable bmd = new BitmapDrawable(resizedBitmap);
        // set the Drawable on the ImageView
        background.setBackgroundDrawable(bmd);

        p1_tv_14.setSelected(true); // Set focus to the textview
        OnClickListener clicklistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.p1_ib_02:/** Start a new Activity MyCards.java */
                    Intent intent31 = new Intent(Page_p1_Activity.this,
                            Page_p31_Activity.class);
                    startActivityForResult(intent31, 1);
                    System.out.println("click rob");
                    break;
                case R.id.p1_ib_03:/** AlerDialog when click on Exit */
                    Intent intent3 = new Intent(Page_p1_Activity.this,
                            Page_p3_Activity.class);
                    startActivityForResult(intent3, 1);
                    System.out.println("click invite");
                    break;
                case R.id.p1_ib_04:/** AlerDialog when click on Exit */
                    Intent intent5 = new Intent(Page_p1_Activity.this,
                            Page_p5_Activity.class);
                    startActivityForResult(intent5, 1);
                    System.out.println("skills");
                    break;
                case R.id.p1_ib_05:/** AlerDialog when click on Exit */
                    Intent intent678 = new Intent(Page_p1_Activity.this,
                            Page_p678_Activity.class);
                    startActivityForResult(intent678, 1);
                    System.out.println("kid");
                    break;
                case R.id.p1_ib_06:/** AlerDialog when click on Exit */
                    Intent intent12 = new Intent(Page_p1_Activity.this,
                            Page_p12_Activity.class);
                    startActivityForResult(intent12, 1);
                    System.out.println("kill");
                    break;
                case R.id.p1_ib_07:/** AlerDialog when click on Exit */
                    Intent intent25 = new Intent(Page_p1_Activity.this,
                            Page_p25_Activity.class);
                    startActivityForResult(intent25, 1);
                    System.out.println("equi");
                    break;
                case R.id.p1_ib_08:/** AlerDialog when click on Exit */
                    Intent intent14 = new Intent(Page_p1_Activity.this,
                            Page_p14_Activity.class);
                    startActivityForResult(intent14, 1);
                    System.out.println("blog");
                    break;
                case R.id.p1_ib_09:
                    Intent intent16 = new Intent(Page_p1_Activity.this,
                            Page_p16_Activity.class);
                    startActivityForResult(intent16, 1);
                    System.out.println("friend");
                    break;
                case R.id.p1_ib_10:/** AlerDialog when click on Exit */
                    Intent intent23 = new Intent(Page_p1_Activity.this,
                            Page_p23_Activity.class);
                    startActivityForResult(intent23, 1);
                    System.out.println("business");
                    break;
                case R.id.p1_ib_11:/** AlerDialog when click on Exit */
                    Intent intent20 = new Intent(Page_p1_Activity.this,
                            Page_p20_Activity.class);
                    startActivityForResult(intent20, 1);
                    System.out.println("docter");
                    break;
                case R.id.p1_ib_12:/** AlerDialog when click on Exit */
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
