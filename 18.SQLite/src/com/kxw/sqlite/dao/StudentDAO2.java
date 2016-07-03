package com.kxw.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import com.kxw.sqlite.model.Student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentDAO2
{

	private DBOpenHelper helper;
	private SQLiteDatabase db;

	public StudentDAO2(Context context)
	{
		helper = new DBOpenHelper(context);
	}

	public void add(Student student) {
		// ------------StudentDAO--------------
		// db=helper.getWritableDatabase();
		// db.execSQL("insert into t_student (sid,name,age) value (?,?,?)", new
		// Object[]
		// {student.getSid(),student.getName(),student.getAge()});
		// -------------StudentDAO2-----------
		db = helper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("sid", student.getSid());
		values.put("name", student.getName());
		values.put("age", student.getAge());

		db.insert("t_student", "sid", values);

	}

	public void update(Student student) {

		// ------------StudentDAO--------------
		// db=helper.getWritableDatabase();
		// db.execSQL("update t_student set name =?,age=? where sid=?", new
		// Object[]
		// {student.getName(),student.getAge(),student.getSid()});

		db = helper.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put("name", student.getName());
		values.put("age", student.getAge());
		db.update("t_student", values, "sid=?", new String[]
		{ String.valueOf(student.getSid()) });

	}

	public Student find(int sid) {

		db = helper.getWritableDatabase();

		// db.query(distinct, table, columns, selection, selectionArgs, groupBy,
		// having, orderBy, limit, cancellationSignal)
		Cursor cursor = db.query("t_student", new String[]
		{ "sid", "name", "age" }, "sid=?", new String[]
		{ String.valueOf(sid) }, null, null, null);

		if (cursor.moveToNext())
		{

			// return new
			// Student(cursor.getInt(cursor.getColumnIndex("sid")),cursor.getString(cursor.getColumnIndex("name")),cursor.getShort(cursor.getColumnIndex("age")));
			return new Student(cursor.getInt(0), cursor.getString(1), cursor.getShort(2));
		}
		return null;
	}

	public void delete(Integer... sids) {

		if (sids.length > 0)
		{

			StringBuffer sb = new StringBuffer();
			String[] strPid = new String[sids.length];

			for (int i = 0; i < sids.length; i++)
			{

				sb.append("?").append(",");

				strPid[i] = String.valueOf(sids[i]);

			}
			sb.deleteCharAt(sb.length() - 1);
			db = helper.getWritableDatabase();
			// -----------上面的和StudentDAO一样
			// db.execSQL("delete from t_student where sid in("+sb+")",(Object[])
			// sids);
			// delete from t_student where sid in(?,?,?,?)

			db.delete("t_student", "sid in (" + sb + ")", strPid);
		}
	}

	public List<Student> getScrollData(int start, int count) {

		List<Student> students = new ArrayList<Student>();

		db = helper.getWritableDatabase();
		Cursor cursor = db.query("t_student", new String[]
		{ "sid", "name", "age" }, null, null, null, null, "sid desc", start + "," + count);

		while (cursor.moveToNext())
		{

			students.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getShort(2)));
		}

		return students;
	}

	public long getCount() {

		db = helper.getWritableDatabase();
		Cursor cursor = db.query("t_student", new String[]
		{ "count(*)" }, null, null, null, null, null);

		if (cursor.moveToNext())
		{

			return cursor.getLong(0);
		}

		return 0;
	}

}
