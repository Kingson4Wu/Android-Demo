package com.kxw.sqlite.activity;

import com.kxw.sqlite.dao.StudentDAO;
import com.kxw.sqlite.model.Student;

import android.test.AndroidTestCase;
import android.util.Log;

public class StudentDAOTest extends AndroidTestCase
{

	
	private static final String TAG = "StudentDAOTest";

	public void testAdd(){
		
		StudentDAO studentDAO=new StudentDAO(this.getContext());
		Student student=new Student(1,"kxw",(short)99);
		studentDAO.add(student);
		Log.i(TAG, "add Successed!");
	}
	
	
	
}
