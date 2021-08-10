package com.caha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caha.model.Person;
import com.caha.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "PersonAPI") // API
@RestController
@RequestMapping("/api/v1/Persons")
public class PersonController {

	@Autowired
	private PersonService service;

	@ApiOperation(value = "Get the list of Persons", response = Iterable.class) // ApiOperation
	@ApiResponses(value = { // API Responses
			@ApiResponse(code = 200, message = "Success|OK"), 
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"), 
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping()
	public List<Person> getAllPersons() {
		return service.getPersons();
	}

	@ApiOperation(value = "Get an specific Person", response = Person.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK", response = Person.class),
			@ApiResponse(code = 400, message = "bad request!!!") })
	@GetMapping("/{id}")
	public Person getPerson(@ApiParam(value = "id", example = "1") @PathVariable int id) { // ApiParam
		return service.getPerson(id);
	}

	@ApiOperation(value = "Create a new Person ")
	@PostMapping
	public void createPerson(Person Person) {
		service.insertPerson(Person);
	}

	@ApiOperation(value = "Update a Person", response = Person.class)
	@PutMapping
	public Person updatePerson(Person Person) {
		return service.updatePerson(Person);
	}

	@ApiOperation(value = "Delete a Person")
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable int id) {
		Person prd = service.getPerson(id);
		if (prd != null) {
			service.deletePerson(prd);
		}
	}

}
