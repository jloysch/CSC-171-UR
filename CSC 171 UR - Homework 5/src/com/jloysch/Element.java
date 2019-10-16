package com.jloysch;

public class Element {
	
	private String ELEMENT_NAME, ATOMIC_SYMBOL;
	private int ATOMIC_NUMBER;
	private double ATOMIC_WEIGHT;
	
	public Element() {
		this.ELEMENT_NAME = "!Assigned";
		this.ATOMIC_SYMBOL = "!Assigned";
		this.ATOMIC_NUMBER = 0;
		this.ATOMIC_WEIGHT = 0;
	}
	
	public Element(String ELEMENT_NAME) {
		this.ELEMENT_NAME = ELEMENT_NAME;
		this.ATOMIC_SYMBOL="???";
		this.ATOMIC_NUMBER=0;
		this.ATOMIC_WEIGHT=0;
	}
	
	public Element(String ELEMENT_NAME, String ATOMIC_SYMBOL) {
		this.ELEMENT_NAME = ELEMENT_NAME;
		this.ATOMIC_SYMBOL = ATOMIC_SYMBOL;
		this.ATOMIC_NUMBER=0;
		this.ATOMIC_WEIGHT=0;
	}
	
	public Element(String ELEMENT_NAME, String ATOMIC_SYMBOL, int ATOMIC_NUMBER) {
		this.ELEMENT_NAME = ELEMENT_NAME;
		this.ATOMIC_SYMBOL = ATOMIC_SYMBOL;
		this.ATOMIC_NUMBER = ATOMIC_NUMBER;
	}
	
	public Element(String ELEMENT_NAME, String ATOMIC_SYMBOL, int ATOMIC_NUMBER, double ATOMIC_WEIGHT) {
		this.ELEMENT_NAME = ELEMENT_NAME;
		this.ATOMIC_SYMBOL = ATOMIC_SYMBOL;
		this.ATOMIC_NUMBER = ATOMIC_NUMBER;
		this.ATOMIC_WEIGHT = ATOMIC_WEIGHT;
	}
	
	public String getElementName() {
		return this.ELEMENT_NAME;
	}
	
	public String ATOMIC_SYMBOL() {
		return this.ATOMIC_SYMBOL;
	}
	
	public int getAtomicNumber() {
		return this.ATOMIC_NUMBER;
	}
	
	public double getAtomicWeight() {
		return this.ATOMIC_WEIGHT;
	}
	
	public void setElementName(String ELEMENT_NAME) {
		this.ELEMENT_NAME = ELEMENT_NAME;
	}
	
	public void setAtomicNumber(int ATOMIC_NUMBER) {
		this.ATOMIC_NUMBER = ATOMIC_NUMBER;
	}
	
	public void setAtomicWeight(double ATOMIC_WEIGHT) {
		this.ATOMIC_WEIGHT = ATOMIC_WEIGHT;
	}
	
	@Override
	public String toString() {
		return "| " + this.ELEMENT_NAME + " | Atomic Symbol > " + this.ATOMIC_SYMBOL 
				+ " < |\n\t>> Atomic Number is: " + this.ATOMIC_NUMBER + " and Atomic Weight: " + this.ATOMIC_WEIGHT + " <<";
	}

}
