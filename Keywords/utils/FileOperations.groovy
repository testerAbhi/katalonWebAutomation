package utils

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import java.nio.file.Files
import java.nio.file.Paths

import org.apache.commons.io.IOExceptionWithCause
import org.json.JSONArray
import org.json.JSONObject

public class FileOperations {

	public static String getValueFromDataFile(String filePath, String key) {
		try {
			def data = findTestData(filePath).getAllData()
			def value
			for (int i = 0; i < data.size(); i++) {
				def list = data.get(i)
				def k = list.get(0)
				def v = list.get(1)
				if (k.equals(key)) {
					value = v
					break
				}
			}
			return value
		}
		catch (IOExceptionWithCause e) {
			println("There is some issue with file"+ e.getMessage())
		}
	}

	public static Object getValueFromJsonFile(String filePath, String key) {
		try {
			byte[] fileBytes = Files.readAllBytes(Paths.get(filePath))
			String fileContent = new String(fileBytes)
			JSONObject jsonObject = new JSONObject(fileContent)
			return jsonObject.opt(key)
		}
		catch (IOExceptionWithCause e) {
			println("There is some issue with file"+ e.getMessage())
		}
	}

	public static List<String> getJsonArray(String filePath, String key){
		try{
			byte[] fileBytes = Files.readAllBytes(Paths.get(filePath))
			String fileContent = new String(fileBytes)
			JSONObject jsonObject = new JSONObject(fileContent)

			List<String> valuesList = new ArrayList<>()
			if (jsonObject.has(key)) {
				Object value = jsonObject.get(key)
				if (value instanceof JSONArray) {
					JSONArray jsonArray = (JSONArray) value
					for (int i = 0; i < jsonArray.length(); i++) {
						valuesList.add(jsonArray.getString(i))
					}
				} else {
					valuesList.add(value.toString())
				}
			}
			return valuesList
		}
		catch (IOExceptionWithCause e) {
			println("There is some issue with file"+ e.getMessage())
		}
	}
}
