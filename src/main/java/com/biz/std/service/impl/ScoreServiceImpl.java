package com.biz.std.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biz.std.model.Score;
import com.biz.std.model.Student;
import com.biz.std.model.Subject;
import com.biz.std.repository.ScoreDao;
import com.biz.std.repository.StudentDao;
import com.biz.std.repository.SubjectDao;
import com.biz.std.service.ScoreService;
import com.biz.std.vo.PageObject;
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreDao socredao;
	@Autowired
	private StudentDao studentdao;
	@Autowired
	private SubjectDao subjectdao;
	public int addScore(int student_id,int subject_id) {
		Student student=studentdao.getOne(student_id);
		Subject subject=subjectdao.getOne(subject_id);
		Score score=new Score();
		score.setStudent(student);
		score.setSubject(subject);
		socredao.save(score);
		return 0;
	}
	public PageObject findAllScore(int number,int size) {
		Pageable pageable = new PageRequest(number,size);
		Page<Score> page=socredao.findAll(pageable);
		PageObject pageobject=new PageObject(page.getContent(),page.getTotalPages(),page.getTotalElements(),page.getSize(),page.getNumber());
		return pageobject;
	}
	public int updateScoreById(int id, float score) {
		socredao.updateScoreById(id, score);
		return 0;
	}

}
