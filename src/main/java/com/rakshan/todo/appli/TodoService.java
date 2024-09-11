package com.rakshan.todo.appli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<TodoAppli> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new TodoAppli(++todosCount, "in28minutes","Get AWS Certified 1", 
							LocalDate.now().plusYears(1), false ));
		todos.add(new TodoAppli(++todosCount, "in28minutes","Learn DevOps 1", 
				LocalDate.now().plusYears(2), false ));
		todos.add(new TodoAppli(++todosCount, "in28minutes","Learn Full Stack Development 1", 
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<TodoAppli> findByUsername(String username){
		Predicate<? super TodoAppli> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		TodoAppli todo = new TodoAppli(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super TodoAppli> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public TodoAppli findById(int id) {
		Predicate<? super TodoAppli> predicate = todo -> todo.getId() == id;
		TodoAppli todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid TodoAppli todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}