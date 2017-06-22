package com.rdx64.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR = 0;
    public static final int BOOK_ITEM = 1;
    public static final int CATEGORY_DIR = 2;
    public static final int CATEGORY_ITEM = 3;
    public static final String AUTHORITY = "com.rdx64.databasetest.provider";

    private static UriMatcher uriMatcher;
    private MyDatabaseHelper databaseHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "book", BOOK_DIR);
        uriMatcher.addURI(AUTHORITY, "book/#", BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY, "category", CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY, "category/#", CATEGORY_ITEM);
    }

    public DatabaseProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int result = 0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                result = db.delete("Book", selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                result = db.delete("Book", "id = ?", new String[]{bookId});
                break;
            case CATEGORY_DIR:
                result = db.delete("Category", selection, selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                result = db.delete("Category", "id = ?", new String[]{categoryId});
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public String getType(Uri uri) {
        String result = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                result = "vnd.android.cursor.dir/vnd.com.rdx64.databasetest.provider.book";
                break;
            case BOOK_ITEM:
                result = "vnd.android.cursor.item/vnd.com.rdx64.databasetest.provider.book";
                break;
            case CATEGORY_DIR:
                result = "vnd.android.cursor.dir/vnd.com.rdx64.databasetest.provider.category";
                break;
            case CATEGORY_ITEM:
                result = "vnd.android.cursor.item/vnd.com.rdx64.databasetest.provider.category";
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Uri uriResult = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
            case BOOK_ITEM:
                long bookId = db.insert("Book", null, values);
                uriResult = Uri.parse("content://" + AUTHORITY + "/Book/" + bookId);
                break;
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                long categoryId = db.insert("Category", null, values);
                uriResult = Uri.parse("content://" + AUTHORITY + "/Category/" + categoryId);
                break;
            default:
                break;
        }
        return uriResult;
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new MyDatabaseHelper(getContext(), "BookStore.db", null, 2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                cursor = db.query("Book", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                cursor = db.query("Book", projection, "id = ?", new String[]{bookId}, null, null, sortOrder);
                break;
            case CATEGORY_DIR:
                cursor = db.query("Category", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CATEGORY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                cursor = db.query("Category", projection, "id = ?", new String[]{categoryId}, null, null, sortOrder);
                break;
            default:
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int result = 0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                result = db.update("Book", values, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                result = db.update("Book", values, "id = ?", new String[]{bookId});
                break;
            case CATEGORY_DIR:
                result = db.update("Category", values, selection, selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                result = db.update("Category", values, "id = ?", new String[]{categoryId});
                break;
            default:
                break;
        }
        return result;
    }
}
