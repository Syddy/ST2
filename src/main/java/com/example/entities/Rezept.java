package com.example.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rezept {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     
	@ManyToMany(mappedBy = "rezepte", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Speisekarteneintrag> speisekarteneintrag;
	
    private String name; 
    
    private String zubereitungsanweisung;
    
	//needed for JPA
    protected Rezept() {
	
    }
    
    public Rezept(String name, String zubereitungsanweisung){
    	this.name = name; 
    	this.zubereitungsanweisung = zubereitungsanweisung;
    }
     
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZubereitungsanweisung() {
		return zubereitungsanweisung;
	}

	public void setZubereitungsanweisung(String zubereitungsanweisung) {
		this.zubereitungsanweisung = zubereitungsanweisung;
	}
	
	public Set<Speisekarteneintrag> getSpeisekarteneintrag() {
		return speisekarteneintrag;
	}

	public void setSpeisekarteneintrag(Set<Speisekarteneintrag> speisekarteneintrag) {
		this.speisekarteneintrag = speisekarteneintrag;
	}
	
	@Override
	public String toString(){
		return "Rezept: ID: " + id + ", Name: " + name + "\n Zubereitung: " + zubereitungsanweisung;
	}
    
}
