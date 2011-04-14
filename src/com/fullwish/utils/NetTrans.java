package com.fullwish.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetTrans {
    /* ��ȡ������,�����ֽ����� */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream ba_outStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buff)) != -1) {
            ba_outStream.write(buff, 0, len);
        }
        ba_outStream.close();
        inStream.close();
        return ba_outStream.toByteArray();

    }

    /*
     * ���·����ȡ�ļ� ���ؿ�
     */
    public static void getImage(String path) throws Exception {
        // String path =
        // "http://i1.itc.cn/20101119/241_39e42ede_2aed_4757_ad39_ebdd14efc35e_0.jpg";
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // conn.setConnectTimeout(20);
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(6 * 1000);
        if (conn.getResponseCode() == 200) {

            InputStream inStream = conn.getInputStream();
            byte[] data = readStream(inStream);
            File file = new File("my.png");
            // FileImageOutputStream fi_outStream = new
            // FileImageOutputStream(file);
            FileOutputStream fi_outStream = new FileOutputStream(file);
            fi_outStream.write(data);
            fi_outStream.close();
        }
    }

    /* ���·����ȡHTMLҳ�����,�����ַ� */
    public static String getHtml(String path) throws Exception {
        // String path = "http://www.sohu.com";
        URL url = new URL(path);
        String content = null;
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // conn.setConnectTimeout(20);
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(20 * 1000);
        if (conn.getResponseCode() == 200) {

            InputStream inStream = conn.getInputStream();
            byte[] data = readStream(inStream);
            // File file = new File("my.text");
            // FileOutputStream fi_outStream = new FileOutputStream(file);
            // fi_outStream.write(data);
            // fi_outStream.close();
            String str = new String(data);
            content = str;
        }
        return content;
    }
}
