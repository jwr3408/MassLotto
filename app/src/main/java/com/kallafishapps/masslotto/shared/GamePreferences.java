package com.kallafishapps.masslotto.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class GamePreferences {

	private static final String PREFERENCES = "Preferences";

	public static final String PREFERENCES_DEFAULTGAME = "defaultGame";
	public static final String PREFERENCES_LEAST = "bottom";
	public static final String PREFERENCES_TOP = "top";
	private static final String PREFERENCES_COLOR = "color_spinner_default";
	private static String default_game = "";
	private static String bottom_total = "all";
	private static String top_total = "all";

	public static String getDefaultGamePreference(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		return settings.getString(PREFERENCES_DEFAULTGAME, getDefaultGame());
	}

	public static String getBottomPreference(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		return settings.getString(PREFERENCES_LEAST, getBottomTotal());
	}

	public static String getTopPreference(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		return settings.getString(PREFERENCES_TOP, getTopTotal());
	}

	public static void setGamePreferences(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
		Editor editor = settings.edit();
		editor.putString(PREFERENCES_COLOR, ColorPreferences.getDefaultSelectedColor());
		editor.putString(PREFERENCES_DEFAULTGAME, getDefaultGame());
		editor.putString(PREFERENCES_LEAST, getBottomTotal());
		editor.putString(PREFERENCES_TOP, getTopTotal());
		editor.commit();
	}

	public static String getDefaultGame()
	{
		return default_game;
	}

	public static void setDefaultGame(String default_game)
	{
		GamePreferences.default_game = default_game;
	}

	public static String getBottomTotal()
	{
		return bottom_total;
	}

	public static void setBottomTotal(String bottom_total)
	{
		GamePreferences.bottom_total = bottom_total;
	}

	public static String getTopTotal()
	{
		return top_total;
	}

	public static void setTopTotal(String top_total)
	{
		GamePreferences.top_total = top_total;
	}
}
