package com.kallafishapps.masslotto.shared;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.util.Log;

public final class Converters {

	@SuppressLint("SimpleDateFormat")
	public static Date ConvertStringToDate(String inputDate, String dateFormat)
	{
		Date dateOut = null;

		try {
			SimpleDateFormat df = new SimpleDateFormat(dateFormat);
			dateOut = df.parse(inputDate);
		}
		catch (ParseException e) {			
			Log.d("Cannot Parse Date", e.getMessage());
		}
		return dateOut;
	}

	public static String ConvertDateToString(Date dateIn)
	{
		String dateOut = null;
		DateFormat dateFormatter = null;
		dateFormatter = DateFormat.getDateInstance(DateFormat.LONG);
		dateOut = dateFormatter.format(dateIn);
		return dateOut;
	}	
}
