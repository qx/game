/**
 * 
 */
package com.fullwish.util;

/**
 * @author fullwish
 *获取服务器的JSON数据流,转化为字符串.
 *取得的数据由activity来解析获得需要的数据
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class JsonProvider {

    public static String getJSONData(String url)
            throws ClientProtocolException, IOException {
        String result = "";
        HttpGet httpGet = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                //获取对象
                InputStream inputStream = httpEntity.getContent();
                result = convertStreamToString(inputStream);

            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            throw e;
        } finally {
            httpClient.getConnectionManager().shutdown();
            httpResponse = null;
        }
        return result;

    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is, "GB2312"),// 防止模拟器上的乱码
                    512 * 1024);
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            Log.e("DataProvier convertStreamToString", e.getLocalizedMessage(),
                    e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
