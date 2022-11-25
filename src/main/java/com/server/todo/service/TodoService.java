package com.server.todo.service;

import java.util.ArrayList;
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
		for (String todo : this.todosSearch()) {
			if (todo.equals(todoDto.getTodo())) {
				return 0;
			}
		}
		
		return todoDao.todoInsert(todoDto);
	}

	@Override
	public ArrayList<String> todosSearch() {
		ArrayList<String> todos = new ArrayList<String>();
	
		List<TodoDto> todoSelect = todoDao.todosSelect();
		for (int i = 0; i < todoSelect.size(); i++) {
			todos.add(todoSelect.get(i).getTodo());
		}
		
		return todos;
	}

	@Override
	public int todosRemove() {
		return todoDao.todosDelete();
	}
}
