package com.biz.std.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.GradeDao;
import com.biz.std.repository.ScoreDao;
import com.biz.std.repository.StudentDao;
import com.biz.std.repository.SubjectDao;
import com.biz.std.service.StudentService;
import com.biz.std.vo.PageObject;
import com.biz.std.vo.StudentObject;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentdao;
	@Autowired
	private GradeDao gradeDao;
	@Autowired
	private ScoreDao scoredao;
	public PageObject findall(int number,int size) {
		Pageable pageable = new PageRequest(number,size);
		Page<Student> page=studentdao.findAll(pageable);
		List<Student> stuList=page.getContent();
		List<StudentObject> stuObjList=new ArrayList<StudentObject>();
		
		for (Student student : stuList) {
			StudentObject studentObject=new StudentObject();
			studentObject.setId(student.getId());
			studentObject.setGrade(student.getGrade().getGradename());
			studentObject.setBirthday(student.getBirthday());
			studentObject.setImg(student.getImg());
			studentObject.setName(student.getName());
			studentObject.setSex(student.getSex());
			studentObject.setStudentid(student.getStudentid());
			List<Score> score=student.getScores();
			float sum=0;
			int n=0;
			float avgscore=0;
			List<String> subList=new ArrayList<String>();
			for (Score score2 : score) {
				sum=sum+score2.getScore();
				n=n+1;
				subList.add(score2.getSubject().getName());
			}
			avgscore=sum/n;
			studentObject.setAvgscore((float)(Math.round(avgscore*100))/100);
			studentObject.setSubject(subList);
			studentObject.setSubnum(n);
			stuObjList.add(studentObject);
		}
		PageObject pageobject=new PageObject(stuObjList,page.getTotalPages(),page.getTotalElements(),page.getSize(),page.getNumber());
		return pageobject;
	}
	public StudentObject findStudentObjectById(int id) {
		Student student=studentdao.findOne(id);
		StudentObject studentObject=new StudentObject();
		studentObject.setId(student.getId());
		studentObject.setGrade(student.getGrade().getGradename());
		studentObject.setBirthday(student.getBirthday());
		studentObject.setImg(student.getImg());
		studentObject.setName(student.getName());
		studentObject.setSex(student.getSex());
		studentObject.setStudentid(student.getStudentid());
		List<Score> score=student.getScores();
		float sum=0;
		int n=0;
		float avgscore=0;
		List<String> subList=new ArrayList<String>();
		for (Score score2 : score) {
			sum=sum+score2.getScore();
			n=n+1;
			subList.add(score2.getSubject().getName());
		}
		avgscore=(float)sum/n;
		studentObject.setAvgscore((float)(Math.round(avgscore*100))/100);
		studentObject.setSubject(subList);
		studentObject.setSubnum(n);
		return studentObject;
	}
	public int updateStudentById(int id,String studentid,String name,String sex,Date birthday,String grade) {
		
		return studentdao.updateStudentById(id,studentid,name,sex,birthday,gradeDao.findGradeByGradename(grade));
		
	}
	public int deleteStudentById(int id) {
		scoredao.deleteScoreByStudent_id(id);
		
		return studentdao.deleteStudentById(id);
	}
	public int addStudent(String img,String studentid,String name,String sex,Date birthday,int grade) {
		System.out.println(grade);
		Student student=new Student();
		student.setBirthday(birthday);
		student.setGrade(gradeDao.getOne(grade));
		student.setImg(img);
		student.setName(name);
		student.setSex(sex);
		student.setStudentid(studentid);
		student.setScores(null);
		studentdao.save(student);
		return 0;
	}

}
