package br.com.hoteisbh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static Date formataData(String data) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
			Date date = dateFormat.parse(data.trim());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
