package com.kallafishapps.masslotto.activities;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.kallafishapps.masslotto.R;
import com.kallafishapps.masslotto.data.GameDalc;
import com.kallafishapps.masslotto.interfaces.IGamePreferences;
import com.kallafishapps.masslotto.listeners.SettingsItemSelectedListener;
import com.kallafishapps.masslotto.shared.ColorPreferences;
import com.kallafishapps.masslotto.shared.ColorSchemas;
import com.kallafishapps.masslotto.shared.GamePreferences;

public class SettingsActivity extends BaseActivity implements IGamePreferences {

	private String defaultColor = "";
	private String defaultGame = "";
	private String defaultBottom = "";
	private String defaultTop = "";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Initialize();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Initialize();
	};

	@Override
	public void Initialize()
	{
		setColors();
		setPreferences();
		loadGameSpinner();
		loadBottomSpinner();
		loadTopSpinner();
		loadColorSpinner();
	}

	@Override
	public void setPreferences()
	{
		defaultColor = ColorPreferences.getDefaultColorSelection(this);
		defaultGame = GamePreferences.getDefaultGamePreference(this);
		defaultBottom = GamePreferences.getBottomPreference(this);
		defaultTop = GamePreferences.getTopPreference(this);
	}

	@Override
	public int getLayoutResourceId()
	{
		return R.layout.activity_settings;
	}

	@Override
	public void setColors()
	{
		ColorSchemas.SetActivityColorSchema(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu_settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_home:
				startActivity(new Intent(SettingsActivity.this, MainMenuActivity.class));
				return true;

			case R.id.menu_game:
				startActivity(new Intent(SettingsActivity.this, NumberGeneratorActivity.class));
				return true;

			case R.id.menu_check_numbers:
				startActivity(new Intent(SettingsActivity.this, CheckNumbersActivity.class));
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void loadGameSpinner()
	{
		GameDalc dalc = new GameDalc(this);

		List<String> games = dalc.getGames();
		Spinner spinner = (Spinner) findViewById(R.id.spinner_games);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, games);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SettingsItemSelectedListener(this));

		if (defaultGame != "")
		{
			spinner.setSelection(games.indexOf(defaultGame));
		}
		else
		{
			spinner.setSelection(0);
		}
	}

	private void loadBottomSpinner()
	{
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerBottomArray, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = (Spinner) findViewById(R.id.settings_bottom_spinner);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SettingsItemSelectedListener(this));

		if (defaultBottom != "") {

			List<String> bottomList = new ArrayList<String>();
			for (int i = 0; i < adapter.getCount(); i++)
				bottomList.add((String) adapter.getItem(i));

			spinner.setSelection(bottomList.indexOf(defaultBottom));

		} else {
			spinner.setSelection(0);
		}
	}

	private void loadTopSpinner()
	{
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerTopArray, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = (Spinner) findViewById(R.id.settings_top_spinner);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SettingsItemSelectedListener(this));

		if (defaultTop != "") {

			List<String> topList = new ArrayList<String>();
			for (int i = 0; i < adapter.getCount(); i++)
				topList.add((String) adapter.getItem(i));

			spinner.setSelection(topList.indexOf(defaultTop));

		} else {
			spinner.setSelection(0);
		}
	}

	private void loadColorSpinner()
	{
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerColorsArray, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = (Spinner) findViewById(R.id.settings_color_spinner);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SettingsItemSelectedListener(this));

		if (defaultColor != "") {

			List<String> colorList = new ArrayList<String>();
			for (int i = 0; i < adapter.getCount(); i++)
				colorList.add((String) adapter.getItem(i));

			spinner.setSelection(colorList.indexOf(defaultColor));

		} else {
			spinner.setSelection(0);
		}
	}
}
