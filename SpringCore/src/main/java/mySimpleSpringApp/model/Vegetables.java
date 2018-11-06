package mySimpleSpringApp.model;

public class Vegetables {
	
	String vegName;
	
	public Vegetables() {
		
	}
	public Vegetables(String vegName) {
		this.vegName = vegName;
	}
	
	public String getVegName() {
		return vegName;
	}



	public void setVegName(String vegName) {
		this.vegName = vegName;
	}



	public String introduceYourself() {
		String introduction="Hi. I am from Vegetables class.";
		
		if(this.vegName!=null  && this.vegName!="")
			introduction += " My name is "+vegName;
		
		return introduction;
	}

}
