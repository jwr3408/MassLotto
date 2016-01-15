package com.kallafishapps.masslotto.shared;

import java.util.ArrayList;
import java.util.List;

public class Notifications {

	private Game game;

	public void setGame(Game game)
	{
		this.game = game;
	}

	public String DisplayBottom(String bottom)
	{
		if (bottom.contains("15")) {
			return FormatBottom(15);
		} else if (bottom.contains("10")) {
			return FormatBottom(10);
		} else if (bottom.contains("5")) {
			return FormatBottom(5);
		} else {
			return "Not Available";
		}
	}

	private String FormatBottom(int number)
	{
		StringBuilder sbBottom = new StringBuilder();
		switch (number) {
			case 5:
				List<Integer> five = new ArrayList<Integer>();
				if (game.getBottom_5_main() == null) {
					return "Not Available";
				}

				for (String s : game.getBottom_5_main()) {
					five.add(Integer.parseInt(s));
				}

				for (int i = 0; i < 5; i++) {
					sbBottom.append(five.get(i) + ", ");
				}
				sbBottom.deleteCharAt(sbBottom.length() - 2);
				break;

			case 10:
				List<Integer> ten = new ArrayList<Integer>();
				if (game.getBottom_10_main() == null) {
					return "Not Available";
				}

				for (String s : game.getBottom_10_main()) {
					ten.add(Integer.parseInt(s));
				}

				for (int i = 0; i < 5; i++) {
					sbBottom.append(ten.get(i) + ", ");
				}
				sbBottom.append("\n");

				for (int i = 5; i < 10; i++) {
					sbBottom.append(ten.get(i) + ", ");
				}
				sbBottom.deleteCharAt(sbBottom.length() - 2);
				break;

			case 15:
				List<Integer> fifteen = new ArrayList<Integer>();
				if (game.getBottom_15_main() == null) {
					return "Not Available";
				}

				for (String s : game.getBottom_15_main()) {
					fifteen.add(Integer.parseInt(s));
				}

				for (int i = 0; i < 5; i++) {
					sbBottom.append(fifteen.get(i) + ", ");
				}
				sbBottom.append("\n");

				for (int i = 5; i < 10; i++) {
					sbBottom.append(fifteen.get(i) + ", ");
				}
				sbBottom.append("\n");

				for (int i = 10; i < 15; i++) {
					sbBottom.append(fifteen.get(i) + ", ");
				}
				sbBottom.deleteCharAt(sbBottom.length() - 2);
				break;
		}

		sbBottom.append("\n" + "as of " + game.getUpdate_Date());
		return sbBottom.toString().trim();
	}

	public String DisplayTop(String top)
	{
		if (top.contains("15")) {
			return FormatTop(15);
		} else if (top.contains("10")) {
			return FormatTop(10);
		} else if (top.contains("5")) {
			return FormatTop(5);
		} else {
			return "Not Available";
		}
	}

	private String FormatTop(int number)
	{
		StringBuilder sbTop = new StringBuilder();
		switch (number) {
			case 5:
				List<Integer> five = new ArrayList<Integer>();
				if (game.getTop_5_bonus() == null) {
					return "Not Available";
				}
				for (String s : game.getTop_5_bonus()) {
					five.add(Integer.parseInt(s));
				}
				for (int i = 0; i < 5; i++) {
					sbTop.append(five.get(i) + ", ");
				}
				sbTop.deleteCharAt(sbTop.length() - 2);
				break;

			case 10:
				List<Integer> ten = new ArrayList<Integer>();
				if (game.getTop_10_bonus() == null) {
					return "Not Available";
				}
				for (String s : game.getTop_10_bonus()) {
					ten.add(Integer.parseInt(s));
				}
				for (int i = 0; i < 5; i++) {
					sbTop.append(ten.get(i) + ", ");
				}
				sbTop.append("\n");

				for (int i = 5; i < 10; i++) {
					sbTop.append(ten.get(i) + ", ");
				}
				sbTop.deleteCharAt(sbTop.length() - 2);
				break;

			case 15:
				List<Integer> fifteen = new ArrayList<Integer>();
				if (game.getTop_15_bonus() == null) {
					return "Not Available";
				}
				for (String s : game.getTop_15_bonus()) {
					fifteen.add(Integer.parseInt(s));
				}
				for (int i = 0; i < 5; i++) {
					sbTop.append(fifteen.get(i) + ", ");
				}
				sbTop.append("\n");

				for (int i = 5; i < 10; i++) {
					sbTop.append(fifteen.get(i) + ", ");
				}
				sbTop.append("\n");

				for (int i = 10; i < 15; i++) {
					sbTop.append(fifteen.get(i) + ", ");
				}
				sbTop.deleteCharAt(sbTop.length() - 2);
				break;
		}

		sbTop.append("\n" + "as of " + game.getUpdate_Date());
		return sbTop.toString().trim();
	}
}
