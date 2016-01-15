package com.kallafishapps.masslotto.shared;

import java.util.Date;

public class Game {

	private Long game_id;
	private String game_name;
	private int min_main;
	private int main_picks;
	private int max_main;
	private int bonus_picks;
	private int max_bonus;
	private boolean allow_duplicates;
	private String[] bottom_5_main;
	private String[] bottom_10_main;
	private String[] bottom_15_main;
	private String[] top_5_bonus;
	private String[] top_10_bonus;
	private String[] top_15_bonus;
	private String special_name_main;
	private String special_name_bonus;
	private String game_URL;
	private String update_date;

	public Long getGame_id()
	{
		return game_id;
	}

	public void setGame_id(Long game_id)
	{
		this.game_id = game_id;
	}

	public String getGame_name()
	{
		return game_name;
	}

	public void setGame_name(String game_name)
	{
		this.game_name = game_name;
	}

	public int getMin_main()
	{
		return min_main;
	}

	public void setMin_main(int min_main)
	{
		this.min_main = min_main;
	}

	public int getMax_main()
	{
		return max_main;
	}

	public void setMax_main(int max_main)
	{
		this.max_main = max_main;
	}

	public int getMain_picks()
	{
		return main_picks;
	}

	public void setMain_picks(int main_picks)
	{
		this.main_picks = main_picks;
	}

	public int getMax_bonus()
	{
		return max_bonus;
	}

	public void setMax_bonus(int max_bonus)
	{
		this.max_bonus = max_bonus;
	}

	public int getbonus_picks()
	{
		return bonus_picks;
	}

	public void setbonus_picks(int bonus_picks)
	{
		this.bonus_picks = bonus_picks;
	}

	public boolean isAllow_duplicates()
	{
		return allow_duplicates;
	}

	public void setAllow_duplicates(boolean allow_duplicates)
	{
		this.allow_duplicates = allow_duplicates;
	}

	public String[] getBottom_5_main()
	{
		return bottom_5_main;
	}

	public void setBottom_5_main(String[] bottom_5_main)
	{
		this.bottom_5_main = bottom_5_main;
	}

	public String[] getBottom_10_main()
	{
		return bottom_10_main;
	}

	public void setBottom_10_main(String[] bottom_10_main)
	{
		this.bottom_10_main = bottom_10_main;
	}

	public String[] getBottom_15_main()
	{
		return bottom_15_main;
	}

	public void setBottom_15_main(String[] bottom_15_main)
	{
		this.bottom_15_main = bottom_15_main;
	}

	public String[] getTop_5_bonus()
	{
		return top_5_bonus;
	}

	public void setTop_5_bonus(String[] top_5_bonus)
	{
		this.top_5_bonus = top_5_bonus;
	}

	public String[] getTop_10_bonus()
	{
		return top_10_bonus;
	}

	public void setTop_10_bonus(String[] top_10_bonus)
	{
		this.top_10_bonus = top_10_bonus;
	}

	public String[] getTop_15_bonus()
	{
		return top_15_bonus;
	}

	public void setTop_15_bonus(String[] top_15_bonus)
	{
		this.top_15_bonus = top_15_bonus;
	}

	public String getGame_URL()
	{
		return game_URL;
	}

	public void setGame_URL(String game_URL)
	{
		this.game_URL = game_URL;
	}

	public String getSpecial_name_main()
	{
		return special_name_main;
	}

	public void setSpecial_name_main(String special_name_main)
	{
		this.special_name_main = special_name_main;
	}

	public String getSpecial_name_bonus()
	{
		return special_name_bonus;
	}

	public void setSpecial_name_bonus(String special_name_bonus)
	{
		this.special_name_bonus = special_name_bonus;
	}

	public String getUpdate_Date()
	{
		return update_date;
	}

	public void setUpdate_Date(String modDate)
	{
		Date date = Converters.ConvertStringToDate(modDate, "yyyy/MM/dd");
		this.update_date = Converters.ConvertDateToString(date);
	}
}
