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
	private static int DB_VERSION = 6;

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
        String bottom15 = "34,43,13,46,60,1,3,4,16,28,37,67,75,10,23";
        String top15 = "15,4,7,9,3,8,12,13,14,1,2,5,10,6,11";
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
        String bottom15 = "60,61,65,66,67,63,64,69,3,37,59,62,68,5,23";
        String top15 = "7,17,22,1,10,15,11,12,18,19,25,33,2,5,6";
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
        int maxMain = 48;
        int bonusPicks = 1;
        int maxBonus = 18;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/lucky-for-life.html";
        String bottom15 = "34,11,13,35,5,6,15,27,30,41,3,9,10,14,20";
        String top15 = "5,6,18,12,17,4,13,15,7,10,14,16,2,3,9";
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
        int mainPicks = 6;
        int maxMain = 49;
        int bonusPicks = 0;
        int maxBonus = 0;
        boolean allowDuplicates = false;
        String gameUrl = "http://www.masslottery.com/games/lottery/megabucks-doubler.html";
        String bottom15 = "45,43,10,40,42,46,22,38,47,1,44,23,32,33,37";
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
        String bottom15 = "1,20,6,14,27,32,15,10,12,24,30,34,16,18,9";
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
