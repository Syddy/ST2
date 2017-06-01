package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entities.Speisekarte;
import com.example.factories.KundeFactory;
import com.example.factories.SpeisekarteneintragFactory;
import com.example.repositories.KundeRepository;
import com.example.repositories.SpeisekarteRepository;
import com.example.repositories.SpeisekarteneintragRepository;

@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {  
    
    @Autowired
    private KundeRepository kundeRepository; 
    @Autowired
    private SpeisekarteneintragRepository speisekarteneintragRepo; 
    @Autowired
    private SpeisekarteRepository speisekarteRepo; 
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
 
    	Speisekarte speisekarte = new Speisekarte("Delicious");
    	speisekarteRepo.save(speisekarte);
    	
    	kundeRepository.save(new KundeFactory().createKunde("Mustermann", "Max"));

    	speisekarteneintragRepo.save(new SpeisekarteneintragFactory().createSpeisekarteneintrag("Gullasch", "Kochen", (long)234453425, (float)33.3, speisekarte));
    	
    	System.out.println(kundeRepository.findByName("Mustermann").toString());
    	System.out.println(speisekarteRepo.findByName("Delicious").toString());
    	System.out.println(speisekarteneintragRepo.findByPreis((float)33.3).toString());
    }
     

    public SampleData() {
	
    }
    

}
