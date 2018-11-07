package mySimpleSpringApp.model;

public class Apple extends Fruit{

	private String name;
	private String definition;
	

	public String introduceYourself() {
		String introYouself = super.introduceYourself();
		
		if(definition!=null) introYouself+=" "+definition;
		
		return introYouself;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
