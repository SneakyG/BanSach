package sneakyg.giang.utils;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer[] toIntArray() {
		JSONObject jsonObject = new JSONObject(value);
		JSONArray jsonArray = jsonObject.getJSONArray("ids");
		Integer[] ids = new Integer[jsonArray.length()];
		for(int i = 0 ; i < ids.length ;i++) {
			ids[i] = jsonArray.getInt(i);
		}
		return ids;
	}

	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpUtil(sb.toString());
	}
}
