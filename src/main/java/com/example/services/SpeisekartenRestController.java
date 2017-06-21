package com.example.services;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entities.Bild;
import com.example.entities.Kunde;
import com.example.entities.Rezept;
import com.example.entities.Speisekarte;
import com.example.entities.Speisekarteneintrag;
import com.example.factories.KundeFactory;
import com.example.factories.SpeisekartenFactory;
import com.example.repositories.SpeisekarteRepository;
import com.example.repositories.SpeisekarteneintragRepository;

@RestController
@RequestMapping("/speisekarteneintrag")
public class SpeisekartenRestController {


	        @Autowired
	        private SpeisekarteneintragRepository repositoryEintrag;
	        
	        @Autowired
	        private SpeisekarteRepository repositoryKarte;

	        @RequestMapping(method = RequestMethod.GET)
	        public List<Speisekarteneintrag> getAllSpeisekarteneintraege(){
	            return (List<Speisekarteneintrag>) repositoryEintrag.findAll();
	        }
	        
	        
//	        @RequestMapping(method = RequestMethod.GET)
//	        public ResponseEntity<Collection<Speisekarteneintrag>> getAllPies(){
//	            return new ResponseEntity<>((Collection<Speisekarteneintrag>) repository.findAll(), HttpStatus.OK);
//	        }
	        
	        

	        @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	        public ResponseEntity<Speisekarteneintrag> getWithId(@PathVariable Long id) {
	            return new ResponseEntity<>(repositoryEintrag.findById(id),HttpStatus.OK);
	        }
	        
	        @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	        public ResponseEntity<Speisekarteneintrag> deleteWithId(@PathVariable Long id) {
	        	Speisekarte targetKarte = repositoryKarte.findByName("Delicious");
	        	Set<Speisekarteneintrag> temporaryEintraege = targetKarte.getEintraege();
	        	Speisekarteneintrag zuloeschnenderEintrage = repositoryEintrag.findById(id);
	        	temporaryEintraege.remove(zuloeschnenderEintrage);
	        	repositoryKarte.save(new SpeisekartenFactory().updateSpeisekarte(targetKarte, temporaryEintraege));
	        	
	        	if(repositoryEintrag.exists(id)) {
	        		repositoryEintrag.delete(id);
	        	}
	        	return new ResponseEntity<>(repositoryEintrag.findById(id),HttpStatus.OK);
	        }
	        
//	        @RequestMapping(method = RequestMethod.POST)
//	        public ResponseEntity <?> persistPerson(
//	        		@RequestParam("preis") float preis, @RequestParam("rezept") Rezept rezept,@RequestParam("bild") Bild bild, @RequestParam("speisekarte") String speisekarte)
//	        {
//	        	Speisekarte targetKarte = repositoryKarte.findByName(speisekarte);
//	        	Set<Speisekarteneintrag> temporaryEintraege = targetKarte.getEintraege();
//	        	Speisekarteneintrag neuerEintrag = new Speisekarteneintrag(preis, rezept, bild);
//	        	temporaryEintraege.add(neuerEintrag);
//	        	
//	        	return new ResponseEntity<>(repositoryEintrag.findByPreis(preis),HttpStatus.OK);
//	        }
	        
	        @RequestMapping(method = RequestMethod.POST, consumes="application/json")
	        
	        public ResponseEntity <?> persistPerson(@RequestBody String jsonBody) throws JSONException
	        {
	        	System.out.println(jsonBody);
	        	
	        	JSONObject jayson = new JSONObject(jsonBody);
	        	
	        	float preis = (float) jayson.getDouble("preis");
				String rezeptName = jayson.getString("rezeptName");
				String rezeptBeschreibung = jayson.getString("rezeptBeschreibung");
				long base64 = jayson.getLong("base64");
				String speisekarte = jayson.getString("speisekarte");
				
				Rezept rezept = new Rezept(rezeptName, rezeptBeschreibung);
				Bild bild = new Bild(base64);
	        	
	        	Speisekarte targetKarte = repositoryKarte.findByName(speisekarte);
	        	Set<Speisekarteneintrag> temporaryEintraege = targetKarte.getEintraege();
	        	Speisekarteneintrag neuerEintrag = new Speisekarteneintrag(preis, rezept, bild);
	        	temporaryEintraege.add(neuerEintrag);
	        	
	        	repositoryKarte.save(new SpeisekartenFactory().updateSpeisekarte(targetKarte, temporaryEintraege));
	        	
	        	return new ResponseEntity<>("OK",HttpStatus.OK);
	        }
	        
}

