package com.biz.std.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.biz.std.model.Grade;
import com.biz.std.model.Subject;

public interface SubjectDao extends JpaRepository<Subject,Integer>{
	@Modifying@Transactional
	@Query("update Subject s set s.name=:name where s.id=:id")
	int updateSubjectById(@Param(value="id")int id,@Param(value="name")String name);
}
