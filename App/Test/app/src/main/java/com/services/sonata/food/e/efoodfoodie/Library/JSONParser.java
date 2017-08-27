package com.services.sonata.food.e.efoodfoodie.Library;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public abstract class JSONParser {

    public static JSONObject makeJSONObject(String requestUrl, KeyValuePairs getParams, KeyValuePairs postParams, KeyValuePairs headers) throws JSONException {
        String response = "";
        if (getParams != null)
            requestUrl += "?" + getParams.toString();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            if (postParams != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                byte[] postData = postParams.toString().getBytes(StandardCharsets.UTF_8);
                int postDataLength = postData.length;

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("charset", "utf-8");
                httpURLConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

                if (headers != null) {
                    for (int i = 0; i < headers.size(); i++) {
                        KeyValuePair keyValuePair = headers.get(i);
                        httpURLConnection.setRequestProperty(keyValuePair.getKey(), keyValuePair.getValue());

                    }
                }

                httpURLConnection.setUseCaches(false);
                OutputStream wr = httpURLConnection.getOutputStream();
                wr.write(postData);
                wr.close();
            }

            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            response = stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(response);
    }

    public static JSONObject makeJSONObject(String api, KeyValuePairs getKeyValuePairs) throws JSONException {
        return makeJSONObject(api, getKeyValuePairs, null, null);
    }

    public static JSONObject makeJSONObject(String api, KeyValuePairs getKeyValuePairs, KeyValuePairs postKeyValuePairs) throws JSONException {
        return makeJSONObject(api, getKeyValuePairs, postKeyValuePairs, null);
    }
}
