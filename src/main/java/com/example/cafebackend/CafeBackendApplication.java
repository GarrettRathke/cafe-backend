package com.example.cafebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
TODO
    -> make some fake data to expose to Angular
    -> consume fake data in Angular
    -> set up in-memory database H2 in this project
    -> consume in-memory data in Angular

*/


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class CafeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeBackendApplication.class, args);
	}

	@RestController
class GreetingController {
    
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}

}
