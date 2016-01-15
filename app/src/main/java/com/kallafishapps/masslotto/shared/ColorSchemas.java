package com.kallafishapps.masslotto.shared;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.kallafishapps.masslotto.R;

public final class ColorSchemas {

	public static void SetActivityColorSchema(Activity activity, Context context)
	{
		switch (activity.getClass().getSimpleName())
		{
			case "CheckNumbersActivity":
				SetCheckNumbersActivityColors(activity, context);
				break;

			case "NumberGeneratorActivity":
				SetGameActivityColors(activity, context);
				break;

			case "MainMenuActivity":
				SetMainMenuActivityColors(activity, context);
				break;

			case "SettingsActivity":
				SetSettingsActivityColors(activity, context);
				break;
		}
	}

	private static void SetCheckNumbersActivityColors(Activity activity, Context context)
	{
		RelativeLayout layout = (RelativeLayout) activity.findViewById(R.id.check_numbers_layout);
		if (ColorPreferences.getBackgroundColorPreference(context) == 0) {
			setDefaultColors(context);
		}
		layout.setBackgroundColor(ColorPreferences.getBackgroundColorPreference(context));

		List<TextView> textViews = new ArrayList<TextView>();
		textViews.add((TextView) activity.findViewById(R.id.game_spinner_label));
		textViews.add((TextView) activity.findViewById(R.id.check_numbers_url_label));
		textViews.add((TextView) activity.findViewById(R.id.check_numbers_url));
		for (TextView textView : textViews) {
			textView.setTextColor(ColorPreferences.getTextColorPreference(context));
		}

		List<Spinner> spinners = new ArrayList<Spinner>();
		spinners.add((Spinner) activity.findViewById(R.id.spinner_games));
		for (Spinner spinner : spinners)
		{
			if (spinner.getChildAt(0) != null)
				((TextView) spinner.getChildAt(0)).setTextColor(ColorPreferences.getTextColorPreference(context));
		}
	}

	private static void SetGameActivityColors(Activity activity, Context context)
	{
		RelativeLayout layout = (RelativeLayout) activity.findViewById(R.id.game_layout);
		if (ColorPreferences.getBackgroundColorPreference(context) == 0) {
			setDefaultColors(context);
		}
		layout.setBackgroundColor(ColorPreferences.getBackgroundColorPreference(context));

		List<Button> buttons = new ArrayList<Button>();
		buttons.add((Button) activity.findViewById(R.id.game_button_generate_numbers));
		buttons.add((Button) activity.findViewById(R.id.game_button_back));
		buttons.add((Button) activity.findViewById(R.id.game_button_next));
		for (Button button : buttons) {
			button.setTextColor(ColorPreferences.getTextColorPreference(context));
		}

		List<TextView> textViews = new ArrayList<TextView>();
		textViews.add((TextView) activity.findViewById(R.id.game_spinner_label));
		textViews.add((TextView) activity.findViewById(R.id.game_numbers_label));
		textViews.add((TextView) activity.findViewById(R.id.game_bonus_label));
		for (TextView textView : textViews) {
			textView.setTextColor(ColorPreferences.getTextColorPreference(context));
		}

		List<Spinner> spinners = new ArrayList<Spinner>();
		spinners.add((Spinner) activity.findViewById(R.id.spinner_games));
		for (Spinner spinner : spinners)
		{
			if (spinner.getChildAt(0) != null)
				((TextView) spinner.getChildAt(0)).setTextColor(ColorPreferences.getTextColorPreference(context));
		}
	}

	private static void SetMainMenuActivityColors(Activity activity, Context context)
	{
		RelativeLayout layout = (RelativeLayout) activity.findViewById(R.id.main_menu_layout);
		if (ColorPreferences.getBackgroundColorPreference(context) == 0) {
			setDefaultColors(context);
		}
		layout.setBackgroundColor(ColorPreferences.getBackgroundColorPreference(context));

		List<Button> buttons = new ArrayList<Button>();
		buttons.add((Button) activity.findViewById(R.id.main_menu_check_numbers_button));
		buttons.add((Button) activity.findViewById(R.id.main_menu_play_button));
		buttons.add((Button) activity.findViewById(R.id.main_menu_settings_button));
		for (Button button : buttons) {
			button.setTextColor(ColorPreferences.getTextColorPreference(context));
		}
	}

	private static void SetSettingsActivityColors(Activity activity, Context context)
	{
		LinearLayout layout = (LinearLayout) activity.findViewById(R.id.settings_layout);
		if (ColorPreferences.getBackgroundColorPreference(context) == 0) {
			setDefaultColors(context);
		}
		layout.setBackgroundColor(ColorPreferences.getBackgroundColorPreference(context));

		List<TextView> textViews = new ArrayList<TextView>();
		textViews.add((TextView) activity.findViewById(R.id.settings_color_spinner_label));
		textViews.add((TextView) activity.findViewById(R.id.settings_games_spinner_label));
		textViews.add((TextView) activity.findViewById(R.id.settings_bottom_spinner_label));
		textViews.add((TextView) activity.findViewById(R.id.settings_display_bottom_textview));
		textViews.add((TextView) activity.findViewById(R.id.settings_top_spinner_label));
		textViews.add((TextView) activity.findViewById(R.id.settings_display_top_textview));
		for (TextView textView : textViews) {
			textView.setTextColor(ColorPreferences.getTextColorPreference(context));
		}

		List<Spinner> spinners = new ArrayList<Spinner>();
		spinners.add((Spinner) activity.findViewById(R.id.settings_color_spinner));
		spinners.add((Spinner) activity.findViewById(R.id.spinner_games));
		spinners.add((Spinner) activity.findViewById(R.id.settings_bottom_spinner));
		spinners.add((Spinner) activity.findViewById(R.id.settings_top_spinner));
		for (Spinner spinner : spinners)
		{
			if (spinner.getChildAt(0) != null)
				((TextView) spinner.getChildAt(0)).setTextColor(ColorPreferences.getTextColorPreference(context));
		}

	}

	private static void setDefaultColors(Context context)
	{
		Resources res = context.getResources();
		ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_white));
		ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
	}

	public static void setColorSchema(String color, View view, Context context)
	{
		Resources res = view.getResources();

		switch (color)
		{
			case "White":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_white));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Black":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_black));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_white));
				break;

			case "Blue":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_blue));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Green":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_green));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Grey":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_grey));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Orange":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_orange));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Pink":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_pink));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Purple":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_purple));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Red":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_red));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			case "Yellow":
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_yellow));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;

			default:
				ColorPreferences.setBackgroundColorCode(res.getColor(R.color.color_white));
				ColorPreferences.setTextColorCode(res.getColor(R.color.color_black));
				break;
		}
		ColorPreferences.setColorPreferences(context);
	}
}
