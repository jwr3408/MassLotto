package com.kallafishapps.masslotto.shared;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

	private String main_numbers;
	private String bonus_numbers;
	private Game game;
	private String bottom;
	private String top;

	private void generateMainNumbers()
	{
		StringBuilder selectedNumbers = new StringBuilder();
		getMainNumbers(selectedNumbers);
		this.setMain_numbers(selectedNumbers.toString());
	}

	private void generateBonusNumbers()
	{
		StringBuilder selectedNumbers = new StringBuilder();
		getBonusNumbers(selectedNumbers);
		this.setBonus_numbers(selectedNumbers.toString());
	}

	private void getMainNumbers(StringBuilder selectedNumbers)
	{
		List<Integer> NumbersList = new ArrayList<Integer>();

		NumbersList = createNumbersList();

		for (int i : NumbersList) {
			String strNumber = Integer.toString(i) + " ";
			selectedNumbers.append(strNumber);
		}
	}

	private List<Integer> createNumbersList()
	{
		int min_main = game.getMin_main();
		int max_main = game.getMax_main();
		int main_picks = game.getMain_picks();
		boolean allow_duplicates = game.isAllow_duplicates();
		
		int range = max_main + 1;
		
		SecureRandom r = new SecureRandom();
		r.nextInt(range);		

		List<Integer> listBottomDrawn = getBottomDrawn();
		List<Integer> numbersList = new ArrayList<Integer>();

		do {
			int randomNumber = 0;
			randomNumber = r.nextInt(range);

			if (randomNumber >= min_main && randomNumber <= max_main) {
				if (allow_duplicates) {

					if (listBottomDrawn == null) {
						numbersList.add(randomNumber);
					} else {
						if (!listBottomDrawn.contains(randomNumber)) {
							numbersList.add(randomNumber);
						}
					}

				} else {
					if (listBottomDrawn == null) {
						if (!numbersList.contains(randomNumber)) {
							numbersList.add(randomNumber);
						}

					} else {
						if (!numbersList.contains(randomNumber) && !listBottomDrawn.contains(randomNumber)) {
							numbersList.add(randomNumber);
						}
					}
				}

			}
		}
		while (numbersList.size() != main_picks);

		if (!allow_duplicates) {
			Collections.sort(numbersList);
		}

		return numbersList;

	}

	private List<Integer> getBottomDrawn()
	{
		if (game.getBottom_15_main() == null) {
			return null;
		}

		List<Integer> bottomDrawn = new ArrayList<Integer>();

		if (bottom == null || bottom.isEmpty() || bottom.equalsIgnoreCase("all")) {
			return null;
		} else if (bottom.equalsIgnoreCase("Bottom 5")) {
			String[] bottom5 = game.getBottom_5_main();
			for (String i : bottom5) {
				bottomDrawn.add(Integer.parseInt(i));
			}
		} else if (bottom.equalsIgnoreCase("Bottom 10")) {
			String[] bottom10 = game.getBottom_10_main();
			for (String i : bottom10) {
				bottomDrawn.add(Integer.parseInt(i));
			}
		} else if (bottom.equalsIgnoreCase("Bottom 15")) {
			String[] bottom15 = game.getBottom_15_main();
			for (String i : bottom15) {
				bottomDrawn.add(Integer.parseInt(i));
			}
		}
		return bottomDrawn;
	}

	private void getBonusNumbers(StringBuilder selectedNumbers)
	{
		int min_bonus = 1;
		int max_bonus = game.getMax_bonus();
		int bonus_picks = game.getbonus_picks();
		
		int range = max_bonus + 1;		
		
		SecureRandom r = new SecureRandom();
		r.nextInt(range);

		if (max_bonus == 0) {
			selectedNumbers.append("N/A");
			return;
		}

		List<Integer> listTopDrawn = getTopDrawn(game);
		List<Integer> NumbersList = new ArrayList<Integer>();

		do {
			Integer randomNumber = 0;
			randomNumber = r.nextInt(range);

			if (randomNumber >= min_bonus && randomNumber <= max_bonus) {

				if (listTopDrawn == null) {
					if (!NumbersList.contains(randomNumber)) {
						NumbersList.add(randomNumber);
					}
				} else if (listTopDrawn.contains(randomNumber)) {
					if (!NumbersList.contains(randomNumber)) {
						NumbersList.add(randomNumber);
					}
				}
			}
		}
		while (NumbersList.size() != bonus_picks);

		Collections.sort(NumbersList);

		for (int i : NumbersList) {
			String strNumber = Integer.toString(i) + " ";
			selectedNumbers.append(strNumber);
		}

		return;
	}

	private List<Integer> getTopDrawn(Game game)
	{
		if (game.getTop_15_bonus() == null) {
			return null;
		}

		List<Integer> topDrawn = new ArrayList<Integer>();

		if (top == null || top.isEmpty() || top.equalsIgnoreCase("all")) {
			return null;
		} else if (top.equalsIgnoreCase("Top 5")) {
			String[] bottom5 = game.getTop_5_bonus();
			for (String i : bottom5) {
				topDrawn.add(Integer.parseInt(i));
			}
		} else if (top.equalsIgnoreCase("Top 10")) {
			String[] bottom10 = game.getTop_10_bonus();
			for (String i : bottom10) {
				topDrawn.add(Integer.parseInt(i));
			}
		} else if (top.equalsIgnoreCase("Top 15")) {
			String[] bottom15 = game.getTop_15_bonus();
			for (String i : bottom15) {
				topDrawn.add(Integer.parseInt(i));
			}
		}

		return topDrawn;
	}

	public String getMain_numbers()
	{
		generateMainNumbers();
		return main_numbers;
	}

	public void setMain_numbers(String main_numbers)
	{
		this.main_numbers = main_numbers.trim();
	}

	public String getBonus_numbers()
	{
		generateBonusNumbers();
		return bonus_numbers;
	}

	public void setBonus_numbers(String bonus_numbers)
	{
		this.bonus_numbers = bonus_numbers.trim();
	}

	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}

	public String getBottom()
	{
		return bottom;
	}

	public void setBottom(String bottom)
	{
		this.bottom = bottom;
	}

	public String getTop()
	{
		return top;
	}

	public void setTop(String top)
	{
		this.top = top;
	}
}
