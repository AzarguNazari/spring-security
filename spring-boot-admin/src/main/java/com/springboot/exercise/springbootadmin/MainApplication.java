package com.springboot.exercise.springbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAdminServer
@SpringBootApplication
public class MainApplication {

		public static void main(String[] args) {
				SpringApplication.run(MainApplication.class, args);
		}

}