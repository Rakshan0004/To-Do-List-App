package com.rakshan.todo.appli;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface TodoRepository extends JpaRepository<TodoAppli, Integer>{
	public List<TodoAppli> findByUsername(String username);
}
