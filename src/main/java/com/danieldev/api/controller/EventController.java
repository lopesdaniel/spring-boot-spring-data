package com.danieldev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danieldev.api.models.Event;
import com.danieldev.api.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventRepository eventRepository;

	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@ResponseBody
	public List<Event> findAll(){
		return (List<Event>) this.eventRepository.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public Event create(@RequestBody Event event) {
		this.eventRepository.save(event);
		
		return event;
	}
	
	
	
}
