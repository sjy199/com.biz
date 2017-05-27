package com.biz.std.service.impl;

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
import com.biz.std.repository.GradeDao;
import com.biz.std.service.GradeService;
import com.biz.std.vo.GradeObject;
import com.biz.std.vo.PageObject;
@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private GradeDao gradedao;
	public PageObject findall(int number,int size) {
		 Pageable pageable = new PageRequest(number,size);
		Page<Grade> page=gradedao.findAll(pageable);
		List<Grade> list=page.getContent();
		List<GradeObject> list1=new ArrayList<GradeObject>();
		for (Grade grade : list) {
			GradeObject gradeObject=new GradeObject();
			gradeObject.setId(grade.getId());
			gradeObject.setGradename(grade.getGradename());
			gradeObject.setPersonnum(grade.getStudent().size());
			float sum=0;
			List<Student> studentList=grade.getStudent();
			for (Student student : studentList) {
				float stuSum=0;
				float stuAvg=0;
				List<Score> scoreList=student.getScores();
				for (Score score : scoreList) {
					stuSum=stuSum+score.getScore();
				}
				stuAvg=stuSum/scoreList.size();
				sum=sum+stuAvg;
			}
			
			gradeObject.setAvgscore((float)(Math.round(sum/grade.getStudent().size()*100))/100);
			list1.add(gradeObject);
			}
		PageObject pageObject=new PageObject(list1,page.getTotalPages(),page.getTotalElements(),page.getSize(),page.getNumber());
		return pageObject;
	}
	public int addGrade(String name) {
		Grade grade=new Grade();
		grade.setGradename(name);
		gradedao.save(grade);
		return 0;
	}
	public int updateGradeById(int id, String name) {
		gradedao.updateGradeById(id, name);
		return 0;
	}
	public int deleteGradeById(int id) {
		gradedao.delete(id);
		return 0;
	}

}
