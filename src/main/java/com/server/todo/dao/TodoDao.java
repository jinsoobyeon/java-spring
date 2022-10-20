package com.server.todo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.server.todo.dto.TodoDto;

@Repository
public class TodoDao implements ITodoDao {
	private JdbcTemplate template;
	
	@Autowired
	public TodoDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public int todoInsert(TodoDto todoDto) {
		final String sql = "INSERT INTO todos (todo) values (?)";
		
		return template.update(sql, todoDto.getTodo());
	}

	@Override
	public List<TodoDto> todoSelect() {
		final String sql = "SELECT * FROM todos";
		
		return template.query(sql, new RowMapper<TodoDto>() {
			
			@Override
			public TodoDto mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
				TodoDto todo = new TodoDto();
				todo.setTodo(resultSet.getString("todo"));
				return todo;
			}
		});
	}
}
