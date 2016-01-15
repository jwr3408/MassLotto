package com.kallafishapps.masslotto.listeners;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

import com.kallafishapps.masslotto.R;
import com.kallafishapps.masslotto.data.GameDalc;
import com.kallafishapps.masslotto.shared.ColorPreferences;
import com.kallafishapps.masslotto.shared.ColorSchemas;
import com.kallafishapps.masslotto.shared.Common;
import com.kallafishapps.masslotto.shared.Game;
import com.kallafishapps.masslotto.shared.GamePreferences;

public class SettingsItemSelectedListener implements OnItemSelectedListener {

	private Activity _activity;

	public SettingsItemSelectedListener(Activity activity)
	{
		_activity = activity;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int i, long id)
	{
		((TextView) parent.getChildAt(0)).setTextColor(ColorPreferences.getTextColorPreference(parent.getContext()));

		if (parent instanceof Spinner)
		{
			Spinner spinner = (Spinner) parent;
			switch (spinner.getId())
			{
				case R.id.spinner_games:
					String game = parent.getItemAtPosition(i).toString();
					Game selectedGame1 = new GameDalc(parent.getContext()).getGameDetails(game);
					GamePreferences.setDefaultGame(parent.getItemAtPosition(i).toString());

					if (_activity.getClass().getSimpleName().equals("SettingsActivity"))
					{
						Common.setDisplayBottomTextView(GamePreferences.getBottomPreference(parent.getContext()), _activity, selectedGame1);
						Common.setDisplayTopTextView(GamePreferences.getTopPreference(parent.getContext()), _activity, selectedGame1);
					}
					break;

				case R.id.settings_bottom_spinner:
					String bottom = parent.getItemAtPosition(i).toString();
					GamePreferences.setBottomTotal(bottom);
					Game selectedGame2 = new GameDalc(parent.getContext()).getGameDetails(GamePreferences.getDefaultGame());
					Common.setDisplayBottomTextView(bottom, _activity, selectedGame2);
					break;

				case R.id.settings_top_spinner:
					String top = parent.getItemAtPosition(i).toString();
					GamePreferences.setTopTotal(top);
					Game selectedGame3 = new GameDalc(parent.getContext()).getGameDetails(GamePreferences.getDefaultGame());
					Common.setDisplayTopTextView(top, _activity, selectedGame3);
					break;

				case R.id.settings_color_spinner:
					String color = (String) parent.getItemAtPosition(i).toString();
					ColorPreferences.setDefaultSelectedColor(color);
					ColorSchemas.setColorSchema(color, view, parent.getContext());
					ColorSchemas.SetActivityColorSchema(_activity, parent.getContext());
					break;
			}

			GamePreferences.setGamePreferences(parent.getContext());
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{
		// do nothing
	}

}
