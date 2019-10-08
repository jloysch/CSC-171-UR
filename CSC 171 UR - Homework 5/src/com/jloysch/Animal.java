package com.jloysch;

public class Animal {
	
	private String ANIMAL_TYPE, BREED, NICKNAME, STRUNG = "", NULL_MSG = "$#$";
	
	public Animal() {
		this.ANIMAL_TYPE= this.NULL_MSG;
		this.BREED = this.NULL_MSG;
		this.NICKNAME = this.NULL_MSG;
	}
	
	public Animal(String ANIMAL_TYPE) {
		this.ANIMAL_TYPE = ANIMAL_TYPE;
		this.BREED = this.NULL_MSG;
		this.NICKNAME = this.NULL_MSG;
	}
	
	public Animal(String ANIMAL_TYPE, String BREED) {
		this.ANIMAL_TYPE = ANIMAL_TYPE;
		this.BREED = BREED;
	}
	
<<<<<<< Upstream, based on origin/master
	public Animal(String ANIMAL_TYPE, String BREED, String NICKNAME) {
		this.ANIMAL_TYPE = ANIMAL_TYPE;
		this.BREED = BREED;
		this.NICKNAME = NICKNAME;
	}
	
	public String speak(boolean postToConsole) { 
		
		if (postToConsole) {
			if (this.ANIMAL_TYPE.equalsIgnoreCase("DOG")) {
				System.out.println(this.NICKNAME + " says 'Bark bark!'");
				return null;
			} else if (this.ANIMAL_TYPE.equalsIgnoreCase("CAT")) {
				if (!(this.NICKNAME.equalsIgnoreCase(this.NULL_MSG))) {
					System.out.println(this.NICKNAME + " says 'Meow!'");
				} else {
					 System.out.println("Your unnamed cat says 'Meow!'");
				}
				return null;
			} else {
				if (!(this.NICKNAME.equalsIgnoreCase(this.NULL_MSG))) {
					System.out.println(this.NICKNAME + " doesn't want to talk right now.");
				} else {
					System.out.println("Your unnamed " + this.ANIMAL_TYPE + " doesn't want to talk right now.");
				}
				
				
				return null;
			}
=======
	public void setBreed(String BREED) {
		this.BREED = BREED;
	}
	
	public String speak() { //Just something simple
		if (this.NAME.equalsIgnoreCase("DOG")) {
			return "Bark bark!";
		} else if (this.NAME.equalsIgnoreCase("CAT")) {
			return "Meow!";
>>>>>>> 3418824 Initial Commit
		} else {
			if (this.ANIMAL_TYPE.equalsIgnoreCase("DOG")) {
				return this.NICKNAME + " says 'Bark bark!'";
			} else if (this.ANIMAL_TYPE.equalsIgnoreCase("CAT")) {
				
				if (!(this.NICKNAME.equalsIgnoreCase(this.NULL_MSG))) {
					return this.NICKNAME + " says 'Meow!'";
				} else {
					return "Your unnamed cat says 'Meow!'";
				}
				
			} else {
				if (!(this.NICKNAME.equalsIgnoreCase(this.NULL_MSG))) {
					return this.NICKNAME + "' doesn't want to talk right now.'";
				} else {
					return "Your unnamed animal doesn't want to talk right now.";
				}
				
			}
		}
	}
	
	public void setNickname(String NICKNAME) {
		this.NICKNAME = NICKNAME;
		this.STRUNG = "";
	}
	
	public void setAnimal(String ANIMAL_TYPE) {
		this.ANIMAL_TYPE = ANIMAL_TYPE;
	}
	
	@Override
	public String toString() {
		if (this.STRUNG == "") {
			if (!(this.BREED.equalsIgnoreCase(this.NULL_MSG))) {
				this.STRUNG = "You have a beautiful " + this.ANIMAL_TYPE + ", which is a " + this.BREED + " breed. Aptly named " + this.NICKNAME + ".";
				return this.STRUNG;
			} else {
				if (!(this.NICKNAME.equalsIgnoreCase(this.NULL_MSG))) {
					this.STRUNG = "You have a beautiful " + this.ANIMAL_TYPE + " with an unknown breed, but named " + this.NICKNAME + ".";
				} else {
					this.STRUNG = "You have a beautiful " + this.ANIMAL_TYPE + " with an unknown breed, and unknown name.";
				}
				
				return this.STRUNG;
			}
		} else {
			return this.STRUNG;
		}
		
	}
	
}
