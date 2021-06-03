package sg.edu.rp.c346.id19045784.mydatabook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collection;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "drinks.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Data";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BIO = "bio";
    private static final String COLUMN_VACCINE = "vaccine";
    private static final String COLUMN_ANNI = "anni";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createDrinkTableSql = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_BIO
                + " TEXT, " + COLUMN_VACCINE + " TEXT, " + COLUMN_ANNI + " TEXT ) ";
        db.execSQL(createDrinkTableSql);
//        Log.i("info", "created tables");

//        //create some dummy data in DB table for testing
//        Data[] datas = {new Data("Blood A+ \n Height 170cm", "First dose", "12/07/2021"),
//                new Data("Blood A+ \n Height 170cm", "First dose", "12/07/2021"),
//                new Data("Blood A+ \n Height 170cm", "First dose", "12/07/2021"),
//                new Data("Blood A+ \n Height 170cm", "First dose", "12/07/2021"),
//                new Data("Blood A+ \n Height 170cm", "First dose", "12/07/2021")};
//
//        for (int i=0; i<datas.length; i++) {
//            insertItem(db, datas[i].getBio(), datas[i].getVaccination(), datas[i].getAnniversary());
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertItem(SQLiteDatabase db, String bio, String vaccine, String anni) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_BIO, bio);
        values.put(COLUMN_VACCINE, vaccine);
        values.put(COLUMN_ANNI, anni);
        db.insert(TABLE_NAME, null, values);
    }

    public boolean insertAnniversary(SQLiteDatabase db, String anni) {
        //Get writable Database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Create ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ANNI, anni);
        //Add Values into database
        long result1 = sqLiteDatabase.insert(TABLE_NAME, null,contentValues);
        return result1 != -1;
    }

    public ArrayList<String> getBio() {
        ArrayList<String> bios = new ArrayList<String>();
        String selectQuery = "SELECT " + COLUMN_BIO + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_BIO, COLUMN_VACCINE, COLUMN_ANNI};
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
//                int id = cursor.getInt(0);
                String name = cursor.getString(0);
//                String drinkCategory = cursor.getString(2);
//                Drink drink = new Drink(id, name, drinkCategory);
                bios.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return bios;
    }

    public ArrayList<String> getVaccine() {
        ArrayList<String> bios = new ArrayList<String>();
        String selectQuery = "SELECT " + COLUMN_VACCINE + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ID, COLUMN_BIO, COLUMN_VACCINE, COLUMN_ANNI};
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
//                int id = cursor.getInt(0);
                String name = cursor.getString(0);
//                String drinkCategory = cursor.getString(2);
//                Drink drink = new Drink(id, name, drinkCategory);
                bios.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return bios;
    }

    ArrayList<Data> getAllAnni(String anni) {
        ArrayList<Data> annis = new ArrayList<Data>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns= {COLUMN_ANNI};
        String condition = COLUMN_ANNI + " Like ?";
        String[] args = { "%" +  anni + "%"};
        Cursor cursor = db.query(TABLE_NAME, columns, condition, args,
                null, null, null, null);
//        String selectQuery = "SELECT " + COLUMN_ANNI + " FROM " + TABLE_NAME;

//        String[] columns= {COLUMN_ID, COLUMN_BIO, COLUMN_VACCINE, COLUMN_ANNI};
//        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
//                int id = cursor.getInt(0);
                String anni2 = cursor.getString(0);
                Data data = new Data (anni2);
//                String drinkCategory = cursor.getString(2);
//                Drink drink = new Drink(id, name, drinkCategory);
                annis.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return annis;
    }

}



