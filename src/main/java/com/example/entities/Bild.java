package com.example.entities;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Bild {
    private long base64;
    
	//needed for JPA
    protected Bild() {
    	
    }
    
    public Bild(long base64) { 
    	this.base64 = base64;
    }
}
