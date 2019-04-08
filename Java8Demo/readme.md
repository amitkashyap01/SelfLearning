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

### Stream
* Java 8 introduced a new API called Stream. This is used for traversing and filtering and aggregating Collections.
* A stream pipeline consists of a source, followed by zero or more intermediate operations; and a terminal operation.
* Stream operations are either intermediate or terminal.
        * Intermediate Operations: such as filter, map or sort return a stream so we can chain multiple intermediate operations. Multiple intermediate operations are allowed.
        * Terminal Operations: such as forEach, collect or reduce are either void or return a non-stream results. Only one terminal operation is allowed.
        
* Intermediate Operations include
        * filter()
        * anyMatch()
        * distinct()
        * findFirst()
        * flatmap()
        * map()
        * skip
        * sorted

* Terminal Operations 
        * forEach() applies the same function to each element
        * collect saves the elements into a collection
        * other options **reduce** the stream to a single summary element
               * count()
               * max()
               * min()
               * reduce()
               * summaryStatistics()
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


### ZonedDateTime
* In order to represent timezoned DateTime, java 8 provides ZonedDateTime class.
* Just like LocalDateTime, it is immutable and thread safe 

```java
			DateTimeFormatter formatter= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		
		//Default is current time zone
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(formatter.format(currentTime));
		
		//GMT+0 timezone
		ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
		System.out.println(formatter.format(gmt));
		
		//To find our all the available ZoneIds
		Set<String> listOfTimeZones = ZoneId.getAvailableZoneIds();
		
		Predicate<String> pred = tz -> tz.contains("Kol");
		
		listOfTimeZones
			.stream()
			.filter(pred)
			.forEach(z -> System.out.println(z));
		
		
		//To get the specific timezone time
		ZonedDateTime kolkata = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(formatter.format(kolkata));
```


## 	Using JavaScript with the Java Virtual Machine
* Java 8 introduced a brand new Java Script Engine called "Nashorn". The earlier java script engine was Rhino.

* We can access this JavaScript engine by typing "jjs" on command prompt.

```js
	c:\Users\amitk> jjs
	jjs> var myVar="Amit"
	jjs> myVar
	Amit
	
	// java code to get the content of an URL
	jjs> var input = new java.util.Scanner(new java.net.URL("http://services.explorecalifornia.org/json/tours.php").openStream());
	
	//By default, scanner class breaks contents with delimiter commo (,). We can change it. 
	jjs> input.useDelimiter("$")
	jjs> var contents = input.next()
	jjs> coontents
	
 	//Contents will be printed here

```

### Running JavaScript from Java

```java
	public class JavaScriptFromJava {
		
		public static void main(String[] args) throws ScriptException {
			
			ScriptEngineManager engineManager = new ScriptEngineManager();
			ScriptEngine jsEngine = engineManager.getEngineByName("nashorn");
			
			String script = "var welcome='Hello';"
					+ "welcome += ', Amit'; "
					+ "welcome;";
			
			Object result = jsEngine.eval(script);
			System.out.println(result);
		}
	}

```

### Running JavaScript file from Java

```java
public class JavaScriptFileFromJava {
	
	public static void main(String[] args) {
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine jsEngine = engineManager.getEngineByName("nashorn");
		
		
		try {
			FileReader fileReader = new FileReader("scripts/script.js");
			
			Object result = jsEngine.eval(fileReader);
			
			System.out.println(result);
		} catch (ScriptException se) {
			System.out.println("Script Exception:"+se);
		} catch (FileNotFoundException fe) {
			System.out.println("Script file is not found");
		}
	}
}

```

### Using String.join() Method

```java
		// Here, first argument is delimiter and after  this, we can add as many strings as we want to concat
		String myJoinedStrings = String.join(":", "Amit", "Kumar", "Kashyap");
		System.out.println(myJoinedStrings);
		
		//We can also join elements of any iterable object
		String[] myStringArray = {"Amit","Kumar","Kashyap"};
		String joinedElementsOfArray = String.join("#", myStringArray);
		System.out.println(joinedElementsOfArray);
```
### StringJoiner Class
* StingJoiner class is a new class introduced in Java8. It is also used to join strings

```java
		//Creating a StringJoiner
		StringJoiner joiner = new StringJoiner(" # ");
		joiner.add("FirstItem");
		joiner.add("SecondItem");
		joiner.add("ThirdItem");
		joiner.add("ForuthItem");
		joiner.add("FifthItem");
	
		System.out.println(joiner);
	
		//Merging two StringJoiner
		StringJoiner joiner2 = new StringJoiner(" , ");
		joiner2.add("SixthItem");
		joiner2.add("SeventhItem");
		joiner.merge(joiner2);
		System.out.println(joiner);
		
		//Working with Collections
		Set<String> setOfItems = new HashSet<>();
		setOfItems.add("Item No 1");
		setOfItems.add("Item No 2");
		setOfItems.add("Item No 3");
		setOfItems.add("Item No 4");
		
		StringJoiner joiner3 = new StringJoiner(" * ");
	
		setOfItems.forEach(s -> joiner3.add(s));
		System.out.println(joiner3);

```

### File as a stream
* Below program is to search for a text in a file.

```java
		Path path = FileSystems.getDefault().getPath("files/mynotes.txt");
		
		String searchText = "My name is Amit Kashyap";
		
		try (Stream<String> stream = Files.lines(path)){
			Optional<String> foundString = stream.filter(s -> s.contains(searchText)).findFirst();
			
			if(foundString.isPresent())
				System.out.println(foundString.get());
			else
				System.out.println("Not Found");
			
		} catch (Exception e) {
			System.out.println("Exception Occured"+e);
		}
```