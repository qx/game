/**
 * 
 */
package com.fullwish.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * @author fullwish ���ӷ�����
 */
public class ConnUtil {

    /**
     * ��ѯ�û�
     * 
     * @param user_google
     *            �û���ʶID
     * @param basepath
     *            ·��
     */
    public static JSONObject searchUser(String user_google, String basepath) {
        String new_path = basepath + "?User_google=" + user_google;
        JSONObject jsob = null;
        try {
            URL url = new URL(new_path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6 * 1000);
            if (conn.getResponseCode() == 200) {
                InputStream inStream = conn.getInputStream();
                byte[] data = readStream(inStream);
                String jsonString = new String(data);
                jsob = new JSONObject(jsonString);
                inStream.close();
                conn.disconnect();
            }
        } catch (Exception e) {
        }
        return jsob;
    }

    /**
     * �����û�
     * 
     * @param user
     *            JSONObject
     * @param string
     *            paht
     */
    public static void addUser(JSONObject user, String path) {
        // ���ж��Ƿ�������û�
        // û����д��,
        // ���򷵻���ʾ
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(PATH.BASE + "/p1_add"
                + "&User_google=abcdefg");
        /*
         * if (cookie != null) { //
         * httpClient.setCookieStore(LoginJsonUtil.cookie); List nameValuePair =
         * new ArrayList(2); nameValuePair.add(new BasicNameValuePair("uid",
         * uid)); nameValuePair.add(new
         * BasicNameValuePair("subscriptionslist[pageindex]",
         * subscriptionslist_pageindex)); nameValuePair.add(new
         * BasicNameValuePair("subscriptionslist[recordlimit]",
         * subscriptionslist_recordlimit)); httpPost.setEntity(new
         * UrlEncodedFormEntity(nameValuePair)); }
         */

    }

    /**
     * @param user
     * @param string
     */
    public static void updateUser(JSONObject user, String path) {
        // ��ѯ�Ƿ���
        // û���򷵻�
        // �����,����JSONobject,

    }

    /**
     * @param user
     * @param string
     */
    public static void deleteUserInfo(JSONObject user, String path) {
        // ��ѯ�Ƿ�ǿ�
        // ɾ���û�user_google
        
    }

    /**
     * @param inStream
     * @return
     */
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

}
