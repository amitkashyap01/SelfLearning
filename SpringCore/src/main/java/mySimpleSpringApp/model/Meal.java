package mySimpleSpringApp.model;

public class Meal {
	
	private Fruit fruit;
	private Vegetables vegetables;
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public Vegetables getVegetables() {
		return vegetables;
	}
	public void setVegetables(Vegetables vegetables) {
		this.vegetables = vegetables;
	}
	
	
	public String whatsInMeal() {
		
		String whatsInMeal = "Meal contains: ";
		
		if(fruit!=null)
			whatsInMeal += " some fruits";
		
		if(vegetables!=null)
			whatsInMeal += " some vegetables";
		
		return whatsInMeal;
		
		
	}

}
