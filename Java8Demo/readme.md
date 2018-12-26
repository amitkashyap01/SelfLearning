#Java 8

### Default Method
* In Java 8, we can include a default method in an interface and can provide full implementation for this method.

```java

	public interface myInterface{
		String getMyDetails();
		String getCompDetails();
				
		default String myDefaultMethod(){
			//Here we cannot refer to private variable. But we can get access 
			// to methods declared in this interface.
			return getMyDetails()+ "and Company Details: "+ getCompDetails();
		} 
	}
```

* Just like Default method, we can also have fully implemented Static methods in interface.

```java
	public interface myInterface{
		String getMyDetails();
		String getCompDetails();
			
			/* Here, because it is a static method, it can refer to above non-static methods. Hence, we need pass a class object which implements this interface to access above methods */	
		static String myDefaultMethod(MyClassImplementingMyInterface m){
			 
			return m.getMyDetails()+ "and Company Details: "+ m.getCompDetails();
		} 
	}
```

### Steam
* Java 8 introduced a new API called Stream. This is used for traversing and filtering and aggregating Collections.
* There are 2 kinds of Stream i.e. Sequential Stream and Parallel Stream
* Sequential steam guarantees that each item will be processed in sequence i.e. one at time and the next.
* Parallel Stream is used for multi core CPUs when items are processed in parallel hence sequence is not guaranteed.  

* Java 8 also introduced another method called filter() which is used in conjunction with Stream. This method accept a Predicate object and it knows how to call Predicate's test method.
 

```java
	ArrayList<Person> people = new ArrayList<>();
	people.add("A1",30);
	people.add("A2",20);
	people.add("A3",60);
	people.add("A4",40);
	
	Predicate<Person> pred = (p) -> p.getAge() > 50;
	
	people.stream()
			.filter(pred)
			.forEach(p -> System.out.println(p));
```

* We can also have stream for Array. We can get that using Stream.of(array) method or Arrays.steam(array) method.

* We can perform aggregating functions such as count(), sum() and average() using Stream over a collections
* To deal with collection of complex type, we can use "mapTo..(getMethod())"  for example. mapToInt(p -> p.getAge())

```java
	ArrayList<Person> people = new ArrayList<>();
	people.add("A1",30);
	people.add("A2",20);
	people.add("A3",60);
	people.add("A4",40);
	
	int sumOfAges = people.stream()
								.mapToInt(p -> p.getAge())
								.sum();
	

	OptionalDouble avarage = people.stream()
									.mapToInt(p -> p.getAge())
									.avarage();
	
	if(avarage.isPresent())
		System.out.println("The avarage of ages: "+avarage);
	else
		System.out.print("The avarage was not calculated. May be due to divide by Zero scenario")
```