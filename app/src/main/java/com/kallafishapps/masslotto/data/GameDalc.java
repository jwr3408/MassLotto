package com.kallafishapps.masslotto.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kallafishapps.masslotto.interfaces.IGameDalc;
import com.kallafishapps.masslotto.shared.Game;

public class GameDalc implements IGameDalc {

	private Context _context;

	public GameDalc(Context context) {
		_context = context;
	}

	@Override
	public List<String> getGames()
	{
		List<String> games = new ArrayList<String>();
		GameOpenHelper dbHelper = new GameOpenHelper(_context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		String sql = "Select " + GameOpenHelper.COLUMN_GAMENAME + " FROM " + GameOpenHelper.TABLE_GAME;
		Cursor cursor = db.rawQuery(sql, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			games.add(cursor.getString(0));
			cursor.moveToNext();
		}
		cursor.close();
		dbHelper.close();
		
		Collections.sort(games);

		return games;
	}

	@Override
	public Game getGameDetails(String game)
	{
		Game detail = new Game();
		GameOpenHelper dbHelper = new GameOpenHelper(_context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT " + GameOpenHelper.COLUMN_PK_GAME_ID + ", " + GameOpenHelper.COLUMN_GAMENAME + ", ");
		sql.append(GameOpenHelper.COLUMN_MAINPICKS + ", " + GameOpenHelper.COLUMN_MAXMAIN + ", ");
		sql.append(GameOpenHelper.COLUMN_ALLOWDUPLICATES + ", " + GameOpenHelper.COLUMN_BONUSPICKS + ", ");
		sql.append(GameOpenHelper.COLUMN_MAXBONUS + ", " + GameOpenHelper.COLUMN_GAMEURL + ", ");
		sql.append(GameOpenHelper.COLUMN_SPECIAL_NAME_MAIN + ", " + GameOpenHelper.COLUMN_SPECIAL_NAME_BONUS + ", ");
		sql.append(GameOpenHelper.COLUMN_BOTTOM15MAIN + ", " + GameOpenHelper.COLUMN_TOP15BONUS + ", ");
		sql.append(GameOpenHelper.COLUMN_MINMAIN + ", " + GameOpenHelper.COLUMN_UPDATE_DATE);
		sql.append(" FROM " + GameOpenHelper.TABLE_GAME);
		sql.append(" WHERE " + GameOpenHelper.COLUMN_GAMENAME + " = ?");
		sql.append(" ORDER BY " + GameOpenHelper.COLUMN_GAMENAME);

		String[] selectionArgs = { game };

		Cursor cursor = db.rawQuery(sql.toString(), selectionArgs);
		cursor.moveToLast();
		detail = cursorToGame(cursor);

		cursor.close();
		dbHelper.close();

		return detail;
	}

	private Game cursorToGame(Cursor cursor)
	{
		Game game = new Game();

		game.setGame_id(cursor.getLong(0));
		game.setGame_name(cursor.getString(1));
		game.setMain_picks(cursor.getInt(2));
		game.setMax_main(cursor.getInt(3));
		game.setAllow_duplicates(cursor.getInt(4) == 1 ? true : false);

		if (cursor.getString(5).length() > 0) {
			game.setbonus_picks(cursor.getInt(5));
		}

		if (cursor.getString(6).length() > 0) {
			game.setMax_bonus(cursor.getInt(6));
		}

		if (cursor.getString(7).length() > 0) {
			String url = cursor.getString(7);
			game.setGame_URL(url);
		}

		if (cursor.getString(8).length() > 0) {
			game.setSpecial_name_main(cursor.getString(8));
		}

		if (cursor.getString(9).length() > 0) {
			game.setSpecial_name_bonus(cursor.getString(9));
		}

		if (cursor.getString(10).length() > 0) {

			String[] split15 = cursor.getString(10).split(",");

			// Bottom 5
			for (int i = 0; i < 15; i++) {
				split15[i] = split15[i].trim();
			}
			game.setBottom_15_main(split15);

			// Bottom 10
			String[] split10 = new String[10];
			for (int i = 0; i < 10; i++) {
				split10[i] = split15[i].trim();
			}
			game.setBottom_10_main(split10);

			// Bottom 15
			String[] split5 = new String[5];
			for (int i = 0; i < 5; i++) {
				split5[i] = split10[i].trim();
			}
			game.setBottom_5_main(split5);
		}

		if (cursor.getString(11).length() > 0) {

			String[] split15 = cursor.getString(11).split(",");

			// Top 5 Bonus
			for (int i = 0; i < 15; i++) {
				split15[i] = split15[i].trim();
			}
			game.setTop_15_bonus(split15);

			// Top 10 Bonus
			String[] split10 = new String[10];
			for (int i = 0; i < 10; i++) {
				split10[i] = split15[i].trim();
			}
			game.setTop_10_bonus(split10);

			// Top 15 Bonus
			String[] split5 = new String[5];
			for (int i = 0; i < 5; i++) {
				split5[i] = split10[i].trim();
			}
			game.setTop_5_bonus(split5);

		}
		
		game.setMin_main(cursor.getInt(12));		
		game.setUpdate_Date(cursor.getString(13));		

		return game;
	}
}
