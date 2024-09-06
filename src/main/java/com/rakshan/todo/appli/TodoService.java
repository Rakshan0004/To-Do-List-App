package com.rakshan.todo.appli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<TodoAppli> todos = new ArrayList<>();
	
	private static int todosCount= 0;
	
	static {
		todos.add(new TodoAppli(todosCount++, "rakshan", "springboot", 
				LocalDate.now().plusYears(1), true));
		todos.add(new TodoAppli(todosCount++, "rakshan", "learn devops", 
				LocalDate.now().plusYears(2), false));
		todos.add(new TodoAppli(todosCount++, "rakshan", "full stack", 
				LocalDate.now().plusYears(3), true));
	}
	
	public List<TodoAppli> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		TodoAppli todo = new TodoAppli(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		
		Predicate<? super TodoAppli> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
}
