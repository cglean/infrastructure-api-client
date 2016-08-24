package com.cglean;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("INFRASTRUCTURE-API")
public interface InfrastructureServiceClient {

	@RequestMapping(value = "/cost", method = RequestMethod.GET)
	public Cost getCost(@RequestParam("start") String start, @RequestParam("end") String end);
}
