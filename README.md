r2d2-java
=========

The Java Message Producer library for the MySQL storage engine 'r2d2'.

(r2d2 storage engine-> https://github.com/jaihind213/mysql-r2d2)

This java library has implementations of Messengers/Producers which can produce messages
to Message Queues like Kafka.

The r2d2 MySQL storage engine uses this library to produce message to a message queue.

i.e. when an insert statement occurs on a MySQL table with R2D2 storage engine, the engine
uses this library to instantiate a 'Messenger' object. The payload provided to the insert statement
is passed on to the 'Messenger' object which dispatches the message to the message queue.

Sample implmentations of Messengers:
-----------------------------------

(1) BLACKHOLE - produces a message to a blackhole refer `BlackholeProducer.java` 
 
(2) CONSOLE - produces to console refer `ConsoleMessenger.java`

(3) KAFKA(todo)


To implement an interface to a message queue like kafka, 
you need to extend `AbstractMessenger` & then register it as an 'MessengerType' enum value.

refer to classes `ConsoleMessenger.java` & `MessengerType.java` for an example.

compile the r2d2-java project 

How to compile:
---------------

mvn clean compile;

mvn test;

mvn package; #create the jar

The jar 'r2d2-java.jar' is created in the target folder.

Next steps:
-----------

add the mysql variable `r2d2_jvm_arguments_var="-Djava.class.path=<path_to_r2d2-java.jar>"` to my.cnf

get the storage engine set up in MySQL -> https://github.com/jaihind213/mysql-r2d2/blob/master/README.md
