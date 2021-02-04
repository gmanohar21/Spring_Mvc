package com.mn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mn.service.IWishMessageService;

public class WishMessageGenerator implements Controller {
	private IWishMessageService service;

	public WishMessageGenerator(IWishMessageService service) {
		this.service = service;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = service.generateWishMessage();
		return new ModelAndView("result", "Wmsg", msg);
	}

}
