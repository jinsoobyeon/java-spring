package com.server.todo.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public ArrayList<String> todoSearch() {
		ArrayList<String> todos = new ArrayList<String>();
	
		List<TodoDto> todoSelect = todoDao.todoSelect();
		for (int i = 0; i < todoSelect.size(); i++) {
			todos.add(todoSelect.get(i).getTodo());
		}
		
		return todos;
	}
}
