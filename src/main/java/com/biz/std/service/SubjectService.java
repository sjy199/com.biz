package com.biz.std.service;

import java.util.List;

import com.biz.std.model.Subject;
import com.biz.std.vo.PageObject;
import com.biz.std.vo.SubjectObject;

public interface SubjectService {
	PageObject findAll(int number,int size);
	int addSubject(String name);
	int updateSubjectById(int id,String name);
	int delSubjectById(int id);
}
