package com.nineworanop.schoolexample.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sleep")
public class SleepRestController {

	@GetMapping(path = "/{time}")
	public ResponseEntity<String> sleepTime(@PathVariable String time) throws InterruptedException {
		long sleepTime = Long.valueOf(time).longValue();
		Thread.sleep(sleepTime);
		return new ResponseEntity<>(time, HttpStatus.OK);
	}

}
