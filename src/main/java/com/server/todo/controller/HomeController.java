package com.server.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.server.todo.dto.TodoDto;
import com.server.todo.service.TodoService;

@Controller
public class HomeController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping("/create")
	public String createTodo(TodoDto todoDto) {
		int result = todoService.todoRegister(todoDto);
		
		if (result == 1) {
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}
	
}
