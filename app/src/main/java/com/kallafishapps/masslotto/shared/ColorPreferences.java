package com.kallafishapps.masslotto.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class ColorPreferences {

	private static final String PREFERENCES = "Preferences";

	private static final String PREFERENCES_BACKGROUND_COLOR = "background_color";
	private static final String PREFERENCES_TEXT_COLOR = "text_color";
	private static final String PREFERENCES_COLOR = "color_spinner_default";
	private static int background_color_code = 0;
	private static int text_color_code = 0;
	private static String color_spinner_default = "";

	public static void setColorPreferences(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		Editor editor = settings.edit();
		editor.putInt(PREFERENCES_BACKGROUND_COLOR, getBackgroundColorCode());
		editor.putInt(PREFERENCES_TEXT_COLOR, getTextColorCode());
		editor.putString(PREFERENCES_COLOR, getDefaultSelectedColor());
		editor.commit();
	}

	public static int getBackgroundColorPreference(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		return settings.getInt(PREFERENCES_BACKGROUND_COLOR, getBackgroundColorCode());
	}

	public static int getTextColorPreference(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		return settings.getInt(PREFERENCES_TEXT_COLOR, getTextColorCode());
	}

	public static String getDefaultColorSelection(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		return settings.getString(PREFERENCES_COLOR, getDefaultSelectedColor());
	}

	public static String getDefaultSelectedColor()
	{
		return color_spinner_default;
	}

	public static void setDefaultSelectedColor(String color)
	{
		ColorPreferences.color_spinner_default = color;
	}

	public static int getBackgroundColorCode()
	{
		return background_color_code;
	}

	public static void setBackgroundColorCode(int backgroundColorCode)
	{
		ColorPreferences.background_color_code = backgroundColorCode;
	}

	public static int getTextColorCode()
	{
		return text_color_code;
	}

	public static void setTextColorCode(int textColorCode)
	{
		ColorPreferences.text_color_code = textColorCode;
	}
}
