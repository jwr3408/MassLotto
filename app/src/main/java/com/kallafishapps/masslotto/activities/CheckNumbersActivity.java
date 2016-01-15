package com.kallafishapps.masslotto.activities;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.kallafishapps.masslotto.R;
import com.kallafishapps.masslotto.data.GameDalc;
import com.kallafishapps.masslotto.interfaces.IGamePreferences;
import com.kallafishapps.masslotto.shared.ColorPreferences;
import com.kallafishapps.masslotto.shared.ColorSchemas;
import com.kallafishapps.masslotto.shared.Game;
import com.kallafishapps.masslotto.shared.GamePreferences;

public class CheckNumbersActivity extends BaseActivity implements IGamePreferences {

	private String defaultGame;
	private Game selectedGame;

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
	}

	@Override
	public int getLayoutResourceId()
	{
		return R.layout.activity_check_numbers;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu_check_numbers, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_home:
				startActivity(new Intent(CheckNumbersActivity.this, MainMenuActivity.class));
				return true;

			case R.id.menu_game:
				startActivity(new Intent(CheckNumbersActivity.this, NumberGeneratorActivity.class));
				return true;

			case R.id.menu_settings:
				startActivity(new Intent(CheckNumbersActivity.this, SettingsActivity.class));
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void setColors()
	{
		ColorSchemas.SetActivityColorSchema(this, this);
	}

	@Override
	public void setPreferences()
	{
		defaultGame = GamePreferences.getDefaultGamePreference(this);
	}

	private void loadGameSpinner()
	{
		GameDalc dalc = new GameDalc(this);

		List<String> games = dalc.getGames();
		Spinner spinner = (Spinner) findViewById(R.id.spinner_games);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, games);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				((TextView) parent.getChildAt(0)).setTextColor(ColorPreferences.getTextColorPreference(parent.getContext()));
				String gameSelected = (String) parent.getItemAtPosition(position);
				selectedGame = new GameDalc(parent.getContext()).getGameDetails(gameSelected);

				TextView urlText = (TextView) findViewById(R.id.check_numbers_url);
				String url = selectedGame.getGame_URL();
				if (url == null)
					urlText.setText("N/A");
				else
				{
					urlText.setMovementMethod(LinkMovementMethod.getInstance());
					String htmlText = String.format("<a href=\"%1$s\">%2$s</a>", url, gameSelected);
					urlText.setText(Html.fromHtml(htmlText));
					urlText.setLinkTextColor(ColorPreferences.getTextColorPreference(parent.getContext()));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
				// do nothing
			}

		});

		if (!this.defaultGame.equals(""))
		{
			selectedGame = dalc.getGameDetails(this.defaultGame);
			spinner.setSelection(games.indexOf(this.defaultGame));
		}
		else
		{
			selectedGame = dalc.getGameDetails(spinner.getItemAtPosition(0).toString());
			spinner.setSelection(0);
		}
	}
}
