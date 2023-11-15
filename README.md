# JavaBootcamp

## [Lesson0](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0)
Structures and arrays. Today you will learn the basics of solving both trivial and more challenging business tasks using basic Java language constructs.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0/src/ex00) Calculate the sum of digits of a six-digit int number

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0/src/ex01) The program accepts the number entered from the keyboard as input and displays the result of checking whether that number is a prime.  In addition, the program shall output the number of steps (iterations) required to perform the check. In this task, an iteration is a single comparison operation.

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0/src/ex02) Today, you are Google.
You need to count queries related to coffee preparation which our search system users make at a certain moment. It is clear that the sequence of search queries is infinite. It is impossible to store these queries and count them later.
But there is a solution—process the flow of queries. Why should we waste our resources for all queries if we are only interested in a specific feature of this query sequence?  Let's assume that each query is any natural number other than 0 and 1. A query is related to coffee preparation only if the sum of digits of the number (query) is a prime number.
So, we need to implement a program that will count the number of elements for a specified set of numbers whose sum of digits is a prime number.
To keep it simple, let's assume that this potentially infinite sequence of queries is still limited, and the last sequence element is number 42.
This task guarantees that input data is absolutely correct.

- [ex03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0/src/ex03) Customer wants to see a chart showing student's progress changes over several weeks.
Customer evaluates this progress as a minimal grade for five tests within each week. Each test can be graded between 1 and 9.
The maximum number of weeks for the analysis is 18. Once the program has obtained information for each week, it displays the graph on the console to show minimum grades for a specific week.
And we keep assuming that 42 is the input data limit.
The exact guaranteed number of tests in a week is 5.
However, the order of weekly data input is not guaranteed, so Week 1's data can be entered after Week 2's data. If data input order is wrong, IllegalArgument message shall be displayed, and the program shall be shut down with -1 code.

- [ex04](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0/src/ex04) Feel like a hacker and implement a program for counting a character occurrences in a text.
We like visual clarity. This is why the program will display the results in a histogram. This chart will show 10 most frequently occurring characters in descending order.
If letters are encountered the same number of times, they should be sorted in a lexicographic order.
Each character may occur in text a great number of times. For that reason, the chart should be scalable. The maximum height of the displayed chart is 10, and the minimum is 0.

- [ex05](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson0/src/ex05) You've just become a great hacker, but your customer comes back to you with another task. This time, they need to be able to maintain a class timetable in their educational institution. Customer opens a school in September 2020. So, you need to implement the MVP version of the project for this month only.
You need to be able to create a list of students and specify time and weekdays for classes. Classes can be held on any day of week between 1 pm and 6 pm. Multiple classes can be held on a single day. However, total classes per week cannot exceed 10.
Maximum number of students in the timetable is also 10. Maximum length of a student's name is 10 (no spaces).
You should also provide an ability to record student's attendance. To do so, time and date of classes shall be specified next to each student's name along with attendance status (HERE, NOT_HERE). You do not need to record attendance for all classes in a month.
Each application operation stage is divided by "." (period). Absolute correctness of data is guaranteed, except for sequential ordering of classes when populating the timetable.

## [Lesson1](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson1)
Your today's task is to automate a business process associated with transfers of certain amounts between participants of our system.
Each system user can transfer a certain amount to another user. We need to make sure that even if we lose the history of incoming and outgoing transfers for a specific user, we shall still be able to recover this information.
Inside the system, all money transactions are stored in the form of debit/credit pairs. For example,    

```java
John has transferred $500 to Mike. System saves the transaction for both users:
John -> Mike, -500, OUTCOME, transaction ID
Mike -> John, +500, INCOME, transaction ID
```

To recover the connection within such pairs, identifiers of each transaction should be used.
A transfer entry may obviously be lost in such a complex system—it may not be recorded for one of the users (to emulate and debug such a situation, a developer needs to be able to remove the transfer data from one of users individually). Since such situations are realistic, functionality is required for displaying all "unacknowledged transfers" (transactions recorded for one user only) and resolving such issues.
Below is a set of exercises you can do one by one to solve the task.

## [Lesson2](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2)
IO and Files. Today you will learn how to use input/output in Java and implement programs to manipulate a file system.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2/src/ex00) You need to implement an application that accepts the signatures.txt as an input (you should describe it on your own; the file name is explicitly stated in the program code). It contains a list of file types and their respective signatures in the HEX format. During execution, your program shall accept full paths to files on hard disk and keep the type which file signature corresponds to. The result of program execution should be written to result.txt file. If a signature cannot be defined, the execution result is UNDEFINED

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2/src/ex01) Your goal is to implement an application that accepts two files as an input (both files are passed as command-line arguments) and displays their similarity comparison outcome (cosine measure).

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2/src/ex02) Let's implement a utility handling the files. The application shall display information about the files, folder content and size, and provide moving/renaming functionality. In essence, the application emulates a command line of Unix-like systems.
The program shall accept as an argument the absolute path to the folder where we start to work, and support the following commands:
`mv` WHAT WHERE – enables to transfer or rename a file if WHERE contains a file name without a path.
`ls` – displays the current folder contents (file and subfolder names and sizes in KB)
`cd FOLDER_NAME` – changes the current directory

## [Lesson3](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson3)
Threads. Today you will learn how to use basic multithreading mechanisms in Java.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson3/src/ex00) The truth is born in a dispute—let's assume that each thread provides its own answer. The thread that has the last word is right.
You need to implement the operation of two threads. Each of them must display its answer a few times, for example, 50:
```
$ java Program --count=50
Egg
Hen
Hen
Hen
...
Egg
```
In this case, the egg thread wins. However, the program also contains main thread. Inside the thread,  public static void main(String args[]) method is executed. We need this thread to display all its responses at the end of program execution. Thus, the ultimate variant is as follows:
```
$ java Program --count=50
Egg
Hen
Hen
...
Egg
Hen
...
Human
...
...
Human
```
It means that the program outputs Human message 50 times, which main thread prints.

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson3/src/ex01) Let's orchestrate the argument. Now, each thread can provide its answer only after another thread has done so. Let's assume that the egg thread always answers first. To solve this task, we recommend to explore Producer-Consumer model operation principle

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson3/src/ex02) Try to use multithreading for its intended purpose: distribute computations across the program.
Let's assume there is an array of integer values. Your goal is to calculate the sum of array elements using several "summing" threads. Each thread computes a certain section inside the array. The number of elements in each section is constant, except for the last one (its size can differ upward or downward).
The array shall be randomly generated each time. Array length and the number of threads are passed as command-line arguments.
To make sure the program operates correctly, we should start by calculating the sum of array elements using a standard method.

- [ex03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson3/src/ex03) Let's assume that we need to download a list of files from a network. Some files are downloaded faster, while others are slower.
To implement this functionality, we can obviously use multithreaded downloading where each thread loads a specific file. But what should we do if there are too many files? A large number of threads cannot be run at the same time. Therefore, many of them will be waiting.
In addition, we should bear in mind that continuously creating and completing threads is a very costly operation we should avoid. It makes more sense to start N threads at once and, when either of them finishes downloading the file, it can take on the next file in the queue.
We need to create files_urls.txt file (file name shall be explicitly specified in program code) where you specify a list of URLs of files to be downloaded, for instance:
```
1 https://i.pinimg.com/originals/11/19/2e/11192eba63f6f3aa591d3263fdb66bd5.jpg
2 https://pluspng.com/img-png/balloon-hd-png-balloons-png-hd-2750.png
3 https://i.pinimg.com/originals/db/a1/62/dba162603c71cac00d3548420c52bac6.png
4 https://pngimg.com/uploads/balloon/balloon_PNG4969.png
5 http://tldp.org/LDP/intro-linux/intro-linux.pdf
```

## [Lesson4](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson4)
JAR. Today you will learn to create library archives and use external libraries.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson4/src/ex00) Code can be organized on different levels. Packages are one of the code organization methods where classes are located in individual folders. 

Now your task is to implement functionality that prints a two-colored image in the console. 

Your application shall accept input parameters corresponding to characters that should be displayed in place of white and black pixels. Another main function startup parameter is the full path to the image on your disk.


Application logic must be distributed between different packages and have the following structure:

- ImagesToChar - project folder
  - src - source files
    -	java - files of Java source code
        - edu.school21.printer - a series of main packages
          -	app - a package that contains classes for startup 
          -	logic - a package that contains the logic for converting an image into an array of characters
  -	target - compiled .class files
    -	edu.school21.printer ...
  -	README.txt
  
README.txt file must contain instructions for compiling and starting your source code from the console (non-IDE). Instruction is written for the state where the console is opened in the project's root folder.

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson4/src/ex01) Now you need to create a distribution package of the application—a JAR archive. It is important that the image be contained in that archive (a command-line parameter for the full path to the file is not required in this task).

The following project structure shall be adhered to:

- ImagesToChar - project folder
  - src - source files
    - java - files of Java source code
      - ...
    -	resources - a folder with resource files
         - image.bmp - the displayed image
    - manifest.txt - a file containing the description of the initial point for archive startup  
  - target - compiled .class files and archive
    - edu.school21.printer ...
    - resources
    - images-to-chars-printer.jar
  - README.txt

Archive and all compiled files shall be put in target folder during assembly (without a manual file transfer; you may apply cp command to the resource folder).

README.txt file should also contain information on the archive assembly and startup.

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson4/src/ex02) Now you should use external libraries:
- JCommander for the command line. 
- JCDP or JColor for using colored output

Archives with these libraries shall be downloaded and included in the previous task's project. 

Now application startup parameters shall be processed with JCommander tools. The image should be displayed using the "colored" output option of JCDP library.

Required project structure:
- ImagesToChar - project folder
  -	lib - external library folder
    -	jcommander-*.**.jar
    -	JCDP-*.*.*.jar/JCOLOR-*.*.*.jar
  -	src - source files
  -	target - compiled .class files and archive
    -	edu.school21.printer
    -	com/beust ... - .class files of JCommander library
    -	com/diogonunes ... - .class files of JCDP library
    -	resources
    -	images-to-chars-printer.jar
  -	README.txt

README.txt file shall also contain the information about including external libraries in the final assembly.

Example of program operation:

`$ java -jar images-to-chars-printer.jar --white=RED --black=GREEN`

## [Lesson5](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson5)
SQL and JDBC. Today you will use the key mechanisms to work with PostgreSQL DBMS via JDBC.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson5/src/ex00) Throughout this week, we will be implementing Chat functionality. In this chat, user can create or choose an existing chatroom. Each chatroom can have several users exchanging messages.

Key domain models which both SQL tables and Java classes must be implemented for are:

- User
    -	User ID
    - Login
    -	Password
    -	List of created rooms
    -	List of chatrooms where a user socializes
- Chatroom
    -	Chatroom id
    - Chatroom name
    - Chatroom owner
    - List of messages in a chatroom
- Message
    - Message id
    - Message author
    - Message room
    - Message text
    - Message date/time

Create schema.sql file where you will describe CREATE TABLE operations to create tables for the project. You should also create data.sql file with text data INSERTS (at least five in each table).

It is important to meet the following requirement!

Let's assume that Course entity has a one-to-many relationship with Lesson entity. Their object-oriented relation should then look as follows:

```java
class Course {
   private Long id;
   private List<Lesson> lessons;// there are numerous lessons in the course
   ...
}
class Lesson {
   private Long id;
   private Course course; // the lesson contains a course it is linked to
   ...
}
```
Additional requirements:

- To implement relational links, use one-to-many and many-to-many link types.
- Identifiers should be numeric.
- Identifiers shall be generated by DBMS.
- equals(), hashCode() and toString() shall be redefined correctly inside Java classes.

Exercise project structure:
- Chat
    -	src
        -	main
            - java
              -	edu.school21.chat
                 -	models - domain knowledge models
            - resources
                -	schema.sql
                -	data.sql
    -	pom.xml

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson5/src/ex01) Data Access Object (DAO, Repository) is a popular design template that allows to separate key business logic from data handling logic in an application.

Let's assume that we have an interface called CoursesRepository which provides access to course lessons. This interface may look as follows:

```java
public interface CoursesRepository {
  Optional<Course> findById(Long id);
  void delete(Course course);
  void save(Course course);
  void update(Course course);

  List<Course> findAll();
}
```
You need to implement MessagesRepository with a SINGLE `Optional<Message> findById(Long id)` method and its MessagesRepositoryJdbcImpl implementation.

This method shall return a Message object where author and chatroom will be specified.  In turn, there is NO NEED to enter subentities (list of chatrooms, chatroom creator, etc.) for the author and the chatroom.

The implemented code must be tested in Program.java class. Example of the program operation is as follows (the output may differ):

```
$ java Program
Enter a message ID
-> 5
Message : {
  id=5,
  author={id=7,login=“user”,password=“user”,createdRooms=null,rooms=null},
  room={id=8,name=“room”,creator=null,messages=null},
  text=“message”,
  dateTime=01/01/01 15:69
}
```

Exercise project structure:
- Chat
  -	src
      -	main
        - java
          -	edu.school21.chat
             - models - domain knowledge models
              -	repositories - repositories
              -	app
                  - Program.java
        - resources
          -	schema.sql
          -	data.sql
  -	pom.xml


MessagesRepositoryJdbcImpl shall accept DataSource interface of java.sql package as a constructor parameter.
For DataSource implementation, use HikariCP library—a pool of connections to the database which considerably expedite the use of storage.


- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson5/src/ex02) Now you need to implement save(Message message) method for MessagesRepository.

Thus, we need to define the following subentities for the entity we are saving—a message author and a chatroom. It is also important to assign IDs that exist in the database to chatroom and author.

Example of save method use:
```java
public static void main(String args[]) {
	...
  User creator = new User(7L, “user”, “user”, new ArrayList(), new ArrayList());
  User author = creator;
  Room room = new Room(8L, “room”, creator, new ArrayList());
  Message message = new Message(null, author, room, “Hello!”, LocalDateTime.now());
  MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(...);
  messagesRepository.save(message);
  System.out.println(message.getId()); // ex. id == 11
}
```

So, save method shall assign ID value for the incoming model after saving data in the database.
If author and room have no ID existing in the database assigned, or these IDs are null, throw Runtimeexception NotSavedSubEntityException (implement this exception on your own).

Test the implemented code in Program.java class.

- [ex03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson5/src/ex03) Now we need to implement update method in MessageRepository. This method shall fully update an existing entity in the database. If a new value of a field in an entity being updated is null, this value shall be saved in the database.

An example of update method use:
```java
public static void main(String args[]) {
  MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(...);
  Optional<Message> messageOptional = messagesRepository.findById(11);
  if (messageOptinal.isPresent()) {
    Message message = messageOptional.get();
    message.setText(“Bye”);
    message.setDateTime(null);
    messagesRepository.update(message);
  }
  ...
}
```
In this example, the value of the column storing the message text will be altered, whereas message time will be null.

- [ex04](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson5/src/ex04) Now you need to implement UsersRepository interface and UsersRepositoryJdbcImpl class using a `SINGLE List<User> findAll(int page, int size)` method.

This method shall return size—users shown in the page with page number. This "piecewise" data retrieval is called pagination. Thus, DBMS divides the overall set into pages each containing size entries. For example, if a set contains 20 entries with page = 3 and size = 4 , you retrieve users 12 to 15 (user and page numbering starts from 0).

The most complicated situation in converting relational links into object-oriented links happens when you retrieve a set of entities along with their subentities. In this task, each user in the resulting list shall have included dependencies—a list of chatrooms created by that user, as well as a list of chatrooms the user participates in.

Each subentity of the user MUST NOT include its dependencies, i.e. list of messages inside each room must be empty.

The implemented method operation should be demonstrated in Program.java.

**Notes**:
- findAll(int page, int size) method shall be implemented by a SINGLE database query. It is not allowed to use additional SQL queries to retrieve information for each user.
- We recommend using CTE PostgreSQL.
- UsersRepositoryJdbcImpl shall accept DataSource interface of java.sql package as a constructor parameter.
