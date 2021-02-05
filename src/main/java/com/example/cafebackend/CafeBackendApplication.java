package com.example.cafebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.example.cafebackend.pojos.Coffees;
import com.example.cafebackend.service.CoffeeService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class CafeBackendApplication {

	public static void main(String[] args) {
        SpringApplication.run(CafeBackendApplication.class, args);
        
        // populate w/ test data

	}

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
class CoffeesController {
    
    @Autowired
    CoffeeService coffeeService;

    @GetMapping(value = "/coffees", produces = "application/json")
    public List<Coffees> getCoffees() {
        return coffeeService.getAllCoffees();
    }

    @GetMapping(value = "/coffee/{id}", produces = "application/json")
    public Coffees getCoffee(@PathVariable("id") int id) {
        return coffeeService.getCoffeeById(id);
    }

    @DeleteMapping(value = "/coffee/{id}", produces = "application/json")
    public void deleteCoffee(@PathVariable("id") int id) {
        coffeeService.delete(id);
    }

    @PostMapping(value = "/coffee", produces = "application/json")
    public void saveCoffee(@RequestBody Coffees coffee) {
        coffeeService.saveOrUpdate(coffee);
    }
}

}
