package com.kodilla.reflection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.lang.reflect.Field;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void readPrivateField() throws NoSuchFieldException, IllegalAccessException {
		Student student = new Student();
		Field field = Student.class.getDeclaredField("indexNumber");
		field.setAccessible(true);
		String result = (String) field.get(student);
		field.setAccessible(false);
		log.info("Value from private field: {}",result);
	}
}
