package com.biz.std.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.biz.std.model.Subject;


public class StudentObject {
	private int id;
	private String studentid;
	private String name;
	private String sex;
	private Date birthday;
	private String grade;
	private int subnum;
	private float avgscore;
	private String img;
	private List<String> subject;
	public StudentObject() {
		super();
	}
	public StudentObject(int id, String studentid, String name, String sex, Date birthday, String grade, int subnum,
			float avgscore, String img, List<String> subject) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.grade = grade;
		this.subnum = subnum;
		this.avgscore = avgscore;
		this.img = img;
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getSubnum() {
		return subnum;
	}
	public void setSubnum(int subnum) {
		this.subnum = subnum;
	}
	public float getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(float avgscore) {
		this.avgscore = avgscore;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	
	
	
	
	
	
}
