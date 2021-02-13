package com.mn.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements IWishMessageService {

	public String generateWishMessage() {
		// Date and time
		Calendar cal = Calendar.getInstance();
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		if (hr < 12) {
			return "Morning";
		} else if (hr < 16) {
			return "Afternoon";
		} else if (hr < 20) {
			return "Evening";
		} else {
			return "Night";
		}

	}

}
