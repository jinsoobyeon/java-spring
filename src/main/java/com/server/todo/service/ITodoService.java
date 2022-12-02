package com.server.todo.service;

import java.util.List;

import com.server.todo.dto.TodoDto;

public interface ITodoService {
	TodoDto todoRegister(TodoDto todoDto);
	List<TodoDto> todosSearch();
	int todoRemove(TodoDto todoDto);
	int todosRemove();
}
