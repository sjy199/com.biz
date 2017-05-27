package com.biz.std.vo;

public class SubjectObject {
	private Integer id;
	private String name;
	private Integer num;
	private float avgscore;
	public SubjectObject() {
		super();
	}
	public SubjectObject(Integer id, String name, Integer num, float avgscore) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.avgscore = avgscore;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public float getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(float avgscore) {
		this.avgscore = avgscore;
	}
	
}
