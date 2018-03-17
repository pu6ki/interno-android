package hacktues.interno.com.interno;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by july on 17.03.18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tokens.db";
    private static final String TABLE_NAME = "tokens";
    private static final String COLUMN_TOKEN = "token";
    SQLiteDatabase sqLiteDatabase;

    private static final String TABLE_CREATE = "create table tokens (token text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }

    public void insertToken(String token){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COLUMN_TOKEN, token);
        sqLiteDatabase.insert(TABLE_NAME, null, content);
    }
}
