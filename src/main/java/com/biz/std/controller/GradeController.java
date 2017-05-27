package com.biz.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.std.model.Grade;
import com.biz.std.repository.GradeDao;
import com.biz.std.service.GradeService;
import com.biz.std.vo.GradeObject;
import com.biz.std.vo.PageObject;

@Controller
public class GradeController {
	@Autowired
	private GradeService gradeservice;
	@RequestMapping("/findAllGrade")
	@ResponseBody
	public List<GradeObject> findAllGrade(){
		PageObject pageGrade=gradeservice.findall(0,9999999);
		List<GradeObject> list=pageGrade.getList();
		return list;
	}
	@RequestMapping("/findAll")
	@ResponseBody
	public ModelAndView findAll(int number,int size){
		PageObject pageGrade=gradeservice.findall(number,size);
		List<GradeObject> list=pageGrade.getList();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("grade");
		mav.addObject("gradeList", list);
		mav.addObject("number", pageGrade.getNumber());
		mav.addObject("size", pageGrade.getSize());
		mav.addObject("totalPages", pageGrade.getTotalPages());
		return mav;
	}
	@RequestMapping("/addGrade")
	@ResponseBody
	public int addGrade(String grade){
		return gradeservice.addGrade(grade);
	}
	
	@RequestMapping("/updateGradeById")
	@ResponseBody
	public int updateGradeById(int id,String name){
		return gradeservice.updateGradeById(id, name);
	}
	@RequestMapping("/deleteGradeById")
	@ResponseBody
	public int deleteGradeById(int id){
		return gradeservice.deleteGradeById(id);
	}
	
}
