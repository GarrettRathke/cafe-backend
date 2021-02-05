package com.example.cafebackend.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import com.example.cafebackend.pojos.Coffees;
import com.example.cafebackend.repository.CoffeesRepository;

@Service
public class CoffeeService {
    
    @Autowired
    CoffeesRepository coffeesRepository;

    public List<Coffees> getAllCoffees() {
        List<Coffees> coffees = new ArrayList<>();
        coffeesRepository.findAll().forEach(coffee -> coffees.add(coffee));
        return coffees;
    }

    public Coffees getCoffeeById(int id) {
        return coffeesRepository.findById(id).get();
    }

    public void saveOrUpdate(Coffees coffee) {
        coffeesRepository.save(coffee);
    }

    public void delete(int id) {
        coffeesRepository.deleteById(id);
    }

}
