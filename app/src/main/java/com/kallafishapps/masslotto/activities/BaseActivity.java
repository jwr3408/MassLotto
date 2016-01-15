package com.kallafishapps.masslotto.activities;

import android.app.Activity;
import android.os.Bundle;

import com.kallafishapps.masslotto.interfaces.IColorPreferences;

public abstract class BaseActivity extends Activity implements IColorPreferences {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResourceId());
	}
	
	public abstract void Initialize();

	public abstract int getLayoutResourceId();

}
