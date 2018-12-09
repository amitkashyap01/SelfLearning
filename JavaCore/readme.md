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

- Producers and consumers run in their own thread

- wait() and notify() are the two methods from the Object class. That means it is available in all the java objects which we create.

- They are invoked on a given object

- The thread executing the invocation should hold the key of that object.

- So, wait() and notify() cannot be invoked outside a synchronized block.

- Calling wait() releases the key help by this thread and put the current thread puts that thread in WAIT state

- To only way to release a WAIT state is to call notify() and puts it in the RUNNABLE state.

- notify() is the only way to release a waiting thread

- If more than one threads in waiting state, the released thread is chosen randomly by notify()

- There is also notifyAll() method



---- 

States of the thread (Thread.State state = thread.getState())

	- New (When we create: Thread thread = new Thread())
	- Runnable (when thread.start() - It means that thread scheduler is free to give CPU time slice so that it can do its task)
	- Terminated
	- Blocked (From Runnable - waiting at the entrance of a synchronized block)
	- Waiting (From Runnable - When wait() method is called. Thread is parked in the wait list. The thread can be awaken only by notify() call)
	- Timed_Waiting (From Runnable - Parked using a sleep(timeout) or wait(timeout) call. In this case, thread can be awaken without calling notify() call)
	

Note: Thread can run the thread in the state RUNNABLE.


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

