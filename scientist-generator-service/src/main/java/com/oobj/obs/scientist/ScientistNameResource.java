package com.oobj.obs.scientist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/scientists")
@Slf4j
public class ScientistNameResource {
	
	private final List<String> scientistsNames;
	private Random random;
	
	public ScientistNameResource() throws IOException {
		InputStream inputStream = new ClassPathResource("/scientists.txt").getInputStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			scientistsNames = reader.lines().collect(Collectors.toList());
		}
		random = new Random();
	}
	
	@GetMapping(path = "/random")
	public String name(@RequestHeader HttpHeaders headers) {
		log.debug("Obtendo um Cientista");
		String name = scientistsNames.get(random.nextInt(scientistsNames.size()));
		log.debug("Retornando um Cientista");
		return name;
	}

}
