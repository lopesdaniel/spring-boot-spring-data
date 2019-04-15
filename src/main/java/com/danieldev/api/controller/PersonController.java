package com.danieldev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danieldev.api.models.Event;
import com.danieldev.api.models.Person;
import com.danieldev.api.repository.EventRepository;
import com.danieldev.api.repository.PersonRepository;

@RestController
@RequestMapping("/events/{eventId}/people")
public class PersonController{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EventRepository eventRepository;

	public PersonController(PersonRepository personRepository, EventRepository eventRepository) {
		this.personRepository = personRepository;
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@ResponseBody
	public List<Person> findAll(){
		return (List<Person>) this.personRepository.findAll();
	}
	
	@PostMapping
	@RequestMapping
	public Person create(@PathVariable("eventId") Long eventId, @RequestBody Person person) {
		Event event = this.eventRepository.findOne(eventId);
		
		person.setEventId(event);
		
		
		return this.personRepository.save(person);
		
	}
	
	

}
