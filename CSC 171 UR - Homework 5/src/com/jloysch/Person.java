package com.jloysch;

public class Person {
	
	private String NAME, PHONE_NUMBER;
	private int AGE;
	
	
	public Person() {
		this.NAME = "NAME NOT GIVEN";
		this.AGE = 0;
		this.PHONE_NUMBER = "0000000000";
	}
	
	public Person(String NAME, int AGE, String PHONE_NUMBER) {
		this.NAME = NAME;
		this.AGE = AGE;
		this.PHONE_NUMBER = PHONE_NUMBER;
	}
	
	public Person(String NAME, int AGE) {
		this.NAME = NAME;
		this.AGE = AGE;
	}
	
	public Person(String NAME) {
		this.NAME = NAME;
	}
	
	public int getAge() {
		return this.AGE;
	}

	public String getPhoneNumber() {
		return this.PHONE_NUMBER;
	}
	
	public String getName() {
		return this.NAME;
	}
	
	public void setAge(int AGE) {
		this.AGE = AGE;
	}
	
	public void setName(String NAME) {
		this.NAME = NAME;
	}
	
	public void setPhoneNumber(String PHONE_NUMBER) {
		this.PHONE_NUMBER = PHONE_NUMBER;
	}
	
	@Override
	public String toString() {
		return "Person Name\t> " + this.NAME + "\nPhone Number\t> " + this.PHONE_NUMBER + "\nAge\t\t> " + this.AGE;
	}
}
