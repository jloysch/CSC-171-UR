
public class Student extends Person {
	
	private int ID_NUMBER;
	private String SCHOOL_NAME, MAJOR;
	
	public Student() {
		super();
		this.ID_NUMBER = 0;
		this.SCHOOL_NAME = "NOT YET SET";
		this.MAJOR = "NOT YET SET";
	}
	
	public Student(int ID_NUMBER) {
		super();
		this.ID_NUMBER = ID_NUMBER;
		this.SCHOOL_NAME = "NOT YET SET";
		this.MAJOR = "NOT YET SET";
	}
	
	public Student(int ID_NUMBER, String SCHOOL_NAME) {
		super();
		this.ID_NUMBER = ID_NUMBER;
		this.SCHOOL_NAME = SCHOOL_NAME;
		this.MAJOR = "NOT YET SET";
	}
	
	public Student(String SCHOOL_NAME, String MAJOR) {
		super();
		this.SCHOOL_NAME = SCHOOL_NAME;
		this.MAJOR = MAJOR;
		this.ID_NUMBER = 0;
	}
	
	public Student(int ID_NUMBER, String SCHOOL_NAME, String MAJOR) {
		super();
		this.ID_NUMBER = ID_NUMBER;
		this.SCHOOL_NAME = SCHOOL_NAME;
		this.MAJOR = MAJOR;
	}
	
	public int getIdNumber() {
		return this.ID_NUMBER;
	}
	
	public String getSchoolName() {
		return this.SCHOOL_NAME;
	}
	
	public String getMajor() {
		return this.MAJOR;
	}
	
	public void setMajor(String MAJOR) {
		this.MAJOR = MAJOR;
	}
	
	public void setSchoolName(String SCHOOL_NAME) {
		this.SCHOOL_NAME = SCHOOL_NAME;
	}
	
	public void setIdNumber(int ID_NUMBER) {
		this.ID_NUMBER = ID_NUMBER;
	}
	
	@Override
	public String greeting() {
		if (MAJOR.equalsIgnoreCase("Computer Science")) {
			return "Greetings, Earthling!";
		} else {
			return "Hey.";
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nMajor\t\t> " + this.MAJOR + "\nSchool Name\t> " + this.SCHOOL_NAME + "\n---\n";
		
	}
	
}
