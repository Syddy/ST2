package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Speisekarte {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@OneToMany(mappedBy = "speisekarteneintrag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Speisekarteneintrag> speisekarteneintrag = new HashSet<>();
    
	private String name;
    
	//needed for JPA
    protected Speisekarte() {
	
    }
    
    public Speisekarte(String name, Set<Speisekarteneintrag> speisekarteneintrag){
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
