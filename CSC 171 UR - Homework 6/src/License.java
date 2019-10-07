/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 6
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

import java.util.GregorianCalendar;
import java.util.Calendar;

public class License {
	
	private int LICENSE_NUMBER;
	private Calendar EXPIRATION_DATE;
	private boolean EXPIRED;
	
	public License() {	
		this.LICENSE_NUMBER = 0;
		this.initDates();
	}
	
	public License(String STATE_OF_RESIDENCE, int ID_NUMBER) {
		this.LICENSE_NUMBER = ID_NUMBER;
		this.initDates();
	}

	public String getExpirationDate() {
		return this.EXPIRATION_DATE.get(Calendar.MONTH) + "\\" + this.EXPIRATION_DATE.get(Calendar.DATE) + "\\" + this.EXPIRATION_DATE.get(Calendar.YEAR);
	}
	
	private void initDates() {
		this.EXPIRATION_DATE = new GregorianCalendar(1812, Calendar.OCTOBER, 31);
		checkExpiration();
	}
	
	private void checkExpiration() {
		if (Calendar.getInstance().after(this.EXPIRATION_DATE)) {
			this.EXPIRED = true;
		} else {
			this.EXPIRED = false;
		}
	}
	
	public boolean isExpired() {
		return this.EXPIRED;
	}
	
	public void setExpirationDate(int YEAR, int MONTH, int DAY) {
		this.EXPIRATION_DATE.set(YEAR, MONTH, DAY);
	}
	
	public boolean equals(License l) {
		if ((l.toString().equalsIgnoreCase(this.toString()))) {
			return true;
		} else {
			return false;
		}
	}
	
	public String[] getLicenseStats() {
		return new String[] {String.valueOf(this.LICENSE_NUMBER),String.valueOf(this.EXPIRED), this.getExpirationDate()};
	}
	
	@Override
	public String toString() {
		return "[License Info]\n" + "License Number\t\t>> " + this.LICENSE_NUMBER + "\nExpiration Date\t\t>> " + this.getExpirationDate() + "\nExpired?\t\t>> " + this.EXPIRED;
	}
	
}
