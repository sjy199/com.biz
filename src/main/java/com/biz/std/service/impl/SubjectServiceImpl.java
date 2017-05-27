package com.biz.std.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biz.std.model.Score;
import com.biz.std.model.Subject;
import com.biz.std.repository.SubjectDao;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.PageObject;
import com.biz.std.vo.SubjectObject;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectDao subjectDao;
	public PageObject findAll(int number,int size) {
		Pageable pageable = new PageRequest(number,size);
		Page<Subject> page=subjectDao.findAll(pageable);
		List<Subject> list=page.getContent();
		List<SubjectObject> list1=new ArrayList<SubjectObject>();
		for (Subject subject : list) {
			SubjectObject so=new SubjectObject();
			so.setId(subject.getId());
			so.setName(subject.getName());
			so.setNum(subject.getScores().size());
			List<Score> scoreList=subject.getScores();
			float sum=0;
			for (Score score : scoreList) {
				sum=sum+score.getScore();
			}
			so.setAvgscore((float)(Math.round(sum/subject.getScores().size()*100))/100);
			list1.add(so);
		}
		PageObject pageobject=new PageObject(list1,page.getTotalPages(),page.getTotalElements(),page.getSize(),page.getNumber());
		return pageobject;
	}
	public int addSubject(String name) {
		Subject subject=new Subject();
		subject.setName(name);
		subjectDao.save(subject);
		return 0;
	}
	public int updateSubjectById(int id,String name) {
		subjectDao.updateSubjectById(id, name);
		return 0;
	}
	public int delSubjectById(int id) {
		subjectDao.delete(id);
		return 0;
	}
	
}
