package com.jloysch;

public class HomeworkFiveDriver {
	
	public static void main(String args[]) {
		
		Person a = new Person("Jack");
		Person b = new Person("NotJack");
		
		Element w = new Element("THULIUM", "Th", 69, 164.934);
		Element x = new Element("HYDROGEN", "H", 1, 1.00784);
		Element y = new Element("LITHIUM", "Li", 3, 6.941);
		Element z = new Element("OXYGEN", "O", 16, 15.999);
		
		Animal dog = new Animal("Dog", "Jack-Terrier");
		Animal cat = new Animal("Cat");
		Animal sugar_glider = new Animal("Sugar Glider");
		
		dog.setNickname("Spot");

		System.out.println(a + "\n");
		System.out.println(b + "\n");
		
		System.out.println(w + "\n");
		System.out.println(x + "\n");
		System.out.println(y + "\n");
		System.out.println(z + "\n");
		
		System.out.println(dog + "\n");
		
		dog.speak(true);
		
		System.out.println("\n" + cat + "\n");
		
		cat.speak(true);
		
		sugar_glider.speak(true);
		
	}

}
