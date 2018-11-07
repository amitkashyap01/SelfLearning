package mySimpleSpringApp.model;

public class Meat {

	private String description;

	
	
	public String introduceYourself() {
		return description;
	}
	
	public void initMethod() {
		System.out.println("From Meat Init Method. Description is: "+description);
	}
	
	public void destroyMethod() {
		System.out.println("From Destroy method of Meat");
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
