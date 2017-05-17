package com.example.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Rezept {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToOne
	private Speisekarteneintrag speisekarteneintrag;
	
    private String name;
    
    private String zubereitungsanweisung;
    
	//needed for JPA
    protected Rezept() {
	
    }
    
    public Rezept(String name, String zubereitungsanweisung, Speisekarteneintrag speisekarteneintrag){
    	this.name = name;
    	this.zubereitungsanweisung = zubereitungsanweisung;
    	this.speisekarteneintrag = speisekarteneintrag;
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
    
}
