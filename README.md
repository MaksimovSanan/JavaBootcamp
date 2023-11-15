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

## [Lesson6](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson6)
JUnit and Mockito. Today you will learn the basics of module and integration.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson6/src/ex00) Now you need to implement NumberWorker class that contains the following functionality:

```java
public boolean isPrime(int number) {
  ...
}

```
This method determines if a number is prime and returns true/false for all natural (positive integer) numbers. For negative numbers, as well as 0 and 1, the program shall throw an unchecked exception. IllegalNumberException.
```java
public int digitsSum(int number) {
  ...
}
```

This method returns the sum of digits of a source number.

We also need to create NumberWorkerTest class that implements the module testing logic. Methods of NumberWorkerTest class shall check the correct operation of NumberWorker methods for various input data:
1. isPrimeForPrimes method to check isPrime using prime numbers (at least three)
2. isPrimeForNotPrimes method to check isPrime using composite numbers (at least three)
3. isPrimeForIncorrectNumbers method to check isPrime using incorrect numbers (at least three)
4. a method to check digitsSum using a set of at least 10 numbers

**Requirements**:
- NumberWorkerTest class must contain at least 4 methods to test NumberWorker functionality
- Use of @ParameterizedTest and @ValueSource is mandatory for methods 1–3.
- Use of @ParameterizedTest and @CsvFileSource is mandatory for method 4.
- You need to prepare data.csv file for method 4 where you shall specify at least 10 numbers and their correct sum of digits. A file content example:
1234, 10

**Project structure**:

- Tests
    - src
        - main
            - java
                 - edu.school21.numbers
                    - NumberWorker
            - resources
        - test
            - java
                - edu.school21.numbers
                    - NumberWorkerTest
            - resources
                -	data.csv
    - pom.xml

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson6/src/ex01) Do not use a heavy DBMS (like PostgreSQL) to implement integration testing of components that interact with the database. It is best to create a lightweight in-memory database with prearranged data.  

Implement DataSource creation mechanism for HSQL DBMS. To do so, connect spring-jdbc and hsqldb dependencies to the project. Prepare schema.sql and data.sql files where you will describe product table structure and test data (at least five).

Product table structure:
- identifier
- name
- price

Also create EmbeddedDataSourceTest class. In this class, implement init() method marked with @BeforeEach annotation. In this class, implement functionality to create DataSource using EmbeddedDataBaseBuilder (a class in spring-jdbc library). Implement a simple test method to check the return value of getConnection() method created by DataSource (this value must not be null).

**Project structure**:

- Tests
    - src
        - main
            - java
                - edu.school21.numbers
                    - NumberWorker
            - resources
        - test
            - java
                - edu.school21
                    - numbers
                        - NumberWorkerTest
                    - repositories
                        - EmbeddedDataSourceTest
            - resources
                -	data.csv
                -	schema.sql
                -	data.sql
    - pom.xml

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson6/src/ex02) Implement ProductsRepository/ProductsRepositoryJdbcImpl interface/class pair with the following methods:

```java
List<Product> findAll()

Optional<Product> findById(Long id)

void update(Product product)

void save(Product product)

void delete(Long id)
```
You shall implement ProductsRepositoryJdbcImplTest class containing methods checking repository functionality using the in-memory database mentioned in the previous exercise. In this class, you should prepare in advance model objects that will be used for comparison in all tests.

Example of declaring test data is given below:
```java
class ProductsRepositoryJdbcImplTest {
  final List<Product> EXPECTED_FIND_ALL_PRODUCTS = ...;
  final Product EXPECTED_FIND_BY_ID_PRODUCT = ...;
  final Product EXPECTED_UPDATED_PRODUCT = ...;
}
```
**Notes**:
1.	Each test shall be isolated from behavior of other tests. Thus, the database must be in its initial state before each test is run.
2.	Test methods may call other methods that are not under the current test. For instance, when testing update() method, findById() method may be called to check the entity update validity in the database.

**Project structure**:

- Tests
    - src
        - main
            - java
                - edu.school21
                    - numbers
                        - NumberWorker
                    - models
                        - Product
                    - repositories
                        - ProductsRepository
                        - ProductsRepositoryJdbcImpl
            - resources
        - test
            - java
                - edu.school21
                    - numbers
                        - NumberWorkerTest
                    - repositories
                        - EmbeddedDataSourceTest
                        - ProductsRepositoryJdbcImplTest
            - resources
                -	data.csv
                -	schema.sql
                -	data.sql
    - pom.xml

- [ex03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson6/src/ex03) An important rule for module tests:  an individual system component shall be tested without calling its dependencies' functionality. This approach allows developers to create and test components independently, as well as postpone the implementation of specific application parts.

Now you need to implement the business logic layer represented by UsersServiceImpl class. This class contains a user authentication logic. It also has a dependency on UsersRepository interface (in this task, you do not need to implement this interface).

UsersRepository interface (that you have described) shall contain the following methods:
```java
User findByLogin(String login);
void update(User user);
```
It is assumed that findByLogin method returns a Userobject found via login, or throws EntityNotFoundException if no user is found with the login specified. Update method throws a similar exception when updating a user that does not exist in the database.

User entity shall contain the following fields:
- Identifier
- Login
- Password
- Authentication success status (true - authenticated, false - not authenticated)

In turn, UsersServiceImpl class calls these methods inside the authentication function:
```java
boolean authenticate(String login, String password)
```

This method:
1.	Checks if a user has been authenticated in the system using this login. If authentication was performed, AlreadyAuthenticatedException must be thrown.
2.	The user with this login is retrieved from UsersRepository.
3.	If the retrieved user password matches the specified password, the method sets the status of the authentication success for the user, updates its information in the database and returns true. If passwords mismatch, the method returns false.

Your goal is to:
1.	Create UsersRepository interface
2.	Create UsersServiceImpl class and authenticate method
3.	Create a module test for UsersServiceImpl class

Since your objective is to check correct operation of authenticate method independently of UsersRepository component, you should use mock object and stubs of findByLogin and update methods (see Mockito library).

Authenticate method shall be checked for three cases:
1.	Correct login/password (check calling update method using verify instruction of Mockito library)
2.	Incorrect login
3.	Incorrect password

**Project structure**:

- Tests
    - src
        - main
            - java
                - edu.school21
                    - exceptions
                        - AlreadyAuthenticatedException
                    - numbers
                        - NumberWorker
                    - models
                        - Product
                        - User
                    - services
                        - UsersServiceImpl
                    - repositories
                        - ProductsRepository
                        - ProductsRepositoryJdbcImpl
                        - UsersRepository
            - resources
        - test
            - java
                - edu.school21
                    - services
                        - UsersServiceImplTest
                    - numbers
                        - NumberWorkerTest
                    - repositories
                        - EmbeddedDataSourceTest
                        - ProductsRepositoryJdbcImplTest
            - resources
                -	data.csv
                -	schema.sql
                -	data.sql
    - pom.xml

## [Lesson7](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson7)
Reflection. Today you will develop your own frameworks that use the reflection mechanism.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson7/src/ex00) Now you need to implement a Maven project that interacts with classes of your application. We need to create at least two classes, each having:
- private fields (supported types are String, Integer, Double, Boolean, Long)
- public methods
- an empty constructor
- a constructor with a parameter
- toString() method

In this task, you do not need to implement get/set methods. Newly created classes must be located in a separate **classes** package (this package may be located in other packages). Let's assume that the application has User and Car classes. User class is described below:
```java
public class User {
   private String firstName;
   private String lastName;
   private int height;

   public User() {
       this.firstName = "Default first name";
       this.lastName = "Default last name";
       this.height = 0;
   }

   public User(String firstName, String lastName, int height) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.height = height;
   }

   public int grow(int value) {
       this.height += value;
       return height;
   }

   @Override
   public String toString() {
       return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
               .add("firstName='" + firstName + "'")
               .add("lastName='" + lastName + "'")
               .add("height=" + height)
               .toString();
   }
}
```

The implemented application shall operate as follows:
- Provide information about a class in classes package.
- Enable a user to create objects of a specified class with specific field values.
- Display information about the created class object.
- Call class methods.

Example of program operation:

```
Classes:
  - User
  - Car
---------------------
Enter class name:
-> User
---------------------
fields:
	String firstName
	String lastName
	int height
methods:
	int grow(int)
---------------------
Let’s create an object.
firstName:
-> UserName
lastName:
-> UserSurname
height:
-> 185
Object created: User[firstName='UserName', lastName='UserSurname', height=185]
---------------------
Enter name of the field for changing:
-> firstName
Enter String value:
-> Name
Object updated: User[firstName='Name', lastName='UserSurname', height=185]
---------------------
Enter name of the method for call:
-> grow(int)
Enter int value:
-> 10
Method returned:
195
```

- If a method contains more than one parameter, you need to set values for each one
- If the method has void type, a line with returned value information is not displayed
- In a program session, interaction only with a single class is possible; a single field of its object can be modified, and a single method can be called
- You may use throws operator.

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson7/src/ex01) Annotations allow to store metadata directly in the program code. Now your objective it to implement HtmlProcessor class (derived fromAbstractProcessor) that processes classes with special @HtmlForm and @Htmlnput annotations and generates HTML form code inside the target/classes folder after executing mvn clean compile command. Let's assume we have UserForm class:

```java
@HtmlForm(fileName = “user_form.html”, action = “/users”, method = “post”)
public class UserForm {
	@HtmlInput(type = “text”, name = “first_name”, placeholder = “Enter First Name”)
	private String firstName;

	@HtmlInput(type = “text”, name = “last_name”, placeholder = “Enter Last Name”)
	private String lastName;
	
	@HtmlInput(type = “password”, name = “password”, placeholder = “Enter Password”)
	private String password;
}
```
Then, it shall be used as a base to generate "user_form.html" file with the following contents:

```HTML
<form action = "/users" method = "post">
	<input type = "text" name = "first_name" placeholder = "Enter First Name">
	<input type = "text" name = "last_name" placeholder = "Enter Last Name">
	<input type = "password" name = "password" placeholder = "Enter Password">
	<input type = "submit" value = "Send">
</form>
```

- @HtmlForm and @HtmlInput annotations shall only be available during compilation.
- Project structure is at the developer's discretion.
- To handle annotations correctly, we recommend to use special settings of maven-compiler-plugin and auto-service dependency on com.google.auto.service.

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson7/src/ex02) We mentioned before that Hibernate ORM framework for databases is based on reflection. ORM concept allows to map relational links to object-oriented links automatically. This approach makes the application fully independent from DBMS. You need to implement a trivial version of such ORM framework.

Let's assume we have a set of model classes. Each class contains no dependencies on other classes, and its fields may only accept the following value types: String, Integer, Double, Boolean, Long. Let's specify a certain set of annotations for the class and its members, for example, User class:

```java
@OrmEntity(table = “simple_user”)
public class User {
  @OrmColumnId
  private Long id;
  @OrmColumn(name = “first_name”, length = 10)
  private String firstName;
  @OrmColumn(name = “first_name”, length = 10)
  private String lastName;
  @OrmColumn(name “age”)
  private Integer age;
  
  // setters/getters
}
```

OrmManager class developed by you shall generate and execute respective SQL code during initialization of all classes marked with @OrmEntity annotation. That code will contain CREATE TABLE command for creating a table with the name specified in the annotation. Each field of the class marked with @OrmColumn annotation becomes a column in this table. The field marked with @OrmColumnId annotation indicates that an auto increment identifier must be created. OrmManager shall also support the following set of operations (the respective SQL code in Runtime is also generated for each of them):

```java
public void save(Object entity)

public void update(Object entity)

public <T> T findById(Long id, Class<T> aClass)
```

- OrmManager shall ensure the output of generated SQL onto the console during execution.
- In initialization, OrmManager shall remove created tables.
- Update method shall replace values in columns specified in the entity, even if object field value is null.
