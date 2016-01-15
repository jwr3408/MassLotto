package com.kallafishapps.masslotto.shared;

import java.util.Arrays;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import android.widget.TextView;

import com.kallafishapps.masslotto.R;

public final class Common {

	public static void playKeyPress(Context c)
	{
		AudioManager am = (AudioManager) c.getSystemService(Context.AUDIO_SERVICE);
		am.playSoundEffect(AudioManager.FX_KEY_CLICK, (float) 0.25);
	}

	public static boolean isLite(Context c)
	{
		return c.getApplicationInfo().packageName.toLowerCase(Locale.US).contains("lite");
	}

	public static void setDisplayBottomTextView(String defaultBottom, Activity activity, Game selectedGame)
	{
		TextView bottomText = (TextView) activity.findViewById(R.id.settings_display_bottom_textview);
		bottomText.setVisibility(View.VISIBLE);

		switch (defaultBottom)
		{
			case "All":
				bottomText.setVisibility(View.INVISIBLE);
				break;
			case "Bottom 5":
				String[] bottom5 = selectedGame.getBottom_5_main();
				if (bottom5 != null)
					bottomText.setText(Arrays.toString(bottom5));
				else
					bottomText.setText("N/A");
				break;
			case "Bottom 10":
				String[] bottom10 = selectedGame.getBottom_10_main();
				if (bottom10 != null)
					bottomText.setText(Arrays.toString(bottom10));
				else
					bottomText.setText("N/A");
				break;
			case "Bottom 15":
				String[] bottom15 = selectedGame.getBottom_15_main();
				if (bottom15 != null)
					bottomText.setText(Arrays.toString(bottom15));
				else
					bottomText.setText("N/A");
				break;
		}
	}

	public static void setDisplayTopTextView(String defaultTop, Activity activity, Game selectedGame)
	{
		TextView topText = (TextView) activity.findViewById(R.id.settings_display_top_textview);
		topText.setVisibility(View.VISIBLE);

		switch (defaultTop)
		{
			case "All":
				topText.setVisibility(View.INVISIBLE);
				break;
			case "Top 5":
				String[] top5 = selectedGame.getTop_5_bonus();
				if (top5 != null)
					topText.setText(Arrays.toString(top5));
				else
					topText.setText("N/A");
				break;
			case "Top 10":
				String[] top10 = selectedGame.getTop_10_bonus();
				if (top10 != null)
					topText.setText(Arrays.toString(top10));
				else
					topText.setText("N/A");
				break;
			case "Top 15":
				String[] top15 = selectedGame.getTop_15_bonus();
				if (top15 != null)
					topText.setText(Arrays.toString(top15));
				else
					topText.setText("N/A");
				break;
		}
	}
}
