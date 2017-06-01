package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Speisekarteneintrag;

/**
 * Interface for CRUD operations on a Speisekarteneintrag  repository
 */
public interface SpeisekarteneintragRepository extends CrudRepository<Speisekarteneintrag , Long> {
	Speisekarteneintrag findById(Long id);  
	Speisekarteneintrag findByPreis(float preis);
}