package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class JsonOperations {

	JsonParser parser = new JsonParser();
	JsonArray attributes = new JsonArray();
	JsonObject jsonObject = new JsonObject();

	public Map<String, String> readNestedJson(String FilePath,String jsonArray) throws IOException {

		Map<String, String> output = new HashMap<String, String>();
		FileReader file = new FileReader(FilePath);
		Object obj = parser.parse(file);
		jsonObject = (JsonObject) obj;
		attributes = (JsonArray) jsonObject.get(jsonArray);

		for (int i = 0; i < attributes.size(); i++) {
			JsonObject attributesObject = (JsonObject) attributes.get(i);
			Iterator<?> keys = attributesObject.keySet().iterator();

			while( keys.hasNext() ){
				String key = (String)keys.next();
				String value = attributesObject.get(key).toString();
				output.put(key, value);

			}
		}
		return output;
	}

	public Map<String, String> jsonToMap(String FilePath) throws FileNotFoundException{

		HashMap<String, String> map = new HashMap<String, String>();
		FileReader file = new FileReader(FilePath);
		Object obj = parser.parse(file);
		jsonObject = (JsonObject) obj;
		Iterator<?> keys = jsonObject.keySet().iterator();

		while( keys.hasNext() ){
			String key = (String)keys.next();
			String value = jsonObject.get(key).toString();
			map.put(key, value);

		}
		return map;
	}

}