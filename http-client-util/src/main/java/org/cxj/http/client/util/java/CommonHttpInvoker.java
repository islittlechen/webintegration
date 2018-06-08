package org.cxj.http.client.util.java;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.common.collect.Lists;



public class CommonHttpInvoker {

	/**
	 * 调用用户中心接口
	 * 
	 * @param url
	 * @param jsonReq
	 * @return
	 * @throws IOException
	 */
	public static String invoke(String url, String jsonReq) throws IOException {
		int timeout = 5000;

		byte[] requestBytes = jsonReq.getBytes("utf-8");
		// 发送请求，等待响应
		byte[] resultBytes = HttpFormConnector.doPost(url, requestBytes, "application/json", timeout);
		return new String(resultBytes,"utf-8");
	}


	/**
	 * 解析携带列表数据的响应
	 * 
	 * @param jsonResult
	 * @param clazz
	 * @param listName
	 *            返回的list的key名称
	 * @return
	 * @throws Exception 
	 */

	@SuppressWarnings("unchecked")
	public static <T> List<T> parseListResult(String jsonResult, Class<T> clazz, String listName) throws Exception {
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);

		int returnCode = jsonObject.getInt("ret");
		if (returnCode != 0) {
			String msg = jsonObject.getString("msg");
			throw new Exception(msg);
		}
		JSONObject content = jsonObject.getJSONObject("content");
		if (content.containsKey(listName)) {
			JSONArray jsonArray = content.getJSONArray(listName);
			Collection<T> collection = JSONArray.toCollection(jsonArray, clazz);
			return Lists.newArrayList(collection);
		}
		return null;
	}

	/**
	 * 解析返回数据的响应，返回content，如果没有，返回null
	 * 
	 * @param jsonResp
	 * @throws Exception 
	 */
	public static JSONObject parseResult(String jsonResp) throws Exception {
		JSONObject jsonObject = JSONObject.fromObject(jsonResp);
		int returnCode = jsonObject.getInt("ret");
		if (returnCode != 0) {
			String msg = jsonObject.getString("msg");
			throw new Exception(msg);
		} else {
			if (jsonObject.containsKey("content")) {
				return jsonObject.getJSONObject("content");
			}
		}
		return null;
	}

}
