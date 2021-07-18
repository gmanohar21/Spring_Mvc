package com.mn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mn.model.caronavac;

@Service
public class CaronaVacServiceImpl implements ICaronaVacService {
	@Override
	public List<caronavac> vacDetails() {
		System.out.println("CaronaVacServiceImpl.vacDetails()");
		return List.of(new caronavac("manu", "sputnik", 100), new caronavac("vanu", "mputnik", 150),
				new caronavac("ganu", "kputnik", 1000), new caronavac("sanu", "lputnik", 1500));
	}
}
