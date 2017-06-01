package com.example.factories;

import org.springframework.stereotype.Component;

import com.example.entities.Bild;
import com.example.entities.Konto;
import com.example.entities.Kunde;
import com.example.entities.Rezept; 
import com.example.entities.Speisekarte;
import com.example.entities.Speisekarteneintrag;

@Component
public class SpeisekarteneintragFactory {
	
    public SpeisekarteneintragFactory() {}
    
	public Speisekarteneintrag createSpeisekarteneintrag(String name, String zubereitung, long base64, float preis, Speisekarte speisekarte ) {
		
		Rezept rezept = new Rezept(name, zubereitung);
		Bild bild = new Bild(base64);
				
		Speisekarteneintrag speisekarteneintrag = new Speisekarteneintrag(preis, rezept, bild);
		
		speisekarteneintrag.getSpeisekarte().add(speisekarte);
		speisekarteneintrag.setRezept(rezept);
		
		speisekarte.getEintraege().add(speisekarteneintrag);
		 
		return speisekarteneintrag;
	}
}
