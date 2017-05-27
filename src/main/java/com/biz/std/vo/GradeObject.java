package com.biz.std.vo;

public class GradeObject {
	private int id;
	private String gradename;
	private int personnum;
	private float avgscore;
	public GradeObject() {
		super();
	}
	public GradeObject(String gradename, int personnum, float avgscore) {
		super();
		this.gradename = gradename;
		this.personnum = personnum;
		this.avgscore = avgscore;
	}
	public GradeObject(int id, String gradename, int personnum, float avgscore) {
		super();
		this.id = id;
		this.gradename = gradename;
		this.personnum = personnum;
		this.avgscore = avgscore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGradename() {
		return gradename;
	}
	public void setGradename(String gradename) {
		this.gradename = gradename;
	}
	public int getPersonnum() {
		return personnum;
	}
	public void setPersonnum(int personnum) {
		this.personnum = personnum;
	}
	public float getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(float avgscore) {
		this.avgscore = avgscore;
	}
	
}
