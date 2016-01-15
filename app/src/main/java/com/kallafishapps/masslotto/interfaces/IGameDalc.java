package com.kallafishapps.masslotto.interfaces;

import java.util.List;

import com.kallafishapps.masslotto.shared.Game;

public interface IGameDalc {

	List<String> getGames();

	Game getGameDetails(String game);
}
