package com.example.signuplogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class DBOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "signupsignin";
    public static final String TABLE_NAME = "usersdb";
    public static final String KEY_EMAIL= "email";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_IS_LOGIN = "is_login";
    public static final String KEY_PASSWORD = "password";
    private Context context;


    public DBOpenHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+
                TABLE_NAME +" ( "+
                KEY_EMAIL +" TEXT PRIMARY KEY, "+
                KEY_USER_NAME +" TEXT, "+
                KEY_PASSWORD +" TEXT, "+
                KEY_IS_LOGIN +" TEXT );";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL,user.getUserEmail());
        values.put(KEY_USER_NAME,user.getUserName());
        values.put(KEY_PASSWORD,user.getUserPassword());
        values.put(KEY_IS_LOGIN,user.getIsSignin());
        db.insertOrThrow(TABLE_NAME,null,values);
        db.close();
    }
    public User signInUser(User user){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+KEY_EMAIL+
                ", "+KEY_USER_NAME+
                " FROM "+TABLE_NAME+
                " WHERE "+KEY_EMAIL+
                "="+user.getUserEmail()+
                " AND "+KEY_PASSWORD+
                "="+user.getUserPassword()+
                " ;";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor != null){
            cursor.moveToFirst();
            user= new User(cursor.getString(0),
                    cursor.getString(1),null,cursor.getString(3));
        }
        db.close();
        return user;
    }
}
