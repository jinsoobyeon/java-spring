package com.server.todo.service;

import java.util.ArrayList;

import com.server.todo.dto.TodoDto;

public interface ITodoService {
	int todoRegister(TodoDto todoDto);
	ArrayList<String> todosSearch();
	int todosRemove();
}
