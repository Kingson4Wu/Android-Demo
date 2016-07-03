package com.kxw.sqlite.provider;

import com.kxw.sqlite.dao.DBOpenHelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class StudentContentProvider extends ContentProvider
{

	private DBOpenHelper dbOpenHelper;
	private static final UriMatcher sMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int STUDENTS = 1;
	private static final String AUTHORITY = "com.kxw.privider.studentprovider";
	// ���ֶ���URI�ķ������Ǻܺ����ˣ���Ϊѧϰ����
	private static final int STUDENT = 2;

	static
	{
		// uri="content://com.kxw.privider.studentprovider/student"
		sMatcher.addURI(AUTHORITY, "student", STUDENTS);
		// uri="content://com.kxw.privider.studentprovider/student/#"
		sMatcher.addURI(AUTHORITY, "student/#", STUDENT);

	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int count = 0;

		switch (sMatcher.match(uri))
		{
		// uri="content://com.kxw.privider.studentprovider/person"
		case STUDENTS:
			count = db.delete("t_student", selection, selectionArgs);
			break;

		// uri="content://com.kxw.privider.studentprovider/person/#"
		case STUDENT:
			long sid = ContentUris.parseId(uri);
			String where = TextUtils.isEmpty(selection) ? "sid=?" : selection + " and sid=?";
			String[] params = new String[]
			{ String.valueOf(sid) };
			if (!TextUtils.isEmpty(selection) && selectionArgs != null)
			{
				params = new String[selectionArgs.length + 1];
				for (int i = 0; i < selectionArgs.length; i++)
				{
					params[i] = selectionArgs[i];

				}
				params[selectionArgs.length] = String.valueOf(sid);

			}
			count = db.delete("t_student", where, params);

			break;
		default:

			throw new IllegalArgumentException("Unknown Uri:" + uri);

		}

		return count;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (sMatcher.match(uri))
		{
		case STUDENTS:
			return "vnd.android.cursor.dir/studentprovider/student";
		case STUDENT:
			return "vnd.android.cursor.item/studentprovider/student";

		default:
			throw new IllegalArgumentException("Unknown Uri:" + uri);
		}

	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub

		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		long pid = 0;
		switch (sMatcher.match(uri))
		{
		case STUDENTS:
			pid = db.insert("t_student", "name", values);
			// ����֮�󷵻�������id
			// content://com.kxw.privider.studentprovider/student/pid
			return ContentUris.withAppendedId(uri, pid);
		case STUDENT:
			pid = db.insert("t_student", "name", values);
			String path = uri.toString();
			// content://com.kxw.privider.studentprovider/student/pid/1
			return Uri.parse(path.substring(0, path.lastIndexOf('/') + 1) + pid);

		default:
			throw new IllegalArgumentException("Unknown Uri:" + uri);
		}

	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dbOpenHelper = new DBOpenHelper(this.getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortorder) {
		// TODO Auto-generated method stub

		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		switch (sMatcher.match(uri))
		{
		case STUDENTS:
			return db.query("t_student", projection, selection, selectionArgs, null, null, sortorder);
			// selectionArgs, groupBy, having, orderBy, limit,
			// cancellationSignal)

		case STUDENT:
			long sid = ContentUris.parseId(uri);
			String where = TextUtils.isEmpty(selection) ? "sid=?" : selection + " and sid=?";
			String[] params = new String[]
			{ String.valueOf(sid) };
			if (!TextUtils.isEmpty(selection) && selectionArgs != null)
			{
				params = new String[selectionArgs.length + 1];
				for (int i = 0; i < selectionArgs.length; i++)
				{
					params[i] = selectionArgs[i];

				}
			}
			return db.query("t_student", projection, where, params, null, null, sortorder);

		default:
			throw new IllegalArgumentException("Unknown Uri:" + uri);
		}

	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub

		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		int count = 0;
		switch (sMatcher.match(uri))
		{
		case STUDENTS:
			// content://com.kxw.privider.studentprovider/student
			count = db.update("t_student", values, selection, selectionArgs);
			// return db.update( "t_student", values, selection, selectionArgs,
			// null, null, null);
			break;
		case STUDENT:
			// content://com.kxw.privider.studentprovider/student/2
			long sid = ContentUris.parseId(uri);
			// ʹ�ù������ȡid:2
			String where = TextUtils.isEmpty(selection) ? "sid=?" : selection + " and sid=?";
			// 1.sid=?
			// 2.selection and sid =?
			// selection����name="kxw"

			// selectionArgs---?��Ӧ�Ĳ���
			String[] params = new String[]
			{ String.valueOf(sid) };
			if (!TextUtils.isEmpty(selection) && selectionArgs != null)
			{
				params = new String[selectionArgs.length + 1];
				// ������selectionArgs.length + 1��String����ռ�
				for (int i = 0; i < selectionArgs.length; i++)
				{
					params[i] = selectionArgs[i];

				}
				params[selectionArgs.length + 1] = String.valueOf(sid);
			}
			// ���û�о���if�����˵��selectionΪ�գ������� params = new String[]{
			// String.valueOf(sid) };����
			count = db.update("t_student", values, where, params);
			break;
		default:
			throw new IllegalArgumentException("Unknown Uri:" + uri);
		}

		return count;
	}

}
