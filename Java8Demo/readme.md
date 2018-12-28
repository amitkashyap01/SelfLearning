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


### Instant and Duration
* Instant and Duration APIs are introduced in java 8 and they are placed in java.time package.

```java

		Instant start = Instant.now();
		System.out.println("We have started the processing");
	
		Instant end = Instant.now();
		
		Duration elapsed = Duration.between(start, end);
		
		System.out.println("Total Elapsed Time: "+elapsed.toNanos());
```


### LocalDate, LocalTime and LocalDateTime

```java
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		
		LocalDate specificDate = LocalDate.of(2016, 8, 16);
		System.out.println(specificDate);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		
		LocalTime specificTime = LocalTime.of(12, 05, 24);
		System.out.println(specificTime);
		
		LocalDateTime currentDT = LocalDateTime.now();
		System.out.println(currentDT);
		
		LocalDateTime specificDT = LocalDateTime.of(specificDate, specificTime);
		System.out.println(specificDT);
```

### DateTimeFormatter, DateTimeFormatterBuilder

```java
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		System.out.println(df.format(currentDate));

		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ISO_TIME;
		System.out.println(dt.format(currentTime));

		
		LocalDateTime currentDT = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(dtf.format(currentDT));
		
		DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		System.out.println(f_long.format(currentDT));

		DateTimeFormatter s_long = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(s_long.format(currentDT));
		
		
//		String fr_long = f_long.withLocale(Locale.FRENCH).format(currentDT);
//		System.out.println(fr_long);
		
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
				.appendValue(ChronoField.MONTH_OF_YEAR)
				.appendLiteral("-")
				.appendValue(ChronoField.DAY_OF_MONTH)
				.appendLiteral("-")
				.appendValue(ChronoField.YEAR);
		
		DateTimeFormatter d = builder.toFormatter();
		System.out.println(d.format(currentDT));

```