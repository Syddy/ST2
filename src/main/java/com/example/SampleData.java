package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entities.Speisekarte;
import com.example.factories.KundeFactory;
import com.example.factories.SpeisekartenFactory;
import com.example.factories.SpeisekarteneintragFactory;
import com.example.repositories.KundeRepository;
import com.example.repositories.SpeisekarteRepository;
import com.example.repositories.SpeisekarteneintragRepository;

@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {  
    
    @Autowired
    private KundeRepository kundeRepo; 
    @Autowired
    private SpeisekarteneintragRepository eintragRepo; 
    @Autowired
    private SpeisekarteRepository kartenRepo;
    @Autowired
    private SpeisekartenFactory kartenFactory;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
 
    	Speisekarte speisekarte = kartenFactory.createSpeisekarte("Delicious");
    	eintragRepo.save(speisekarte.getEintraege());
    	kartenRepo.save(speisekarte);
    	
    	kundeRepo.save(new KundeFactory().createKunde("Mustermann", "Max"));
    	
    	System.out.println(kundeRepo.findByName("Mustermann").toString());
    	System.out.println(kartenRepo.findByName("Delicious").toString());
    }
     

    public SampleData() {
	
    }
    

}
