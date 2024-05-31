package com.devar.cabs.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Library {
	public static String getAmountConvertFromPaiseToRs(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			return "" + Float.parseFloat(strValue.trim()) / 100;
		}
		return "0";
	}

	public static Float getFloatValue(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			try {
				return Float.parseFloat(strValue.trim());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0f;
	}

	public static Long getLongValue(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			try {
				return Long.parseLong(strValue.trim());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0l;
	}

	public static int getIntValue(String strValue) {
		if (strValue != null && !strValue.equals("")) {
			try {
				return Integer.parseInt(strValue.trim());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}

	public static String trimAndRemoveSpecialCharacter(String str) throws Exception {
		if (str != null && !str.equals("")) {
			str = str.trim();
		}
		if (str != null) {
			str = str.replaceAll("'", "");
		}
		return str;
	}

	public static String toLowerCase(String str) throws Exception {
		if (str != null && !str.equals("")) {
			str = str.toLowerCase().trim();
		}
		return str;
	}

	public static GenericResponse getSuccessfulResponse(Object obj, int erorrCode, String msg) {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(obj);
		GenericResponse.setErrorCode(erorrCode);
		GenericResponse.setStatus("s");
		GenericResponse.setUserDisplayMesg("Success");
		GenericResponse.setUserDisplayMesg(msg);
		return GenericResponse;
	}
	
	public static GenericResponse getSuccessfulResponse(int erorrCode, String msg) {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setErrorCode(erorrCode);
		genericResponse.setStatus("s");
		genericResponse.setUserDisplayMesg(msg);
		return genericResponse;
	}

	public static GenericResponse noRecordFoundResponse(String msg) {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(null);
		GenericResponse.setErrorCode(0);
		GenericResponse.setStatus("s");
		GenericResponse.setUserDisplayMesg("Success");
		GenericResponse.setUserDisplayMesg(msg);
		return GenericResponse;
	}

	public static GenericResponse getFailResponseCode(int erorrCode, String strMsg) {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(null);
		GenericResponse.setErrorCode(erorrCode);
		GenericResponse.setStatus("f");
		GenericResponse.setUserDisplayMesg("Failed");
		GenericResponse.setUserDisplayMesg(strMsg);
		return GenericResponse;
	}
	
	public static GenericResponse getFailResponseCode(int erorrCode, String strMsg,Object obj) {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData(obj);
		genericResponse.setErrorCode(erorrCode);
		genericResponse.setStatus("f");
		genericResponse.setUserDisplayMesg("Failed");
		genericResponse.setUserDisplayMesg(strMsg);
		return genericResponse;
	}

	public static GenericResponse stockNotFound(String msg) {
		GenericResponse GenericResponse = new GenericResponse();
		GenericResponse.setData(null);
		GenericResponse.setErrorCode(0);
		GenericResponse.setUserDisplayMesg(msg);
		return GenericResponse;
	}
	
	
	public static GenericResponse getFailed(int erorrCode, String strMsg) {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setData("");
		genericResponse.setErrorCode(erorrCode);
		genericResponse.setStatus("f");
		genericResponse.setUserDisplayMesg("Failed");
		genericResponse.setUserDisplayMesg(strMsg);
		return genericResponse;
	}
	

	public static String getObjectToJson(Object object) {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = Obj.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	public static HttpHeaders getHeader(Map<String, String> headers) {
		HttpHeaders headersObj = new HttpHeaders();
		Iterator<String> it = headers.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = (String) headers.get(key);
			headersObj.set(key, value);
		}
		return headersObj;
	}

	public static UriComponentsBuilder getUri(String url, Map<String, String> headers) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		return builder;
	}

	public static <T> boolean IsNullOrEmpty(Collection<T> list) {
		return list == null || list.isEmpty();
	}

	public static <T> boolean IsNullOrEmpty(Map<Double, String> map) {
		return map == null || map.isEmpty();
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	/**
	 * @param Double
	 * @return Double
	 */
	public static Double ifNullRetunZero(Double value) {
		if (value == null) {
			return 0.0;
		}
		return value;
	}
}
