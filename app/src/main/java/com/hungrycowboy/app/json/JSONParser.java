package com.hungrycowboy.app.json;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Helper class to Send objects to an HTTP server in JSON Format
 * Very easy to handle with PHP or other Api's
 * @author unknown
 * @version 1.0
 * @since ????
 */
public class JSONParser {

    static InputStream inputStream = null;
    static JSONObject jObj = null;
    static String json = "";

    /**
     *
     */
    public JSONParser() {

    }

    /**
     * Function to retrieve a JSON from a URL.
     * It can be used as a alternative to the makeHttpRequest when Params or method are not needed.
     * @param url
     *              the URL where the server side file is
     * @return
     *              an JSONObject with the requested data. Can be handled in a JSON Array and easily be fetched
     */
    public JSONObject getJSONFromURL(String url) {

        // Making HTTP request

        try {
            // Default httpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            inputStream.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // Try parse the string to a Json Object

        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jObj;
    }

    /**
     *
     * This function makes an HTTP Request to a file over the network
     * @param url
     *              the URL where the server side file is
     * @param method
     *              The method of sending data Ex: POST, GET, etc..
     * @param params
     *              Should be a List<NameValuePair> example:
     *              List<NameValuePair> params = new List<>();
     *              params.add("name", myName);
     *              params.add("cost", myCost);
     *
     * @return
     *              an JSONObject with the requested data. Can be handled in a JSON Array and easily be fetched
     */
    public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> params) {

        // Making http request
        try {

            // check request method
            if(method.equals("POST")) {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httPost = new HttpPost(url);
                httPost.setEntity(new UrlEncodedFormEntity(params));

                HttpResponse httpResponse = httpClient.execute(httPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();
            } else if(method.equals("GET")) {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();
            }
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch(ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            inputStream.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer error", "Error converting result " + e.toString());
        }

        // Parse the string to a json object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jObj;
    }
}