package mySimpleSpringApp.model;

public class Meal {
	
	private Fruit fruit;
	private Vegetables vegetables;
	private Grain grain;
	private Meat meat;
	
	// Default Constructor
	
	public Meal() {}
	
	
	
	/**
	 * @param fruit
	 * @param vegetables
	 * @param grain
	 * @param meat
	 */
	public Meal(Fruit fruit, Vegetables vegetables, Grain grain, Meat meat) {
		this.fruit = fruit;
		this.vegetables = vegetables;
		this.grain = grain;
		this.meat = meat;
	}



	/**
	 * @return the grain
	 */
	public Grain getGrain() {
		return grain;
	}



	/**
	 * @param grain the grain to set
	 */
	public void setGrain(Grain grain) {
		this.grain = grain;
	}



	/**
	 * @return the meat
	 */
	public Meat getMeat() {
		return meat;
	}



	/**
	 * @param meat the meat to set
	 */
	public void setMeat(Meat meat) {
		this.meat = meat;
	}



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
			whatsInMeal += fruit.introduceYourself();
		
		if(vegetables!=null)
			whatsInMeal += vegetables.introduceYourself();
		
		if(grain!=null)
			whatsInMeal += grain.introduceYouself();
		
		if(meat!=null)
			whatsInMeal += meat.introduceYourself();
		
		
		
		
		return whatsInMeal;
		
		
	}

}
