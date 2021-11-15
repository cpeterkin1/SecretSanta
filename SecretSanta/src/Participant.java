/**
 * 
 */

/**
 * @author Chris
 * @date 9/2/21
 *
 * @description The participant object class for Secret Santa participants
 * 
 */

public class Participant {
	private String name;
	private boolean isAssigned;
	
	public Participant(String name) {
		this.name = name;
		this.isAssigned = false;
	}
	
	public void setAssigned() {
		this.isAssigned=true;
	}
	
	public String getName() {
		return this.name;
	}
}
