package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Speisekarte;

/**
 * Interface for CRUD operations on a Speisekarte  repository
 */
public interface SpeisekarteRepository extends CrudRepository<Speisekarte , Long> {
	Speisekarte findByName(String name);
}