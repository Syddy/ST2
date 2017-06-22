package com.example.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Rezept> rezepte; 
	
    @Embedded
    private Bild bild;
     
	private float preis; 
	//needed for JPA
    protected Speisekarteneintrag() {
	
    }
    
    public Speisekarteneintrag(float preis, Rezept rezept, Bild bild){
    	this.preis = preis;
    	this.rezepte = new HashSet<>();
    	this.rezepte.add(rezept);
    	this.bild = bild;
    }
    
    public Speisekarteneintrag(float preis, Set<Rezept> rezept, Bild bild){
    	this.preis = preis;
    	this.rezepte = rezept; 
    	this.bild = bild;
    }

	public float getPreis() {
		return preis;
	}
	 
	public Set<Rezept> getRezept() {
		return rezepte;
	}
	public void setRezept(Set<Rezept> rezept){
		this.rezepte= rezept;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	} 
	 
	public Speisekarte getSpeisekarte() {
		return speisekarte; 
	} 
	
	@Override
	public String toString() {
    	return "Eintrag: ID: " + id + ", Preis: " + preis + ", Rezepte: " + rezepte.stream().map(r -> r.getName()).collect(Collectors.joining(", ")); 
    }

}
