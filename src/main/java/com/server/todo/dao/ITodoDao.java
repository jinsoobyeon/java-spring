package com.server.todo.dao;

import com.server.todo.dto.TodoDto;

public interface ITodoDao {
	int todoInsert(TodoDto todoDto);
}
