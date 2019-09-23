package com.jloysch;

public class Animal {
	
	private String NAME, BREED, STRUNG = "";
	
	public Animal() {
		this.NAME="!Assigned";
		this.BREED = "!Assigned";
	}
	
	public Animal(String NAME) {
		this.NAME = NAME;
		this.BREED = "!Assigned";
	}
	
	public Animal(String NAME, String BREED) {
		this.NAME = NAME;
		this.BREED = BREED;
	}
	
	public String speak() { //Just something simple
		if (this.NAME.equalsIgnoreCase("DOG")) {
			return "Bark bark!";
		} else if (this.NAME.equalsIgnoreCase("CAT")) {
			return "Meow!";
		} else {
			return "This animal doesn't want to talk right now.";
		}
	}
	
	@Override
	public String toString() {
		if (this.STRUNG == "") {
			if (!(this.BREED.equalsIgnoreCase("!Assigned"))) {
				this.STRUNG = "You have a beautiful " + this.NAME + ", which is a " + this.BREED + " breed.";
				return this.STRUNG;
			} else {
				this.STRUNG = "You have a beautiful " + this.NAME + " with an unknown breed.";
				return this.STRUNG;
			}
		} else {
			return this.STRUNG;
		}
		
	}
	
}
