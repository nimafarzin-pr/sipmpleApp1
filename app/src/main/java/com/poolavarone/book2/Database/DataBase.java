package com.poolavarone.book2.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.poolavarone.book2.Model.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    private Context context;

    public DataBase(Context context) {
        super(context, info_db.DATABASE_NAME, null, info_db.DATABASE_VERSION);
        this.context = context;
        isDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void isDatabase() {
        File check = new File(info_db.PACKAGE);

        if (check.exists()) {

        } else {
            check.mkdir();
        }
        check = context.getDatabasePath(info_db.DATABASE_NAME);

        if (check.exists()) {

        } else {
            try {
                copyDataBase();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(info_db.DATABASE_SOURCE);

        String outFileName = info_db.PACKAGE + info_db.DATABASE_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public List<Person> getAllperson() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "select * from daro_tbl";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Person> getDaro() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "select * from daro_tbl where menu  = 'دارو'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Person> getDamnosh() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "select * from daro_tbl where menu = 'دمنوش'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Person> getmive() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "select * from daro_tbl where menu = 'میوه'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Person> getTebb() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "select * from daro_tbl  where menu = 'طب سنتی'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Person> getFavDaro() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> data = new ArrayList<>();
        String query = "select * from daro_tbl where fav = 1";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                person.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                person.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                person.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                person.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                person.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                data.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public int fav_value(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select " + info_db.DATA_FAV + " from daro_tbl where " + info_db.DATA_ID + "=" + id + "";
        int value = 0;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            value = cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV));
            do {

            } while (cursor.moveToNext());
        }
        db.close();
        return value;

    }

    public void fav(int status, int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "update daro_tbl set " + info_db.DATA_FAV + "=" + status + " where " + info_db.DATA_ID + "=" + id + "";
        db.execSQL(query);
        db.close();
    }
}
