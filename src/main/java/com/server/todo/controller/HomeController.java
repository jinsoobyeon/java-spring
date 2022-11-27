package com.server.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.todo.dto.TodoDto;
import com.server.todo.service.TodoService;

@Controller
@CrossOrigin
public class HomeController {
	
	private final TodoService todoService;
	
	public HomeController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping("/")
	@ResponseBody
	public List<TodoDto> readTodos() {
		return todoService.todosSearch();
	}
	
	@PostMapping("/create")
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
