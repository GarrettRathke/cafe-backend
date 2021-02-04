package com.example.cafebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import com.example.cafebackend.pojos.Coffees;

/*
TODO:
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
    @CrossOrigin(origins = "http://localhost:4200")
class CoffeesController {
    
    private List<Coffees> coffees = createList();

    private List<Coffees> createList() {
        List<Coffees> list = new ArrayList<>();
        list.add(new Coffees("Mocha", 1));
        list.add(new Coffees("Cappucino", 2));
        list.add(new Coffees("Americano", 3));
        list.add(new Coffees("Latte", 4));
        list.add(new Coffees("Drip", 5));
        list.add(new Coffees("Frappucino", 6));
        list.add(new Coffees("Green Tea Latte", 7));
        list.add(new Coffees("Espresso", 8));
        list.add(new Coffees("Caramel Macchiato", 9));
        list.add(new Coffees("Cold Brew", 9));
        list.add(new Coffees("Chai Latte", 10));

        return list;
    }

    @GetMapping(value = "/coffees", produces = "application/json")
    public List<Coffees> getCoffees() {
        return coffees;
    }
}

}
