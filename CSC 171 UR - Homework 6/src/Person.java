public class Person {
	
	private String NAME, GREETING_MESSAGE;
	private int AGE, PHONE_NUMBER;
	
	
	public Person() {
		this.NAME = "NAME NOT GIVEN";
		this.AGE = 0;
		this.PHONE_NUMBER = 0000000000;
		this.GREETING_MESSAGE = "Hello.";
	}
	
	public Person(String NAME, int AGE, int PHONE_NUMBER, String GREETING_MESSAGE) {
		this.NAME = NAME;
		this.AGE = AGE;
		this.PHONE_NUMBER = PHONE_NUMBER;
		this.GREETING_MESSAGE = GREETING_MESSAGE;
	}
	
	public Person(String NAME, int AGE, String GREETING_MESSAGE) {
		this.NAME = NAME;
		this.AGE = AGE;
		this.GREETING_MESSAGE = GREETING_MESSAGE;
	}
	
	public Person(String NAME) {
		this.NAME = NAME;
	}
	
	public int getAge() {
		return this.AGE;
	}

	public int getPhoneNumber() {
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
	
	public void setPhoneNumber(int PHONE_NUMBER) {
		this.PHONE_NUMBER = PHONE_NUMBER;
	}
	
	public void setGreeting(String GREETING_MESSAGE) {
		this.GREETING_MESSAGE = GREETING_MESSAGE;
	}
	
	public String greeting() {
		return this.GREETING_MESSAGE;
	}
	
	@Override
	public String toString() {
		return "Person Name\t> " + this.NAME + "\nPhone Number\t> " + this.PHONE_NUMBER + "\nAge\t\t> " + this.AGE;
	}
}
