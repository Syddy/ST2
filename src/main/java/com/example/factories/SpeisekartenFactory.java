package com.example.factories;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.entities.Bild;
import com.example.entities.Rezept; 
import com.example.entities.Speisekarte;
import com.example.entities.Speisekarteneintrag;

@Component
public class SpeisekartenFactory {
	
    public SpeisekartenFactory() {}
    
	public Speisekarte createSpeisekarte(String name) {
		Speisekarte karte = new Speisekarte(name);
		
		Set<Speisekarteneintrag> eintraege = new HashSet<>();
		eintraege.add(new Speisekarteneintrag(5.50f, new Rezept("Kartoffelbrei", "Man nehme ..."), new Bild(12345l)));
		eintraege.add(new Speisekarteneintrag(6.20f, new Rezept("Nudelsalat", "200g Tomaten.. "), new Bild(54321l)));
		eintraege.add(new Speisekarteneintrag(13.30f, new Rezept("Luftkottlet", "abcdefgh.."), new Bild(44434l)));
		karte.setEintraege(eintraege);
		
		return karte;
	}
}
