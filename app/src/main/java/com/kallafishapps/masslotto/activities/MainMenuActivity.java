package com.kallafishapps.masslotto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kallafishapps.masslotto.R;
import com.kallafishapps.masslotto.shared.ColorSchemas;
import com.kallafishapps.masslotto.shared.Common;

public class MainMenuActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Initialize();
	}

	@Override
	public int getLayoutResourceId()
	{
		return R.layout.activity_main_menu;
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
	}

	@Override
	public void setColors()
	{
		ColorSchemas.SetActivityColorSchema(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu_main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_game:
				startActivity(new Intent(MainMenuActivity.this, NumberGeneratorActivity.class));
				return true;

			case R.id.menu_check_numbers:
				startActivity(new Intent(MainMenuActivity.this, CheckNumbersActivity.class));
				return true;

			case R.id.menu_settings:
				startActivity(new Intent(MainMenuActivity.this, SettingsActivity.class));
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}

	public void onClick(View view)
	{
		Common.playKeyPress(this);

		switch (view.getId())
		{
			case R.id.main_menu_check_numbers_button:
				openCheckNumbers();
				break;
			case R.id.main_menu_play_button:
				openGame();
				break;
			case R.id.main_menu_settings_button:
				openSettings();
				break;
		}
	}

	private void openGame()
	{
		Intent intent = new Intent(this, NumberGeneratorActivity.class);
		startActivity(intent);
	}

	private void openCheckNumbers()
	{
		Intent intent = new Intent(this, CheckNumbersActivity.class);
		startActivity(intent);
	}

	private void openSettings()
	{
		Intent intent = new Intent(this, SettingsActivity.class);
		startActivity(intent);
	}
}
