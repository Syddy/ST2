package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Speisekarte {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
      
	@OneToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JsonManagedReference
    private Set<Speisekarteneintrag> eintraege = new HashSet<>();
     
	private String name;
     
	//needed for JPA
    protected Speisekarte() {
	
    }
    
    public Speisekarte(String name){
    	this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name; 
	} 
	
	public Set<Speisekarteneintrag> getEintraege() {
		return eintraege;
	}
 
	public void setEintraege(Set<Speisekarteneintrag> eintraege) {
		this.eintraege = eintraege;
	}
	
	@Override
	public String toString(){
		String s =  "Speisekarte: ID:" + id + ", Name: " + name + "\n";
		for(Speisekarteneintrag e : eintraege){
			s += "\t" + e.toString() + "\n";
		}
		return s;
	}
}