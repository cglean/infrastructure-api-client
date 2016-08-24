package com.cglean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostController {

	private Log log = LogFactory.getLog(CostController.class);

	@Autowired
	InfrastructureServiceClient serviceClient;

	@RequestMapping(value = "/yesterdaycost", method = RequestMethod.GET)
	public String findYesterdayCost() {
		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		log.info("Attempting to use client to invoke service");
		Cost cost = serviceClient.getCost(yesterday.format(formatter), yesterday.format(formatter));
		log.info("Received response from service." + cost);
		return cost.toString();
	}
}
