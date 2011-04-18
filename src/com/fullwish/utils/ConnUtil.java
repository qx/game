/**
 * 
 */
package com.fullwish.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * @author fullwish oyqx 连接服务器,发送客户端数据,以及接受服务器数据
 */
public class ConnUtil {
    private static String ssid;

    private static String user;

    /**
     * @param user
     *            the user to set(email)
     */
    public static void setUser(String user) {
        ConnUtil.user = user;
    }

    /**
     * @return the user:用户email(user_email)
     */
    public static String getUser() {
        return user;
    }

    /**
     * @param ssid
     *            :用户第一次会话的sessionid(ssid) the ssid to set
     */
    public static void setSsid(String ssid) {
        ConnUtil.ssid = ssid;
    }

    /**
     * @return the ssid:用户第一次会话的sessionid(ssid) the ssid to set
     */
    public static String getSsid() {
        return ssid;
    }

    /**
     * 
     * @param user_json
     *            :string格式的 json
     * @param externalpath
     *            :/p1_update
     */
    public static void userUpdate(String user_string, String externalpath) {
        System.out.println("connUtil userUpdate");
        /* 发送参数(user_email) */
        HttpPost httpRequest = new HttpPost(PATH.BASE + externalpath);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_string", user_string));// user_string在服务器设置setter方法接受参数
        try {
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequest.setEntity(httpentity);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);// 执行请求
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    /**
     * @author oyqx
     * @param String
     *            user_email 用户名(邮箱,唯一)
     * @param String
     *            user_password 用户密码(MD5加密)
     * @param String
     *            externalpath 服务器基本访问路径BASE="http://192.168.2.103:8080";
     *            externalpath=/p1_search
     * @return JSONObject 由服务器传来的json,构建成JSONObject
     * 
     */
    public static JSONObject searchUser(String user_email, String externalpath) {
        System.out.println("connUtil searchUser");
        /* 发送参数(user_email) */
        HttpPost httpRequest = new HttpPost(PATH.BASE + externalpath);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_email", user_email));// user_string在服务器设置setter方法接受参数
        try {
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequest.setEntity(httpentity);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);// 执行请求
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        /* 接收数据(user) */
        /*
         * {"user":
         * {"user_action":0,"user_attack":0,"user_bekidnap":0,"user_carrer"
         * :null,
         * "user_country":null,"user_defense":0,"user_email":"abc@test.com"
         * ,"user_energy"
         * :0,"user_experience":0,"user_fight_lose":0,"user_fight_win"
         * :0,"user_friend"
         * :0,"user_healthpoint":0,"user_hideAttack":0,"user_hideDefense"
         * :0,"user_kidnap"
         * :0,"user_level":0,"user_microblog":null,"user_money":0
         * ,"user_nickname"
         * :null,"user_password":"444bcb3a3fcf8389296c49467f27e1d6"
         * ,"user_rescue"
         * :0,"user_reward_Point":0,"user_skill_Point":0},"user_string":null}
         */
        // System.out.println("connutil_searchUser start1");
        String new_path = PATH.BASE + externalpath;
        // System.out.println("connutil_searchUser start2");
        JSONObject jsob = null;
        System.out.println("connutil_searchUser start3" + new_path);
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
                // System.out.println("connutil_searchUser jsob is : " +
                // jsob.toString());
            }
        } catch (Exception e) {
        }
        return jsob;
    }

    /**
     *@author oyqx
     * 
     * @param user
     *            JSONObject
     * @param string
     *            paht
     */
    public static void addUser(JSONObject user, String path) {
        /*
         * String user_email=user.getString("user_email"); String
         * user_password=user.getString("user_password");
         */
        try {
            HttpPost httpRequest = new HttpPost(path);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("user_string", user.toString()));// user_string在服务器设置setter方法接受参数
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequest.setEntity(httpentity);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);

            // System.out.println("connutil:"+user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @author fullwish:更新用户信息
     * @param user_string
     *            组拼string获得的json格式的string
     * @param String
     *            path路径
     * @return Boolean true;登录成功 false:登录失败
     * 
     */
    public static boolean userLogin(String user_string, String path) {// 登录方法
        System.out.println("connUtil userLogin");
        JSONObject jsob = null;
        Boolean ispass = false;
        try {
            HttpPost httpRequest = new HttpPost(path);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("user_string", user_string));// user_string在服务器设置setter方法接受参数
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequest.setEntity(httpentity);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);// 执行请求

            // ///////////////////////////////////////////////////////////////
            // ///////////得到服务器返回数据必须重新建立连接?///////////////////
            // ////////////////////导致执行两次action中方法/////////////////////
            // ///////////////////////////////////////////////////////////////
            // ///////////////////////////////////////////////////////////////
            // ///////////////////////////////////////////////////////////////
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 取得返回的字符串
                String jsonString = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("httpResponse: " + jsonString);
                jsob = new JSONObject(jsonString);
                System.out.println("connutil_userlogin" + jsonString);
                // inStream.close();
                // conn.disconnect();
                /*
                 * {"user_response":"{\"ssid\":\"629C53AB21CBFCDF4EA
                 * 79D9025ACC134\",\"user\":\"abc@test.com\"}"}
                 */// System.out.println(jsob.getJSONObject("user_response").toString());//不是JSONObject
                String username = (new JSONObject(user_string)).getString("user_email");
                ConnUtil.setSsid(new JSONObject(jsob.get("user_response").toString()).getString("ssid"));
                ConnUtil.setUser(new JSONObject(jsob.get("user_response").toString()).getString("user"));
                if (new JSONObject(jsob.get("user_response").toString()).getString("user").equals(username)) {
                    ispass = true;
                    System.out.println("登陆成功");
                } else {// 用户空则登录失败
                    System.out.println(new JSONObject(jsob.get("user_response").toString()).getString("error_message"));
                    ispass = false;
                }
            }

            // URL url = new URL(path);
            // // HttpURLConnection conn = (HttpURLConnection)
            // // url.openConnection();
            // HttpURLConnection conn = (HttpURLConnection)
            // url.openConnection();
            // InputStream inStream = conn.getInputStream();
            // byte[] data = readStream(inStream);
            // String jsonString = new String(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ispass;
    }

    /**
     * @param JSONObject
     *            user组拼
     * @param String
     *            path 路径
     */
    public static void deleteUserInfo(JSONObject user, String path) {

    }

    /**
     * 读取传入数据流
     * 
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
