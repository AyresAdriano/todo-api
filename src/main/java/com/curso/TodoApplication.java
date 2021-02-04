package com.curso;

import com.curso.repository.TodoRepository;
import com.curso.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TodoApplication {

	@Autowired
	TodoRepository todoRepository;

// test de conexão
//	@Bean
//	public CommandLineRunner init(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				Todo todo = new Todo();
//				todo.setDescription("MiguePro");
//				todo.setCreatedDate(LocalDateTime.now());
//				todoRepository.save(todo);
//			}
//		};
//	}


	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
