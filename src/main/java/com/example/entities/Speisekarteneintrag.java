package com.example.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Speisekarteneintrag {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER) 
    private Speisekarte speisekarte;
    
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Rezept rezept; 
	
    @Embedded
    private Bild bild;
     
	private float preis; 
	//needed for JPA
    protected Speisekarteneintrag() {
	
    }
    
    public Speisekarteneintrag(float preis, Rezept rezept, Bild bild){
    	this.preis = preis;
    	this.rezept = rezept; 
    	this.bild = bild;
    }

	public float getPreis() {
		return preis;
	}
	 
	public Rezept getRezept() {
		return rezept;
	}
	public void setRezept(Rezept rezept){
		this.rezept= rezept;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	} 
	 
	public Speisekarte getSpeisekarte() {
		return speisekarte; 
	} 
	
	@Override
	public String toString() {
    	return "Eintrag: ID: " + id + ", Preis: " + preis + ", Rezept: " + rezept.getName(); 
    }

}
