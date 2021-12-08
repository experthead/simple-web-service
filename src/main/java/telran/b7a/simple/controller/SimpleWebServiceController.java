package telran.b7a.simple.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.simple.dto.PersonDto;
import telran.b7a.simple.dto.PersonFoodDto;

@RestController //include Responce Body
public class SimpleWebServiceController {

	@GetMapping("/hello") // the end of endpoint, http://<...>/endpoint?@RequestParam /hello?name=Victor
	public String hello(@RequestParam String name) {
		return "Hello " + name;

	}

	@PostMapping("/hello")
	public String bye(@RequestParam String name) { // servlets was here
		return name + " bye, bye!";

	}
	
	@PostMapping("/person")
	public String greetingPeson(@RequestBody PersonDto personDto) { //json in BODY
		return "Hello: " + personDto.getFirstName() + " " + personDto.getLastName();

	}
	@PostMapping("/feed")
	public PersonFoodDto feedPersons(@RequestBody PersonDto personDto) {  
		return PersonFoodDto.builder()                                                    //learning builder!!!!
					.fullName(personDto.getFirstName() + " " + personDto.getLastName())
					.food("candy")
					.food("banana")
					.food("clementine")
					.build();
		
	}
}
