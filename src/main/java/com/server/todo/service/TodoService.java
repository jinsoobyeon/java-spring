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
	public TodoDto todoRegister(TodoDto todoDto) {
		for (TodoDto todo : this.todosSearch()) {
			if (todo.getTodo().equals(todoDto.getTodo())) {
				return new TodoDto();
			}
		}
		
		if (todoDao.todoInsert(todoDto) == 1) {
			return todoDao.todoSelect(todoDto).get(0);
		}
		
		return new TodoDto();
	}

	@Override
	public List<TodoDto> todosSearch() {
		return todoDao.todosSelect();
	}

	
	@Override
	public int todoRemove(TodoDto todoDto) {
		return todoDao.todoDelete(todoDto);
	}

	@Override
	public int todosRemove() {
		return todoDao.todosDelete();
	}
}
