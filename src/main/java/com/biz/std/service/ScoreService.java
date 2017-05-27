package com.biz.std.service;

import java.util.List;

import com.biz.std.model.Score;
import com.biz.std.vo.PageObject;

public interface ScoreService {
	int addScore(int student_id,int subject_id);
	PageObject findAllScore(int number,int size);
	int updateScoreById(int id,float score);
}
