package com.example.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Speisekarte {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToMany
    private Speisekarteneintrag speisekarteneintrag;
    
	private String name;
    
	//needed for JPA
    protected Speisekarte() {
	
    }
    
    public Speisekarte(String name, Speisekarteneintrag speisekarteneintrag){
    	this.name = name;
    	this.speisekarteneintrag = speisekarteneintrag;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
