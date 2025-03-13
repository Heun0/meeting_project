package com.example.meeting_project;

import com.example.meeting_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeetingProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MeetingProjectApplication.class, args);
	}

	@Autowired
	UserService userService;


	@Override
	public void run(String... args) throws Exception {
		String message = userService.register("aaa@abc.com","1234");
		System.out.println(message);
	}
}
