Thread executes a task (modelled by Runnable interface) in a special context

The fundamental notion of race condition is when different thead is trying to read/write the same variable at the same time.

---

### The Runnable pattern

```java
Thread thread = new Thread(new_instance_of_ruunable);
// Launch a thread
thread.start()

//thread.run()  //DO NOT USE This

//To stop a thread
//thread.stop; //DO NOT USE this

thread.interrupt(); // This should be used to stop a thread. It sends a signal to thread suggesting that this is the time to stop.

Runnable task = () -> {
	if(! Thread.currentThread().isInterrupted()){
		//do the task
	}
};
```

If the thread is blocked, or waiting, then corresponding method will throw an IntrupptedException

The methods wait()/notify(), join() throw InterupptedException 

* Producers and consumers run in their own thread

* wait() and notify() are the two methods from the Object class. That means it is available in all the java objects which we create.

* They are invoked on a given object

* The thread executing the invocation should hold the key of that object.

* So, wait() and notify() cannot be invoked outside a synchronized block.

* Calling wait() releases the key help by this thread and put the current thread puts that thread in WAIT state

* To only way to release a WAIT state is to call notify() and puts it in the RUNNABLE state.

* notify() is the only way to release a waiting thread

* If more than one threads in waiting state, the released thread is chosen randomly by notify()

* There is also notifyAll() method

---- 

States of the thread (Thread.State state = thread.getState())

	- New (When we create: Thread thread = new Thread())
	- Runnable (when thread.start() - It means that thread scheduler is free to give CPU time slice so that it can do its task)
	- Terminated
	- Blocked (From Runnable - waiting at the entrance of a synchronized block)
	- Waiting (From Runnable - When wait() method is called. Thread is parked in the wait list. The thread can be awaken only by notify() call)
	- Timed_Waiting (From Runnable - Parked using a sleep(timeout) or wait(timeout) call. In this case, thread can be awaken without calling notify() call)
	

Note: Thread can run the thread in the state RUNNABLE.


### How to write correct concurrent code?

1. Check for race conditions
    * They occurs on fields (not variables/parameters)
    * 2 threads are reading/writing a given field
1. Check for happens-before link
    * Are the read/write volatile?
    * Are they synchronized?
    * If not, there is  a probable bug.
1. Synchronized or volatile?
     * Synchronized = atomicity
     * Volatile = visibility
----

Literals means any text, number or other infomration that represents value.

Integer Literals
	- Base 10 (Decimal): Represented by 0-9 numbers.
	- Base 16 (HexaDecimal): Represented by 0-9 numbers and A-F letters. Mostly indicated by 0x e.g. 0x1a.
	- Base 2 (Binrary): Represented by 0 and 1. Incdicated by 0b e.g. 0b010110;

 
Integer variable can be assigned to following literal types:
1) Decimal (e.g. int num = 10)
2) Octal (e.g. int num = 010 (here octal value is converted into integer and then assigned to variable num))
3) Hexadecimal (e.g. int num = 0x1a)
4) Binary (e.g. int num=0b10101)
5) Long (e.g. long num= 599L)
6) Integer literals with underscore (i.e. int num = 901_12_1) - This was introduced in Java 1.7 and more
(We should not use underscore as first or last in literal)

---
Character Literals
Unicode escape sequence

1) '\u0041' - Captial A
2) '\u0020' - Double quote "

----
Floating Point Literals

A floating point literals is of type float if it ends with 'f' or 'F'; otherwise its type is double 
and it can optionally end with 'd' or 'D'.

float f1 = 123.2
double d1 = 123.4 (This is a float point literal of type double)
double d2 = 3.4d

The float-point types (float or double) can also be expressed using 'E' or 'e' (for scientific notation),
F or f(32 bit float literal) and D or d (64 bit float literal) 

double d4 = 1.234e2 (same value as d1)
 
--- 
Class literals

Using Class.forName("java.lang.String"), we can retrieve a Class object representing the class "java.lang.String"
which is a special class used to represent classes.

Class c = Class.forName("java.lang.String")
another way of producing same result
Class c = java.lang.String.class;


There is one Class object for each loaded class known to the Java runtime system.

---

## Garbage Collections:

Done automatically through a Java Thread called Garbage Collector

This is based on following 2 hypothesis:

1. Most Objects soon become unreachable
1. References from 'old' objects to 'young' objects only exist in small numbers.

2 main terms:
* Live Object: reachable (references by someone else)
* Dead Object: unreachable (not referenced from anywhere)

Note: Objects are allocated (e.g. new) in the "Heap" of java memory. Static members, class definitions(metadata) etc. are stored in "method area" (Permgen/Metaspace)

Objects are alloacted in heap while primitive datatypes and reference variables are allocated to stack.


Garbage Collection involves following steps:
1. **Mark**: Starts from the root node of your application (main), walks the object graph, marks object graph, marks objects that are reachable as live.
1. **Delete/Sweep**: Delete unreachable objects.
1. **Compacting**: Compact the memory by moving around the objects and making the allocation contiguous than fragmented.

### Generational Collectors

Heap is divided into 2 generational collectors
* **Young Generation** : Is a place where the new objects are created
    * Eden Space: New Space
    * Survivor Space From: Once Eden space is full, minor GC moves objects from eden space to here.
    * Survivor Space To: 

* **Old(Tenured) Generation**: Objects that survive for long time. E.g. cache. Objects which are survived for -XX MaxTenuringThershold in Young generation collectors, are moved to Old generation.

Major GC runs throughout the Heap memory.


jvisualvm - To view GC details

JHAT (Java Heap Analyser Tool) 


##### StringBuffer is faster and memory efficient than String. StringBuffer is mutable while String is immutable.


### Java Memory Model (JMM)

JMM is a specificiation which guarantees visibility of fields (aka happens before)  amidst reordering of instructions.

* **Out of order execution**: Performance driven changes done by Compiler, JVM or CPU
* **Field Visibility**: In presence of multiple threads a.k.a concurrency 

---

#JAVA 7 

###Coding Simplification
* The diamond operator's data type only needs to be set once.
* try-with-resources eliminates a lot of code
```java
	
	//Here we have move stream declaration inside try which ensures that
	// java will automatically takes care of closing the stream and we
	// don't need to explicitly close the stream in finally block 
	try(FileStream stream = new FileStream(...)){
		...do something...
	}catch(Exception e){
	}
```

* Numeric literals can include underscore

```java
	int largeValue = 1_00_000;
```

* Use String values in switch statements
* new File system API with classes Path, Paths, Files, FileSystem and more...
* new support for dynamic languages

Note: Ctrl + Alt + Down Arrow : shortcut for duplicating the line in eclipse.

* Non-static blocks always run before any constructor of that. So, it can be used to initialize fields irrespective of which constructor is called

```java
 public class SomeClass{
 	public static ArrayList<Olive> olives;
 	
 	//Below is the non-static block
 	{
 		Sysout.out.println("This will be run before constructor");
 		olives = new ArrayList<>;
 		
 		olives.add (new Oliver("a1"));
 		olives.add (new Oliver("a2"));
 		
 		
 	} 
 }
```


* MemberClass: A class defined within another class. This class provides further level of encapsulation. 
* LocalClass: A class defined within a method. This can be accessible only within that method. Also, 
* A enum class allows use to create constants which can be used throughout the application. Enum class can only have private constructor, it cannot have Public constructor.



---

## Collections
### HashSet
* A set can contains only reference of an object and only one reference of null. All the other same references will be ignored.
* The order of members are NOT guaranteed here.

### TreeSet
* TreeSet makes sure that order of members are Guaranteed. 
* All members need to implement Comparable interface.
* It's a slow as compare to HashSet as it compare the new added member with all the existing member to place them in order.

### LinkedList
* Provide a way to add new member at any specific position of existing members
* Members are ordered

```java
	LinkedList<Olive> olivesList = new LinkedList<>;
	olivesList.add(new Olive());
	olivesList.add(new Olive());
	// It will add olive at index 1
	olivesList.add(1, new Olive());
	// It will add olive at begining of the linked list
	olivesList.addFirst(new Olive());
	olivesList.add(new Olive());
	
```

* LinkedList implements Queue interface. Queue interface has below methods
* Queue is FIFO data structure.
    * To add an item: add(e);
    * To remove an item the first item: remove();
    * To display the first item but does not remove: element();
* Also, we have 3 methods which is corresponding to above methods. The different between these is the below methods return a special value.

     * offer(e)
     * poll()
     * peek()


### Assert
* assert is a keyword in java which can used in java program for assertion


### Path
* Path is introduced as part of Java 7 and its package name is java.nio

---------

# Java 8
### Lambda Expressions
* In computer terms, Lambda Expressions are Anonymous functions

### Functional Interface
* A functional interface has a single abstract method (i.e. the one which not inheriated from Object class)
* Prior to Java 8, it was known as "Single Abstract Method (SAM)" types
E.g.: Runnable r = () -> System.out.println("This is a method implementation");

Here (): It is a method signature
	System.out.println("..."): It is method implementation
	
	
