package com.kxw.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import com.kxw.sqlite.model.Student;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class StudentDAO
{
private DBOpenHelper helper;
private SQLiteDatabase db;

public StudentDAO(Context context)
{
	helper=new DBOpenHelper(context);
}
	
	
	
	
	public void add(Student student){
		db=helper.getWritableDatabase();
		db.execSQL("insert into t_student (sid,name,age) value (?,?,?)", new Object[]
				{student.getSid(),student.getName(),student.getAge()});
		
	}
	
	
	public void update(Student student){
	
		
		db=helper.getWritableDatabase();
		db.execSQL("update t_student set name =?,age=? where sid=?", new Object[]
				{student.getName(),student.getAge(),student.getSid()});
		
		
	}
	
	
	public Student find(int sid){
		
		db=helper.getWritableDatabase();
		Cursor cursor=db.rawQuery("select sid,name,age from t_student where sid=?", new String[]
				{String.valueOf(sid)});
		
		if(cursor.moveToNext()){
			
			
			//cursor.getString(1);
			//cursor.getString(cursor.getColumnIndex("sid"));
			
			return new Student(cursor.getInt(cursor.getColumnIndex("sid")),cursor.getString(cursor.getColumnIndex("name")),cursor.getShort(cursor.getColumnIndex("age")));
			
		}
		return null;
	}
	
	
	public void delete(Integer... sids){
		
		
		if(sids.length>0){
			
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<sids.length;i++){
				
				sb.append("?").append(",");
				
			}
			sb.deleteCharAt(sb.length()-1);
			SQLiteDatabase database=helper.getWritableDatabase();
			database.execSQL("delete from t_student where sid in("+sb+")",(Object[]) sids);
			//delete from t_student where sid in(?,?,?,?)
		}
	}
	
	public List<Student> getScrollData(int start,int count)	{
		
		List<Student> students=new ArrayList<Student>();
		
		
		db=helper.getWritableDatabase();
		Cursor cursor=db.rawQuery("select * from t_student limit ?,?", new String[]
				{String.valueOf(start),String.valueOf(count)});
		
		while(cursor.moveToNext()){
			
			students.add(new Student(cursor.getInt(cursor.getColumnIndex("sid")),cursor.getString(cursor.getColumnIndex("name")),cursor.getShort(cursor.getColumnIndex("age"))));
		}
		
		return students;
	}
	
	public long getCount() {

		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select count(sid) from t_student", null);

		if (cursor.moveToNext())
		{

			return cursor.getLong(0);
		}

		return 0;
	}
	
}
