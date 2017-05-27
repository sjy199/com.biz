package com.biz.std.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.biz.std.model.Grade;
import com.biz.std.vo.GradeObject;
import com.biz.std.vo.PageObject;

public interface GradeService {
	PageObject findall(int number,int size);
	int addGrade(String name);
	int updateGradeById(int id,String name);
	int deleteGradeById(int id);
}
