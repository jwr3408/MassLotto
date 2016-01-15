package com.kallafishapps.masslotto.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameOpenHelper extends SQLiteOpenHelper {

	// Database Information
	private static String DB_NAME = "MassLotto.db";
	private static int DB_VERSION = 5;

	// Game Information
	public static final String TABLE_GAME = "Game";
	public static final String COLUMN_PK_GAME_ID = "game_id";
	public static final String COLUMN_GAMENAME = "game_name";
	public static final String COLUMN_MINMAIN = "min_main";
	public static final String COLUMN_MAINPICKS = "main_picks";
	public static final String COLUMN_MAXMAIN = "max_main";
	public static final String COLUMN_BONUSPICKS = "bonus_picks";
	public static final String COLUMN_MAXBONUS = "max_bonus";
	public static final String COLUMN_ALLOWDUPLICATES = "allow_duplicates";
	public static final String COLUMN_GAMEURL = "game_url";
	public static final String COLUMN_BOTTOM15MAIN = "bottom_15_main";
	public static final String COLUMN_TOP15BONUS = "top_15_bonus";
	public static final String COLUMN_SPECIAL_NAME_MAIN = "special_name_main";
	public static final String COLUMN_SPECIAL_NAME_BONUS = "special_name_bonus";
	public static final String COLUMN_DEMO_ONLY = "demo_only";
	public static final String COLUMN_UPDATE_DATE = "update_date";
	public static final String DATABASE_CREATE = "create table "
					+ TABLE_GAME + "(" + COLUMN_PK_GAME_ID
					+ " integer primary key autoincrement, "
					+ COLUMN_GAMENAME + " text not null, "
					+ COLUMN_MINMAIN + " integer not null, "
					+ COLUMN_MAINPICKS + " integer not null, "
					+ COLUMN_MAXMAIN + " integer not null, "
					+ COLUMN_BONUSPICKS + " integer null, "
					+ COLUMN_MAXBONUS + " integer null, "
					+ COLUMN_ALLOWDUPLICATES + " integer not null, "
					+ COLUMN_GAMEURL + " text not null, "
					+ COLUMN_BOTTOM15MAIN + " text null, "
					+ COLUMN_TOP15BONUS + " text null, "
					+ COLUMN_SPECIAL_NAME_MAIN + " text null, "
					+ COLUMN_SPECIAL_NAME_BONUS + " text null, "
					+ COLUMN_DEMO_ONLY + " integer not  null, "
					+ COLUMN_UPDATE_DATE + " text not null);";

	public GameOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(DATABASE_CREATE);
		initialDataInsert(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		dropAndRecreateDB(db);
	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		dropAndRecreateDB(db);
	}

	private void dropAndRecreateDB(SQLiteDatabase db)
	{
		db.execSQL("drop table if exists " + TABLE_GAME);
		onCreate(db);
	}

	public void initialDataInsert(SQLiteDatabase db)
	{
        insertMegaMillions(db);

        insertPowerball(db);

        insertLuckyForLife(db);

        insertMegaBucksDoubler(db);

        insertMassCash(db);

        insertTheNumbersGame(db);
	}

    private void insertMegaMillions(SQLiteDatabase db) {

        String gameName = "Mega Millions";
        int minMain = 1;
        int mainPicks = 5;
        int maxMain = 75;
        int bonusPicks = 1;
        int maxBonus = 15;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/megamillions.html";
        String bottom15 = "19,23,52,54,57,1,4,40,71,6,9,17,21,30,33";
        String top15 = "3,6,7,1,11,15,12,2,4,5,9,13,14,10,8";
        String specialNameMain = "";
        String specialNameBonus = "MegaBall";
        boolean isDemoOnly = false;

        insertGameRecord(db, gameName, minMain, mainPicks, maxMain, bonusPicks, maxBonus, allowDuplicates, gameUrl,
                            bottom15, top15, specialNameMain, specialNameBonus, isDemoOnly);
    }

    private void insertPowerball(SQLiteDatabase db)
    {
        String gameName = "Powerball";
        int minMain = 1;
        int mainPicks = 5;
        int maxMain = 69;
        int bonusPicks = 1;
        int maxBonus = 26;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/powerball.html";
        String bottom15 = "3,56,20,27,41,44,6,26,57,21,22,23,35,37,43";
        String top15 = "35,26,18,22,1,9,12,15,16,17,19,24,27,28,33";
        String specialNameMain = "";
        String specialNameBonus = "Powerball";
        boolean isDemoOnly = false;

        insertGameRecord(db, gameName, minMain, mainPicks, maxMain, bonusPicks, maxBonus, allowDuplicates, gameUrl,
                bottom15, top15, specialNameMain, specialNameBonus, isDemoOnly);
    }

    private void insertLuckyForLife(SQLiteDatabase db)
    {
        String gameName = "Lucky For Life";
        int minMain = 1;
        int mainPicks = 5;
        int maxMain = 43;
        int bonusPicks = 1;
        int maxBonus = 43;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/lucky-for-life.html";
        String bottom15 = "48,44,46,47,5,45,30,9,21,34,37,8,11,41,26";
        String top15 = "17,5,6,16,13,15,18,32,3,4,21,24,28,29,35";
        String specialNameMain = "";
        String specialNameBonus = "Lucky Ball";
        boolean isDemoOnly = false;

        insertGameRecord(db, gameName, minMain, mainPicks, maxMain, bonusPicks, maxBonus, allowDuplicates, gameUrl,
                bottom15, top15, specialNameMain, specialNameBonus, isDemoOnly);
    }

    private void insertMegaBucksDoubler(SQLiteDatabase db)
    {
        String gameName = "MegaBucks Doubler";
        int minMain = 1;
        int mainPicks = 5;
        int maxMain = 59;
        int bonusPicks = 1;
        int maxBonus = 35;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/megabucks-doubler.html";
        String bottom15 = "47,43,40,41,45,10,44,14,21,46,4,19,31,39,2";
        String top15 = "";
        String specialNameMain = "";
        String specialNameBonus = "";
        boolean isDemoOnly = false;

        insertGameRecord(db, gameName, minMain, mainPicks, maxMain, bonusPicks, maxBonus, allowDuplicates, gameUrl,
                bottom15, top15, specialNameMain, specialNameBonus, isDemoOnly);
    }

    private void insertMassCash(SQLiteDatabase db)
    {
        String gameName = "Mass Cash";
        int minMain = 1;
        int mainPicks = 5;
        int maxMain = 35;
        int bonusPicks = 0;
        int maxBonus = 0;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/mass-cash.html";
        String bottom15 = "20,18,13,14,28,31,15,5,7,9,3,30,32,35,34";
        String top15 = "";
        String specialNameMain = "";
        String specialNameBonus = "";
        boolean isDemoOnly = false;

        insertGameRecord(db, gameName, minMain, mainPicks, maxMain, bonusPicks, maxBonus, allowDuplicates, gameUrl,
                bottom15, top15, specialNameMain, specialNameBonus, isDemoOnly);
    }

    private void insertTheNumbersGame(SQLiteDatabase db)
    {
        String gameName = "The Numbers Game";
        int minMain = 0;
        int mainPicks = 4;
        int maxMain = 9;
        int bonusPicks = 0;
        int maxBonus = 0;
        boolean allowDuplicates = true;
        String gameUrl = "http://www.masslottery.com/games/lottery/numbers-game.html";
        String bottom15 = "";
        String top15 = "";
        String specialNameMain = "";
        String specialNameBonus = "";
        boolean isDemoOnly = true;

        insertGameRecord(db, gameName, minMain, mainPicks, maxMain, bonusPicks, maxBonus, allowDuplicates, gameUrl,
                bottom15, top15, specialNameMain, specialNameBonus, isDemoOnly);
    }

    private void insertGameRecord(SQLiteDatabase db, String gameName, int minMain, int mainPicks, int maxMain, int bonusPicks, int maxBonus,
					boolean allowDuplicates, String gameUrl, String bottom15, String top15, String specialNameMain,
					String specialNameBonus, boolean isDemoOnly)
	{
		ContentValues values = new ContentValues();
		values.put(COLUMN_GAMENAME, gameName);
		values.put(COLUMN_MINMAIN, minMain);
		values.put(COLUMN_MAINPICKS, mainPicks);
		values.put(COLUMN_MAXMAIN, maxMain);
		values.put(COLUMN_BONUSPICKS, bonusPicks);
		values.put(COLUMN_MAXBONUS, maxBonus);
		values.put(COLUMN_ALLOWDUPLICATES, allowDuplicates);
		values.put(COLUMN_GAMEURL, gameUrl);
		values.put(COLUMN_BOTTOM15MAIN, bottom15);
		values.put(COLUMN_TOP15BONUS, top15);
		values.put(COLUMN_SPECIAL_NAME_MAIN, specialNameMain);
		values.put(COLUMN_SPECIAL_NAME_BONUS, specialNameBonus);
		values.put(COLUMN_UPDATE_DATE, new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(new Date()));
		values.put(COLUMN_DEMO_ONLY, isDemoOnly);
		db.insert(TABLE_GAME, null, values);
	}

}
