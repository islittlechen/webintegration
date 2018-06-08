package org.cxj.http.client.util.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class HttpFormConnector {

	static public byte[] doPost(String url, Map<String, String> form, int timeout) throws IOException {

		URL urlConn = new URL(url);
		HttpURLConnection connector = (HttpURLConnection) urlConn.openConnection();
		connector.setConnectTimeout(timeout);
		connector.setReadTimeout(timeout);
		connector.setDoOutput(true);
		connector.setDoInput(true);
		connector.setRequestMethod("POST");
		connector.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connector.connect();

		String strForm = makeHttpForm(form);

		OutputStream out = connector.getOutputStream();
		out.write(strForm.getBytes("UTF-8"));
		out.flush();

		byte[] res = readByteBuffer(connector.getInputStream());
		connector.disconnect();

		return res;

	}

	static public byte[] doPost(String url, byte[] data, String contentType, int timeout) throws IOException {
		URL urlConn = new URL(url);
		HttpURLConnection connector = (HttpURLConnection) urlConn.openConnection();
		connector.setConnectTimeout(timeout);
		connector.setReadTimeout(timeout);
		connector.setDoOutput(true);
		connector.setDoInput(true);
		connector.setRequestMethod("POST");
		connector.setRequestProperty("Content-Type", contentType);
		connector.connect();

		OutputStream out = connector.getOutputStream();
		out.write(data);
		out.flush();

		byte[] res = readByteBuffer(connector.getInputStream());
		connector.disconnect();

		return res;
	}

	static public byte[] doGet(String url, Map<String, String> form, int timeout) throws IOException {

		String strForm = makeHttpForm(form);
		URL urlConn = new URL(url + "?" + strForm);
		HttpURLConnection connector = (HttpURLConnection) urlConn.openConnection();
		connector.setConnectTimeout(timeout);
		connector.setReadTimeout(timeout);
		connector.setDoOutput(false);
		connector.setDoInput(true);
		connector.setRequestMethod("GET");
		connector.connect();

		byte[] res = readByteBuffer(connector.getInputStream());
		connector.disconnect();

		return res;
	}

	static public String makeHttpForm(Map<String, String> form) throws IOException {
		List<String> keys = new ArrayList<String>(form.keySet());

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = form.get(key);
			if (StringUtils.isEmpty(key)) {
				continue;
			}
			if (value == null) {
				continue;
			}
			if (i == keys.size() - 1) {
				prestr += URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
			} else {
				prestr += URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8") + "&";
			}
		}

		return prestr;
	}

	static public byte[] readByteBuffer(InputStream in) throws IOException {

		byte[] buffer = new byte[256];
		byte[] res = new byte[0];
		for (int count = 0; (count = in.read(buffer)) != -1;) {
			byte[] temp = new byte[res.length + count];
			System.arraycopy(res, 0, temp, 0, res.length);
			System.arraycopy(buffer, 0, temp, res.length, count);
			res = temp;
		}

		return res;
	}

	static public Map<String, String> parserForm(String form) {
		Map<String, String> res = new HashMap<String, String>();
		try {
			String[] items = form.split("&");
			for (String item : items) {
				int pos = item.indexOf("=");
				if (pos != -1) {
					String[] pair = item.split("=");
					res.put(URLDecoder.decode(pair[0], "UTF-8"), URLDecoder.decode(pair[1], "UTF-8"));
				}
			}
			return res;
		} catch (Exception e) {
			return res;
		}
	}

}
