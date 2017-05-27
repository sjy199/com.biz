package com.biz.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.std.model.Score;
import com.biz.std.service.ScoreService;
import com.biz.std.vo.PageObject;

@Controller
public class ScoreController {
	@Autowired
	private ScoreService scoreservice;
	@RequestMapping("/addScore")
	@ResponseBody
	public int addScore(int student_id,int subject_id){
		return scoreservice.addScore(student_id, subject_id);
	}
	@RequestMapping("/findAllScore")
	@ResponseBody
	public ModelAndView findAllScore(int number,int size){
		ModelAndView mav=new ModelAndView();
		
		PageObject pageobject=scoreservice.findAllScore(number,size);
		List<Score> list=pageobject.getList();
		mav.setViewName("score");
		mav.addObject("scoreList", list);
		mav.addObject("number", pageobject.getNumber());
		mav.addObject("size", pageobject.getSize());
		mav.addObject("totalPages", pageobject.getTotalPages());
		return mav;
	}
	@RequestMapping("/updateScoreById")
	@ResponseBody
	public int updateScoreById(int id,float score){
		System.out.println(id);
		return scoreservice.updateScoreById(id, score);
	}
}
