package com.biz.std.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biz.std.model.Grade;
import com.biz.std.service.GradeService;
import com.biz.std.service.StudentService;
import com.biz.std.vo.PageObject;
import com.biz.std.vo.StudentObject;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping(value="/findAllStudent",
            produces=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ModelAndView findAllStudent(int number,int size){
		ModelAndView mav=new ModelAndView();
		
		PageObject pageobject=studentService.findall(number,size);
		List<StudentObject> list=pageobject.getList();
		mav.addObject("StudentList",list);
		mav.addObject("number", pageobject.getNumber());
		mav.addObject("size", pageobject.getSize());
		mav.addObject("totalPages", pageobject.getTotalPages());
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/findStudentObjectById")
	@ResponseBody
	public StudentObject findStudentObjectById(Integer id){
		StudentObject studentObject=studentService.findStudentObjectById(id);
		return studentObject;
	}
	@RequestMapping("/updateStudentById")
	@ResponseBody
	public int updateStudentById(int id,String studentid,String name,String sex,Date birthday,String grade){
		return studentService.updateStudentById(id,studentid,name,sex,birthday,grade);
	}
	@RequestMapping("/deleteStudentById")
	@ResponseBody
	public int deleteStudentById(int id){
		return studentService.deleteStudentById(id);
	}
	@RequestMapping("/addStudent")
	@ResponseBody
	public int addStudent(String img,String studentid,String name,String sex,Date birthday,int grade){
		return studentService.addStudent("image/"+img, studentid, name, sex, birthday, grade);
	}
}
