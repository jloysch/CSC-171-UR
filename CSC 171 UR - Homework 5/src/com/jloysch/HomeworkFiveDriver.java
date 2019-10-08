package com.jloysch;

public class HomeworkFiveDriver {
	
	public static void main(String args[]) {
		
		Person a = new Person("Jack");
		Person b = new Person("NotJack");
		
		a.setAge(30);
		b.setAge(40);
		
		a.setPhoneNumber("5705152800");
		b.setPhoneNumber("5153003030");
		
		Element w = new Element("THULIUM", "Th", 69);
		Element x = new Element("HYDROGEN", "H", 1, 1.00784);
		Element y = new Element("LITHIUM", "Li", 3);
		Element z = new Element("OXYGEN", "O", 16, 15.999);
		
<<<<<<< Upstream, based on origin/master
		Animal dog = new Animal("Dog", "Jack-Terrier");
		Animal cat = new Animal("Cat");
		Animal sugar_glider = new Animal("Sugar Glider");
=======
		w.setAtomicWeight(169.934);
		//x.setAtomicWeight(1.00784);
		y.setAtomicWeight(6.491);
		//z.setAtomicWeight(15.999);
		
		Animal dog = new Animal("DOG", "Jack-Terrier");
		Animal cat = new Animal("CAT");
>>>>>>> 3418824 Initial Commit
		
<<<<<<< Upstream, based on origin/master
		dog.setNickname("Spot");

=======
		cat.setBreed("Tabby");
		
		//Person Object
>>>>>>> 3418824 Initial Commit
		System.out.println(a + "\n");
		System.out.println(b + "\n");
		
		//Some elements
		System.out.println(w + "\n");
		System.out.println(x + "\n");
		System.out.println(y + "\n");
		System.out.println(z + "\n");
		
		//Animals
		System.out.println(dog + "\n");
		
<<<<<<< Upstream, based on origin/master
		dog.speak(true);
		
		System.out.println("\n" + cat + "\n");
		
		cat.speak(true);
		
		sugar_glider.speak(true);
		
=======
>>>>>>> 3418824 Initial Commit
	}

}
