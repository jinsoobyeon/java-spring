package com.server.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.todo.dao.TodoDao;
import com.server.todo.dto.TodoDto;

@Service
public class TodoService implements ITodoService {
	
	@Autowired
	TodoDao todoDao;

	@Override
	public int todoRegister(TodoDto todoDto) {
		return todoDao.todoInsert(todoDto);
	}
	
}
