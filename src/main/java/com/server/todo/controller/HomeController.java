package com.server.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/")
	@ResponseBody
	public List<TodoDto> readTodos() {
		return todoService.todosSearch();
	}
	
	@PostMapping("/create")
	@ResponseBody
	public int createTodo(@RequestBody TodoDto todoDto) {
		return todoService.todoRegister(todoDto);
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public int deleteTodo(@RequestBody TodoDto todoDto) {
		return todoService.todoRemove(todoDto);
	}
	
	@DeleteMapping("/deleteAll")
	@ResponseBody
	public int deleteTodos() {
		return todoService.todosRemove();
	}
}
