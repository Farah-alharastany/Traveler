package com.example.project12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MySQLite {
    SQLite db;
    public MySQLite(Context context)
    {
        db = new SQLite(context);
    }


    static class SQLite extends SQLiteOpenHelper
    {
        private static final String MY_DATABASE_NAME = "TRAVELS";
        private static final String MY_TABLE_NAME = "Users";

        private static final int MY_DATABASE_VRSION = 1;
        private static final String ID_COL = "id";
        private static final String NAME_COL = "name";
        private static final String USERNAME_COL = "userame";
        private static final String EMAIL_COL = "email";
        private static final String PASSWORD_COL = "password";

        private static final String TABLE_CREATION = "CREATE TABLE " + MY_TABLE_NAME +
                " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COL + " VARCHAR(255) ," + USERNAME_COL + " VARCHAR(255) ," + PASSWORD_COL + " VARCHAR(255) ," +
                EMAIL_COL + " VARCHAR(255));";
        private static final String TABLE_DROP = "DROP TABLE IF EXISTS " + MY_TABLE_NAME;


        private Context context;

        public SQLite(Context context) {
            super(context, MY_DATABASE_NAME, null, MY_DATABASE_VRSION);
            this.context=context;
        }
        //oncreate, the table will be built.
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(TABLE_CREATION);

            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context, "onUpgrade", Toast.LENGTH_SHORT).show();
                db.execSQL(TABLE_DROP);

                onCreate(db);
            }catch (Exception e) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //signup method, that will insert new user.
    public long insertNewUser(String name, String username, String password, String email )
    {
        SQLiteDatabase myDb = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLite.NAME_COL, name);
        contentValues.put(SQLite.USERNAME_COL, username);
        contentValues.put(SQLite.PASSWORD_COL, password);
        contentValues.put(SQLite.EMAIL_COL, email);
        long id = myDb.insert(SQLite.MY_TABLE_NAME, null , contentValues);
        return id;
    }
    //this method will check if the entered email alreay taken by another user.
    public Boolean validateEmail(String email) {
        SQLiteDatabase myDb = db.getWritableDatabase();
        String[] columns = {db.ID_COL};
        String selection = db.EMAIL_COL + "=?" ;
        String[] selectionargs = {email};
        Cursor cursor = myDb.query(db.MY_TABLE_NAME, columns, selection, selectionargs, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }
    //this method will check that username and password are correct.
    public Boolean validateLogin(String name, String password) {
        SQLiteDatabase myDb = db.getWritableDatabase();
        String[] columns = {db.ID_COL};
        String selection = db.USERNAME_COL + "=?" + " and " + db.PASSWORD_COL + "=?";
        String[] selectionargs = {name, password};
        Cursor cursor = myDb.query(db.MY_TABLE_NAME, columns, selection, selectionargs, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }
}
