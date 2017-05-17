package com.example.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Bild {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    private Speisekarteneintrag speisekarteneintrag;
    
	//needed for JPA
    protected Bild() {
	
    }
    
    public Bild(Speisekarteneintrag speisekarteneintrag){
    	this.speisekarteneintrag = speisekarteneintrag;
    }

}
