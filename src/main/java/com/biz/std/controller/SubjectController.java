package com.biz.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.biz.std.model.Subject;
import com.biz.std.service.SubjectService;
import com.biz.std.vo.PageObject;
import com.biz.std.vo.SubjectObject;
@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	@RequestMapping("/findAllSubject")
	@ResponseBody
	public List<SubjectObject> findAll(){
		PageObject pageobject=subjectService.findAll(0,999999);
		List<SubjectObject> list=pageobject.getList();
		return list;
	}
	@RequestMapping("/findAllSub")
	@ResponseBody
	public ModelAndView findAllSubject(int number,int size){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("subject");
		PageObject pageobject=subjectService.findAll(number,size);
		List<SubjectObject> list=pageobject.getList();
		mav.addObject("number", pageobject.getNumber());
		mav.addObject("size", pageobject.getSize());
		mav.addObject("totalPages", pageobject.getTotalPages());
		mav.addObject("subList", list);
		return mav;
	}
	@RequestMapping("/addSubject")
	@ResponseBody
	public int addSubject(String subject){
		return subjectService.addSubject(subject);
	}
	@RequestMapping("/updateSubjectById")
	@ResponseBody
	public int updateSubjectById(int id,String name){
		return subjectService.updateSubjectById(id, name);
	}
	@RequestMapping("/deleteSubjectById")
	@ResponseBody
	public int deleteSubjectById(int id){
		return subjectService.delSubjectById(id);
	}
}
