package com.server.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.server.todo.dao.TodoDao;
import com.server.todo.dto.TodoDto;

@Service
public class TodoService implements ITodoService {
	
	private final TodoDao todoDao;

	public TodoService(TodoDao todoDao) {
		super();
		this.todoDao = todoDao;
	}

	@Override
	public int todoRegister(TodoDto todoDto) {
		for (TodoDto todo : this.todosSearch()) {
			if (todo.getTodo().equals(todoDto.getTodo())) {
				return 0;
			}
		}
		
		return todoDao.todoInsert(todoDto);
	}

	@Override
	public List<TodoDto> todosSearch() {
		return todoDao.todosSelect();
	}

	@Override
	public int todosRemove() {
		return todoDao.todosDelete();
	}
}
