package com.example.factories;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entities.Bild;
import com.example.entities.Rezept;
import com.example.entities.Speisekarte;
import com.example.entities.Speisekarteneintrag;
import com.example.repositories.RezeptRepository;

@Component
public class SpeisekartenFactory {
	@Autowired
	private RezeptRepository rRepo;
	
    public SpeisekartenFactory() {}
    
	public Speisekarte createSpeisekarte(String name) {
		Speisekarte karte = new Speisekarte(name);		
		Set<Speisekarteneintrag> eintraege = new HashSet<>();
		
		{
			Set<Rezept> rezepte = new HashSet<>();
			rezepte.add(new Rezept("Kartoffelbrei", "Man nehme ..."));
			rezepte.add(new Rezept("Blumenkohl-Schnitzel", "1KG Blumenkohl..."));
			eintraege.add(new Speisekarteneintrag(15.50f, rezepte, new Bild(12345l)));
			rRepo.save(rezepte);  
		}
		{
			Set<Rezept> rezepte = new HashSet<>();
			rezepte.add(new Rezept("Nudelsalat", "200g Tomaten.. "));
			eintraege.add(new Speisekarteneintrag(6.20f, rezepte, new Bild(54321l)));
			rRepo.save(rezepte);
		}
		{
			Set<Rezept> rezepte = new HashSet<>();
			rezepte.add(new Rezept("Luftkottlet", "abcdefgh.."));
			rezepte.add(new Rezept("NebelsoÃŸe", "zyxwvu.."));
			eintraege.add(new Speisekarteneintrag(13.30f, rezepte, new Bild(44434l)));
			rRepo.save(rezepte);
		}
		karte.setEintraege(eintraege);
		
		return karte;
	}
	
	public Speisekarte updateSpeisekarte(Speisekarte karte, Set<Speisekarteneintrag> eintraege) {
		Speisekarte fertigeKarte = null;
		karte.setEintraege(eintraege);
		fertigeKarte = karte;
		return fertigeKarte;
	}
}
