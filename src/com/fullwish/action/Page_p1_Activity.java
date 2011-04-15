package com.fullwish.action;

import org.json.JSONException;
import org.json.JSONObject;

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

import com.fullwish.utils.ConnUtil;
import com.fullwish.utils.PATH;

public class Page_p1_Activity extends Activity {
    // private JSONObject user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);
        initActivity();
    }

    private void initActivity() {
        TextView p1_tv_01, p1_tv_02, p1_tv_03, p1_tv_04, p1_tv_05, p1_tv_06, p1_tv_07, p1_tv_08, p1_tv_09, p1_tv_10, p1_tv_11, p1_tv_12, p1_tv_13, p1_tv_14, p1_tv_15;
        ImageButton p1_ib_01, p1_ib_02, p1_ib_03, p1_ib_04, p1_ib_05, p1_ib_06, p1_ib_07, p1_ib_08, p1_ib_09, p1_ib_10, p1_ib_11, p1_ib_12;
        RelativeLayout adapter, background;
        JSONObject user;// 执行ConnUtil.search返回
        String user_email, user_money, user_level, user_action, user_attack, user_nickname, user_experience, user_friend, user_energy, user_healthpoint, user_carrer, user_country;
        Bundle extras_p1;
        extras_p1 = this.getIntent().getExtras();
        user_email = extras_p1.getString("user_email");
     //   user = ConnUtil.searchUser(user_email, PATH.P1_SEARCH);
        /* 组件赋值 */
        p1_tv_01 = (TextView) this.findViewById(R.id.p1_tv_01);
        p1_tv_02 = (TextView) this.findViewById(R.id.p1_tv_02);
        p1_tv_03 = (TextView) this.findViewById(R.id.p1_tv_03);
        p1_tv_04 = (TextView) this.findViewById(R.id.p1_tv_04);
        p1_tv_05 = (TextView) this.findViewById(R.id.p1_tv_05);
        p1_tv_06 = (TextView) this.findViewById(R.id.p1_tv_06);
        p1_tv_07 = (TextView) this.findViewById(R.id.p1_tv_07);
        p1_tv_08 = (TextView) this.findViewById(R.id.p1_tv_08);
        p1_tv_09 = (TextView) this.findViewById(R.id.p1_tv_09);
        p1_tv_10 = (TextView) this.findViewById(R.id.p1_tv_10);
        p1_tv_11 = (TextView) this.findViewById(R.id.p1_tv_11);
        p1_tv_12 = (TextView) this.findViewById(R.id.p1_tv_12);
        p1_tv_13 = (TextView) this.findViewById(R.id.p1_tv_13);
        p1_tv_14 = (TextView) this.findViewById(R.id.p1_tv_14);
        p1_tv_15 = (TextView) this.findViewById(R.id.p1_tv_15);

        p1_ib_01 = (ImageButton) this.findViewById(R.id.p1_ib_01);
        p1_ib_02 = (ImageButton) this.findViewById(R.id.p1_ib_02);
        p1_ib_03 = (ImageButton) this.findViewById(R.id.p1_ib_03);
        p1_ib_04 = (ImageButton) this.findViewById(R.id.p1_ib_04);
        p1_ib_05 = (ImageButton) this.findViewById(R.id.p1_ib_05);
        p1_ib_06 = (ImageButton) this.findViewById(R.id.p1_ib_06);
        p1_ib_07 = (ImageButton) this.findViewById(R.id.p1_ib_07);
        p1_ib_08 = (ImageButton) this.findViewById(R.id.p1_ib_08);
        p1_ib_09 = (ImageButton) this.findViewById(R.id.p1_ib_09);
        p1_ib_10 = (ImageButton) this.findViewById(R.id.p1_ib_10);
        p1_ib_11 = (ImageButton) this.findViewById(R.id.p1_ib_11);
        p1_ib_12 = (ImageButton) this.findViewById(R.id.p1_ib_12);

        adapter = (RelativeLayout) this.findViewById(R.id.adapter);
        background = (RelativeLayout) this.findViewById(R.id.background);

        p1_tv_14.setSelected(true); // Set focus to the textview
        /* 自适应屏幕 */
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // crop png
        Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(), R.drawable.p1_bg_01);

        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        int newWidth = 320;
        int newHeight = 0;
        if (metrics.heightPixels == 533) {// 240Dip+53
            newHeight = 533;
            adapter.setMinimumHeight(53);
        } else if (metrics.heightPixels == 480) {// 160dip
            newHeight = 480;
        }
        // calculate the scale
        float scaleWidth = ((float) newWidth) / width;
        // float scaleHeight = ((float) newHeight) / height;
        float scaleHeight = (float) 1;
        // createa matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        // Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width,
        // height, matrix, true);//缩放比例
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, newHeight);
        // make a Drawable from Bitmap to allow to set the BitMap
        // to the ImageView, ImageButton or what ever
        BitmapDrawable bmd = new BitmapDrawable(resizedBitmap);
        // set the Drawable on the ImageView
        background.setBackgroundDrawable(bmd);
        /* 重写监听时间 */
        OnClickListener clicklistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.p1_ib_02:
                    Intent intent31 = new Intent(Page_p1_Activity.this, Page_p31_Activity.class);
                    startActivityForResult(intent31, 1);
                    break;
                case R.id.p1_ib_03:
                    Intent intent3 = new Intent(Page_p1_Activity.this, Page_p3_Activity.class);
                    startActivityForResult(intent3, 1);
                    break;
                case R.id.p1_ib_04:
                    Intent intent5 = new Intent(Page_p1_Activity.this, Page_p5_Activity.class);
                    startActivityForResult(intent5, 1);
                    break;
                case R.id.p1_ib_05:
                    Intent intent678 = new Intent(Page_p1_Activity.this, Page_p678_Activity.class);
                    startActivityForResult(intent678, 1);
                    break;
                case R.id.p1_ib_06:
                    Intent intent12 = new Intent(Page_p1_Activity.this, Page_p12_Activity.class);
                    startActivityForResult(intent12, 1);
                    break;
                case R.id.p1_ib_07:
                    Intent intent25 = new Intent(Page_p1_Activity.this, Page_p25_Activity.class);
                    startActivityForResult(intent25, 1);
                    break;
                case R.id.p1_ib_08:
                    Intent intent14 = new Intent(Page_p1_Activity.this, Page_p14_Activity.class);
                    startActivityForResult(intent14, 1);
                    break;
                case R.id.p1_ib_09:
                    Intent intent16 = new Intent(Page_p1_Activity.this, Page_p16_Activity.class);
                    startActivityForResult(intent16, 1);
                    break;
                case R.id.p1_ib_10:
                    Intent intent23 = new Intent(Page_p1_Activity.this, Page_p23_Activity.class);
                    startActivityForResult(intent23, 1);
                    break;
                case R.id.p1_ib_11:
                    Intent intent20 = new Intent(Page_p1_Activity.this, Page_p20_Activity.class);
                    startActivityForResult(intent20, 1);
                    break;
                case R.id.p1_ib_12:
                    Intent intent24 = new Intent(Page_p1_Activity.this, Page_p24_Activity.class);
                    startActivityForResult(intent24, 1);
                    break;
                }
            }
        };
        /* 设置监听 */
        p1_ib_02.setOnClickListener(clicklistener);
        p1_ib_03.setOnClickListener(clicklistener);
        p1_ib_04.setOnClickListener(clicklistener);
        p1_ib_05.setOnClickListener(clicklistener);
        p1_ib_06.setOnClickListener(clicklistener);
        p1_ib_07.setOnClickListener(clicklistener);
        p1_ib_08.setOnClickListener(clicklistener);
        p1_ib_09.setOnClickListener(clicklistener);
        p1_ib_10.setOnClickListener(clicklistener);
        p1_ib_11.setOnClickListener(clicklistener);
        p1_ib_12.setOnClickListener(clicklistener);

        /* 设置数据 */
        /* 获取数据 */
        user = ConnUtil.searchUser(user_email, PATH.P1_SEARCH);
        try {
            System.out.println("p1 " + user.getString("user_email"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*
         * p1_tv_01.setText(user_money);// 金钱 p1_tv_02.setText(user_level);// 等级
         * // p1_tv_03.setText(user_money_re);// 金钱恢复时间
         * p1_tv_04.setText(user_experience);// 经验
         * p1_tv_05.setText(user_money);// 精力 p1_tv_06.setText(user_money);//
         * 精力倒数 p1_tv_07.setText(user_money);// 体力
         * p1_tv_08.setText(user_money);// 体力倒数 p1_tv_09.setText(user_money);//
         * 移动力 p1_tv_10.setText(user_money);// 移动力倒数
         * p1_tv_11.setText(user_money);// 好友数 p1_tv_12.setText(user_money);//
         * 用户昵称 p1_tv_13.setText(user_money);// 用户等级
         * p1_tv_14.setText(user_money);// 广告信息 p1_tv_15.setText(user_money);//
         * 玩家id
         */
    }
}
