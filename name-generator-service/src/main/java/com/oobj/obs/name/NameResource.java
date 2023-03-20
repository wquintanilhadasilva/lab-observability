package com.oobj.obs.name;

import static strman.Strman.toKebabCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/names")
@AllArgsConstructor
@Slf4j
public class NameResource {
	
	private final AnimalServiceClient animalServiceClient;
	private final ScientistServiceClient scientistServiceClient;
	
	
	@GetMapping(path = "/random")
	public String name() throws Exception {
		log.debug("Início da requisição");
		String animal = animalServiceClient.randomAnimalName();
		String scientist = scientistServiceClient.randomScientistName();
		String name = toKebabCase(scientist) + "-" + toKebabCase(animal);
		log.debug("Término da requisição");
		return name;
	}

}
