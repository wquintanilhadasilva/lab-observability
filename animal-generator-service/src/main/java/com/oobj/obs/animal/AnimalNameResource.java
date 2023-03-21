package com.oobj.obs.animal;

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
@RequestMapping("/api/v1/animals")
@Slf4j
public class AnimalNameResource {
	
	private final List<String> animalNames;
	private Random random;
	public AnimalNameResource() throws IOException {
		InputStream inputStream = new ClassPathResource("/animals.txt").getInputStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			animalNames = reader.lines().collect(Collectors.toList());
		}
		random = new Random();
	}
	@GetMapping(path = "/random")
	public String name(@RequestHeader HttpHeaders headers) {
		log.debug("Obtendo um animal");
		String name = animalNames.get(random.nextInt(animalNames.size()));
		log.debug("Animal retornado: [{}]", name);
		return name;
	}

}
