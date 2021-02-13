package com.mn.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mn.service.IWishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private IWishMessageService service;

	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/wish.htm")
	public ModelAndView getMessage() {
		String msg = service.generateWishMessage();
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		System.out.println(mav + "mav display");
		mav.addObject("wMsg", msg);
		mav.addObject("sysDate", new Date());
		mav.setViewName("result");

		return mav;

	}
}
