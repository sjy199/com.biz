package com.biz.std.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.biz.std.model.Grade;
import com.biz.std.model.Score;

public interface ScoreDao extends JpaRepository<Score,Integer>{
	@Modifying@Transactional
	@Query("delete from Score where student_id=:id")
	int deleteScoreByStudent_id(@Param(value="id")int student_id);
	@Modifying@Transactional
	@Query("update Score s set s.score=:score where s.id=:id")
	int updateScoreById(@Param(value="id")int id,@Param(value="score")float score);
}
