package com.biz.std.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.biz.std.model.Grade;


public interface GradeDao extends JpaRepository<Grade,Integer> {
	Grade findGradeByGradename(String name);
	@Modifying@Transactional
	@Query("update Grade g set g.gradename=:name where g.id=:id")
	int updateGradeById(@Param(value="id")int id,@Param(value="name")String name);
}
