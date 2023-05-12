/*
    **JAVA Notes**

    1. Java is a high level, robust, secured and object-oriented programming language.
    2. Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995.
    3. James Gosling is known as the father of Java.
    4. Before Java, its name was Oak.
    5. Java is a platform independent language.
    6. Java is a portable language because it facilitates you to carry the Java bytecode to any platform.
    7. Java is an Object-Oriented Language.
    8. Java is a robust language because it uses strong memory management.
    9. Java is a secured language because it doesn't use explicit pointers.
    10. Java is a dynamic language.
    11. Java is a multithreaded language.
    12. Java is an interpreted language.
    13. Java is a distributed language.
    
    **Features of Java**
    

    -> Threads--

    Threads are light-weight processes within a process. Threads can be used to perform complicated tasks in the background without interrupting the main program.

    Different States of a Thread--
    1. New - When a new thread is created, it is in the new state.
    2. Active - When the thread scheduler selects a thread from the ready queue and assigns it to the processor, the thread is in the active state.
    3. Waiting - When a thread is waiting for another thread to perform a task, it is in the waiting state.
    4. Blocked - When a thread is prevented from entering the active state because of some reason, it is in the blocked state.
    5. Terminated - When a thread has completed its task, it is in the terminated state.    

    InterruptedException--
    When a thread is in the waiting or sleeping state, another thread can interrupt it using the interrupt() method of the Thread class. This causes an InterruptedException to be thrown. The interrupted thread can catch this exception and continue its execution.

    Priority of a Thread--
    Every thread has a priority that helps the operating system determine the order in which threads are scheduled. Java uses the following thread priorities:
    1. MIN_PRIORITY - The minimum priority that a thread can have. Its value is 1.
    2. NORM_PRIORITY - The default priority of a thread. Its value is 5.
    3. MAX_PRIORITY - The maximum priority that a thread can have. Its value is 10.

    *We need to use Thread class in case on interface, but in case of inheritance we can directly extend the Thread class and override the run() method.
    
    Thread Functions--
    1. start() - This method starts the execution of the thread. It calls the run() method of the thread internally.
    2. run() - This method is called when a thread is in the active state. You need to override this method to specify the actions that the thread will perform.
    3. sleep() - This method causes the currently executing thread to sleep for the specified number of milliseconds.
    4. join() - This method waits for a thread to die. It causes the currently executing thread to wait until the thread on which it is called is dead.
    5. yield() - This method causes the currently executing thread to yield to any other threads of the same priority that are waiting to be scheduled.(increases the priority of the thread)
    6. interrupt() - This method interrupts the execution of a thread. It throws an InterruptedException when the thread is in the waiting or sleeping state.
    7. isAlive() - This method tests if a thread is alive.
    8. getName() - This method returns the name of the thread.
    9. setName() - This method changes the name of the thread.
    10. getPriority() - This method returns the priority of the thread.
    11. setPriority() - This method sets the priority of the thread.
    12. getThreadGroup() - This method returns the thread group to which the thread belongs.
    13. setDaemon() - This method marks the thread as a daemon thread.
    14. isDaemon() - This method tests if a thread is a daemon thread.
    15. getId() - This method returns the identifier of the thread.
    16. getStackTrace() - This method returns an array of stack trace elements representing the stack dump of the thread.
    17. getState() - This method returns the state of the thread.
    18. holdsLock() - This method returns true if the current thread holds the lock on the specified object.

    Daemon Thread--
    A daemon thread is a thread that runs in the background. It provides services to user threads. Its life depends on the user threads i.e. when all the user threads die, JVM terminates this thread automatically. You can use setDaemon() method to create a daemon thread.

    Synchronization--
    Synchronization is the capability to control the access of multiple threads to any shared resource. Java Synchronization is better option where we want to allow only one thread to access the shared resource.
    in java, we use synchronized keyword to perform synchronization. we can synchronized method and synchronized block to perform synchronization.


    -> Java.lang Package--

    Object Class--
    The Object class is the parent class of all the classes in java by default. In other words, it is the topmost class of java. The Object class is beneficial if you want to refer any object whose type you don't know. Notice that parent class reference variable can refer the child class object, know as upcasting.
    Functions--
    1. getClass() - This method returns the class of an object.
    2. hashCode() - This method returns the hash code of an object.
    3. equals() - This method compares the given object to the current object.
    4. clone() - This method creates a new object with the same class as the current object.
    5. toString() - This method returns the string representation of an object.
    6. notify() - This method wakes up a single thread that is waiting on this object's monitor.
    7. notifyAll() - This method wakes up all the threads that wait on this object's monitor.
    8. wait() - This method causes the current thread to wait until another thread invokes the notify() or notifyAll() method for this object.
    9. finalize() - This method is invoked by the garbage collector before object is being garbage collected.

    Wrapper Class--
    A wrapper class wraps (encloses) around a data type and gives it an object appearance. Wherever, the data type is required as an object, this object can be used. Wrapper classes include methods to unwrap the object and give back the data type. The object data type is known as Wrapper class data type.
    Functions--
    1. intValue() - This method returns the integer value of the specified object.
    2. byteValue() - This method returns the byte value of the specified object.
    3. shortValue() - This method returns the short value of the specified object.
    4. longValue() - This method returns the long value of the specified object.
    5. floatValue() - This method returns the float value of the specified object.
    6. doubleValue() - This method returns the double value of the specified object.
    7. booleanValue() - This method returns the boolean value of the specified object.
    8. charValue() - This method returns the character value of the specified object.
    9. valueOf() - This method returns the wrapper object holding the value of the specified primitive.(ex- Integer.valueOf(10))

    AutoBoxing--
    The automatic conversion of primitive data type into its corresponding wrapper class is known as autoboxing. For example – conversion of int to Integer, long to Long, double to Double etc.
    ex- Integer i = 10; //autoboxing

    AutoUnBoxing--
    The automatic conversion of wrapper class into its corresponding primitive type is known as unboxing. For example – conversion of Integer to int, Long to long, Double to double etc.
    ex- Integer i = new Integer(10); //unboxing

*/