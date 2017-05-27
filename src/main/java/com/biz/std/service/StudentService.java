package com.biz.std.service;

import java.sql.Date;
import java.util.List;

import com.biz.std.model.Student;
import com.biz.std.vo.PageObject;
import com.biz.std.vo.StudentObject;

public interface StudentService {
	PageObject findall(int number,int size);
	StudentObject findStudentObjectById(int id);
	int updateStudentById(int id,String studentid,String name,String sex,Date birthday,String grade);
	int deleteStudentById(int id);
	int addStudent(String img,String studentid,String name,String sex,Date birthday,int grade);
}
