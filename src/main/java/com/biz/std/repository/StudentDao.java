package com.biz.std.repository;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.biz.std.model.Grade;
import com.biz.std.model.Student;

public interface StudentDao extends JpaRepository<Student,Integer>{
	@Modifying@Transactional
	@Query("update Student s set s.studentid=:studentid,s.name=:name,s.sex=:sex,s.birthday=:birthday,s.grade=:grade where s.id=:id")
	int updateStudentById(@Param(value="id")int id,@Param(value="studentid")String studentid,@Param(value="name")String name,@Param(value="sex")String sex,@Param(value="birthday")Date birthday,@Param(value="grade")Grade grade);
	@Modifying@Transactional
	@Query("update Student s set s.grade=null where s.id=:id")
	int updateStudentGradeById(@Param(value="id")int id);
	@Modifying
	@Transactional
	@Query("delete from Student s where s.id=:id")
	int deleteStudentById(@Param(value="id")int id);
}
