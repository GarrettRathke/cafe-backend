package com.example.cafebackend.repository;

import org.springframework.data.repository.CrudRepository;  
import com.example.cafebackend.pojos.Coffees;

public interface CoffeesRepository extends CrudRepository<Coffees, Integer> {
    
}
