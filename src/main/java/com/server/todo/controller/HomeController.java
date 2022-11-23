package com.server.todo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.todo.dto.TodoDto;
import com.server.todo.service.TodoService;

@Controller
public class HomeController {
	
	private final TodoService todoService;
	
	public HomeController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping("/")
	@ResponseBody
	public ArrayList<String> readTodos() {
		return todoService.todosSearch();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public int createTodo(@RequestBody TodoDto todoDto) {
		return todoService.todoRegister(todoDto);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public int deleteTodos() {
		return todoService.todosRemove();
	}
}
