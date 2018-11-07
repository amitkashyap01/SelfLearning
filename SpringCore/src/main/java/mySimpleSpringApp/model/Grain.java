package mySimpleSpringApp.model;

public class Grain {
	String definition= "Not Set";
	
	
	public String introduceYouself() {
		return definition;
	}

	/**
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	
}
