package com.example.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Speisekarteneintrag {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToMany
	private Speisekarte speisekarte;
    
	@OneToOne
	private Rezept rezept;
	
    @OneToMany
    private Bild bild;
    
	private float preis;
    
	//needed for JPA
    protected Speisekarteneintrag() {
	
    }
    
    public Speisekarteneintrag(int preis, Rezept rezept, Bild bild, Speisekarte speisekarte){
    	this.preis = preis;
    	this.rezept = rezept;
    	this.bild = bild;
    	this.speisekarte = speisekarte;
    }

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}
    
}
