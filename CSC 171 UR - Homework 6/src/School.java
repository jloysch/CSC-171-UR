
public class School {
	
	private boolean PRIVATE_SCHOOL;
	private String SCHOOL_NAME;
	
	public School() {
		this.PRIVATE_SCHOOL = false;
		this.SCHOOL_NAME = null;
	}
	
	public School(String SCHOOL_NAME, boolean PRIVATE) {
		this.SCHOOL_NAME = SCHOOL_NAME;
		this.PRIVATE_SCHOOL = PRIVATE;
	}
	
	public String getName() {
		return this.SCHOOL_NAME;
	}
	
	public boolean isPrivate() {
		return this.PRIVATE_SCHOOL;
	}
	

}
