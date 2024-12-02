package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private final RestTemplate restTemplate = new RestTemplate();

	@Scheduled(fixedRate = 10000) // 10 seconds
	public void consumeRestService() {
		
		Quote quote = restTemplate.getForObject(
			"http://localhost:8080/api/random", Quote.class);
		assert quote != null;
		log.info(quote.toString());
	}
}