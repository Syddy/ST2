package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Konto;
import com.example.entities.Rezept;

/**
 * Interface for CRUD operations on a Rezept repository
 */
public interface RezeptRepository extends CrudRepository<Rezept, Long> {
    Rezept findByName(String name); 
}