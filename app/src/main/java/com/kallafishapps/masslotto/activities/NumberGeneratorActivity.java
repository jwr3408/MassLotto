package com.kallafishapps.masslotto.activities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.kallafishapps.masslotto.R;
import com.kallafishapps.masslotto.data.GameDalc;
import com.kallafishapps.masslotto.interfaces.IGamePreferences;
import com.kallafishapps.masslotto.shared.ColorPreferences;
import com.kallafishapps.masslotto.shared.ColorSchemas;
import com.kallafishapps.masslotto.shared.Common;
import com.kallafishapps.masslotto.shared.Game;
import com.kallafishapps.masslotto.shared.GamePreferences;
import com.kallafishapps.masslotto.shared.NumberGenerator;

public class NumberGeneratorActivity extends BaseActivity implements IGamePreferences {

	private Game selectedGame;
	private int index;
	private String defaultGame;
	private String defaultBottom;
	private String defaultTop;

	private List<String> numberList = new ArrayList<String>();

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
		enableButtons();
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
		defaultBottom = GamePreferences.getBottomPreference(this);
		defaultTop = GamePreferences.getTopPreference(this);
	}

	@Override
	public int getLayoutResourceId()
	{
		return R.layout.activity_number_generator;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu_number_generator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_home:
				startActivity(new Intent(NumberGeneratorActivity.this, MainMenuActivity.class));
				return true;

			case R.id.menu_check_numbers:
				startActivity(new Intent(NumberGeneratorActivity.this, CheckNumbersActivity.class));
				return true;

			case R.id.menu_settings:
				startActivity(new Intent(NumberGeneratorActivity.this, SettingsActivity.class));
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}

	public void onClick(View v)
	{
		Common.playKeyPress(this);

		if (v.getId() == R.id.game_button_back) {
			getPreviousNumbers();
		} else if (v.getId() == R.id.game_button_next) {
			getNextNumbers();
		} else if (v.getId() == R.id.game_button_generate_numbers) {
			generateNumbers();
		}

		enableButtons();
	}

	private void enableButtons()
	{
		if (this.numberList.isEmpty()) {
			enablePreviousButton(false);
			enableNextButton(false);
			return;
		}

		if (this.index == 0) {
			enablePreviousButton(false);
		} else {
			enablePreviousButton(true);
		}

		if (this.index == this.numberList.size() - 1) {
			enableNextButton(false);
		} else {
			enableNextButton(true);
		}
	}

	private void enablePreviousButton(boolean isEnabled)
	{
		Button button = (Button) findViewById(R.id.game_button_back);
		button.setEnabled(isEnabled);

		if (isEnabled)
			button.setAlpha(1);
		else
			button.setAlpha((float) 0.5);
	}

	private void enableNextButton(boolean isEnabled)
	{
		Button button = (Button) findViewById(R.id.game_button_next);
		button.setEnabled(isEnabled);

		if (isEnabled)
			button.setAlpha(1);
		else
			button.setAlpha((float) 0.5);
	}

	private void generateNumbers()
	{
		GameDalc dalc = new GameDalc(this);

		Game game = new Game();
		game = dalc.getGameDetails(selectedGame.getGame_name());

		NumberGenerator n = new NumberGenerator();
		n.setGame(game);

		n.setBottom(this.defaultBottom);
		String mainNumbers = n.getMain_numbers();

		n.setTop(this.defaultTop);
		String bonusNumber = n.getBonus_numbers();

		TextView tNumber = (TextView) findViewById(R.id.game_numbers_text);
		tNumber.setText(mainNumbers);

		TextView tBonus = (TextView) findViewById(R.id.game_bonus_text);
		tBonus.setText(bonusNumber);

		this.numberList.add(mainNumbers + "," + bonusNumber);
		this.index = this.numberList.size() - 1;
	}

	private void getNextNumbers()
	{
		TextView numberText = (TextView) findViewById(R.id.game_numbers_text);
		TextView bonusText = (TextView) findViewById(R.id.game_bonus_text);

		String selectedNumber = numberText.getText().toString().trim() + ","
						+ bonusText.getText().toString().trim();

		for (int i = 0; i < this.numberList.size(); i++) {
			if (this.numberList.get(i).equals(selectedNumber)) {
				Pattern p = Pattern.compile(",");
				if (i + 1 <= this.numberList.size() - 1) {
					String[] strSplit = p.split(this.numberList.get(i + 1));
					numberText.setText(strSplit[0]);
					bonusText.setText(strSplit[1]);
					this.index = i + 1;
				}
			}
		}
	}

	private void getPreviousNumbers()
	{
		TextView numberText = (TextView) findViewById(R.id.game_numbers_text);
		TextView bonusText = (TextView) findViewById(R.id.game_bonus_text);

		String selectedNumber = numberText.getText().toString().trim() + ","
						+ bonusText.getText().toString().trim();

		for (int i = 0; i < this.numberList.size(); i++) {
			if (this.numberList.get(i).equals(selectedNumber)) {
				Pattern p = Pattern.compile(",");
				if (i - 1 >= 0) {
					String[] strSplit = p.split(this.numberList.get(i - 1));
					numberText.setText(strSplit[0]);
					bonusText.setText(strSplit[1]);
					this.index = i - 1;
				}
			}
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
		spinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				((TextView) parent.getChildAt(0)).setTextColor(ColorPreferences.getTextColorPreference(parent.getContext()));
				String gameSelected = (String) parent.getItemAtPosition(position);
				selectedGame = new GameDalc(parent.getContext()).getGameDetails(gameSelected);

				setNames();

				TextView numberText = (TextView) findViewById(R.id.game_numbers_text);
				TextView bonusText = (TextView) findViewById(R.id.game_bonus_text);
				numberText.setText("-");
				bonusText.setText("-");

				numberList.clear();

				enableButtons();
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

	private void setNames()
	{
		if (selectedGame == null) {
			return;
		}

		String mainName = selectedGame.getSpecial_name_main();
		TextView mainLabel = (TextView) findViewById(R.id.game_numbers_label);
		if (mainName == null) {
			mainLabel.setText("Numbers");
		} else {
			mainLabel.setText(mainName);
		}

		String bonusName = selectedGame.getSpecial_name_bonus();
		TextView bonusLabel = (TextView) findViewById(R.id.game_bonus_label);
		TextView bonusText = (TextView) findViewById(R.id.game_bonus_text);
		if (bonusName == null) {
			bonusLabel.setVisibility(View.INVISIBLE);
			bonusText.setVisibility(View.INVISIBLE);
		} else {
			bonusLabel.setVisibility(View.VISIBLE);
			bonusText.setVisibility(View.VISIBLE);
			bonusLabel.setText(bonusName);
		}
	}
}
