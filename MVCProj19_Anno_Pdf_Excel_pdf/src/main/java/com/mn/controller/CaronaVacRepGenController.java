package com.mn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mn.model.caronavac;
import com.mn.service.ICaronaVacService;

@Controller
public class CaronaVacRepGenController {

	@Autowired
	private ICaronaVacService service;

	@GetMapping("/")
	public String homePage() {
		System.out.println("CaronaVacRepGenController.homePage()");
		return "home";
	}

	@GetMapping("/report")
	public String genReport(@RequestParam("type") String type, Map<String, Object> map) {
		System.out.println("CaronaVacRepGenController.genReport()");
		List<caronavac> listenti = service.vacDetails();
		map.put("vacList", listenti);
		if (type.equalsIgnoreCase("pdf")) {
			return "pdf_view";
		} else {
			return "excel_view";
		}
	}
}
