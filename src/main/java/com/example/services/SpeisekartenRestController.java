package com.example.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Kunde;
import com.example.entities.Speisekarteneintrag;
import com.example.repositories.SpeisekarteneintragRepository;

@RestController
@RequestMapping("/speisekarteneintrag")
public class SpeisekartenRestController {


	        @Autowired
	        private SpeisekarteneintragRepository repository;

	        @RequestMapping(method = RequestMethod.GET)
	        public List<Speisekarteneintrag> getAllSpeisekarteneintraege(){
	            return (List<Speisekarteneintrag>) repository.findAll();
	        }
	        
	        
//	        @RequestMapping(method = RequestMethod.GET)
//	        public ResponseEntity<Collection<Speisekarteneintrag>> getAllPies(){
//	            return new ResponseEntity<>((Collection<Speisekarteneintrag>) repository.findAll(), HttpStatus.OK);
//	        }
	        
	        

	        @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	        public ResponseEntity<Speisekarteneintrag> getWithId(@PathVariable Long id) {
	            return new ResponseEntity<>(repository.findById(id),HttpStatus.OK);
	        }
	        
	        @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	        public ResponseEntity<Speisekarteneintrag> deleteWithId(@PathVariable Long id) {
	            return new ResponseEntity<>(repository.findById(id),HttpStatus.OK);
	        }
	        
	        @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	        public ResponseEntity<Speisekarteneintrag> createWithId(@PathVariable Long id) {
	            return new ResponseEntity<>(repository.findById(id),HttpStatus.OK);
	        }
	        
	        

//	        @RequestMapping(method = RequestMethod.GET, params = {"name"})
//	        public ResponseEntity<Collection<Pie>> findPieWithName(@RequestParam(value="name") String name) {
//	            return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
//	        }
//
//	        @RequestMapping(method = RequestMethod.POST)
//	        public ResponseEntity<?> addPie(@RequestBody Pie input) {
//	            return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
//	        }
}

