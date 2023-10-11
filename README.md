# JavaBootcamp

## [Day00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00)
Structures and arrays. Today you will learn the basics of solving both trivial and more challenging business tasks using basic Java language constructs.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00/src/ex00) Calculate the sum of digits of a six-digit int number

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00/src/ex01) The program accepts the number entered from the keyboard as input and displays the result of checking whether that number is a prime.  In addition, the program shall output the number of steps (iterations) required to perform the check. In this task, an iteration is a single comparison operation.

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00/src/ex02) Today, you are Google.
You need to count queries related to coffee preparation which our search system users make at a certain moment. It is clear that the sequence of search queries is infinite. It is impossible to store these queries and count them later.
But there is a solution—process the flow of queries. Why should we waste our resources for all queries if we are only interested in a specific feature of this query sequence?  Let's assume that each query is any natural number other than 0 and 1. A query is related to coffee preparation only if the sum of digits of the number (query) is a prime number.
So, we need to implement a program that will count the number of elements for a specified set of numbers whose sum of digits is a prime number.
To keep it simple, let's assume that this potentially infinite sequence of queries is still limited, and the last sequence element is number 42.
This task guarantees that input data is absolutely correct.

- [ex03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00/src/ex03) Customer wants to see a chart showing student's progress changes over several weeks.
Customer evaluates this progress as a minimal grade for five tests within each week. Each test can be graded between 1 and 9.
The maximum number of weeks for the analysis is 18. Once the program has obtained information for each week, it displays the graph on the console to show minimum grades for a specific week.
And we keep assuming that 42 is the input data limit.
The exact guaranteed number of tests in a week is 5.
However, the order of weekly data input is not guaranteed, so Week 1's data can be entered after Week 2's data. If data input order is wrong, IllegalArgument message shall be displayed, and the program shall be shut down with -1 code.

- [ex04](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00/src/ex04) Feel like a hacker and implement a program for counting a character occurrences in a text.
We like visual clarity. This is why the program will display the results in a histogram. This chart will show 10 most frequently occurring characters in descending order.
If letters are encountered the same number of times, they should be sorted in a lexicographic order.
Each character may occur in text a great number of times. For that reason, the chart should be scalable. The maximum height of the displayed chart is 10, and the minimum is 0.

- [ex05](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day00/src/ex05) You've just become a great hacker, but your customer comes back to you with another task. This time, they need to be able to maintain a class timetable in their educational institution. Customer opens a school in September 2020. So, you need to implement the MVP version of the project for this month only.
You need to be able to create a list of students and specify time and weekdays for classes. Classes can be held on any day of week between 1 pm and 6 pm. Multiple classes can be held on a single day. However, total classes per week cannot exceed 10.
Maximum number of students in the timetable is also 10. Maximum length of a student's name is 10 (no spaces).
You should also provide an ability to record student's attendance. To do so, time and date of classes shall be specified next to each student's name along with attendance status (HERE, NOT_HERE). You do not need to record attendance for all classes in a month.
Each application operation stage is divided by "." (period). Absolute correctness of data is guaranteed, except for sequential ordering of classes when populating the timetable.

## [Day01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day01)
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

## [Day02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day02)
IO and Files. Today you will learn how to use input/output in Java and implement programs to manipulate a file system.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day02/src/ex00) You need to implement an application that accepts the signatures.txt as an input (you should describe it on your own; the file name is explicitly stated in the program code). It contains a list of file types and their respective signatures in the HEX format. During execution, your program shall accept full paths to files on hard disk and keep the type which file signature corresponds to. The result of program execution should be written to result.txt file. If a signature cannot be defined, the execution result is UNDEFINED

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day02/src/ex01) Your goal is to implement an application that accepts two files as an input (both files are passed as command-line arguments) and displays their similarity comparison outcome (cosine measure).

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day02/src/ex02) Let's implement a utility handling the files. The application shall display information about the files, folder content and size, and provide moving/renaming functionality. In essence, the application emulates a command line of Unix-like systems.
The program shall accept as an argument the absolute path to the folder where we start to work, and support the following commands:
`mv` WHAT WHERE – enables to transfer or rename a file if WHERE contains a file name without a path.
`ls` – displays the current folder contents (file and subfolder names and sizes in KB)
`cd FOLDER_NAME` – changes the current directory

## [Day03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day03)
Threads. Today you will learn how to use basic multithreading mechanisms in Java.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day03/src/ex00) The truth is born in a dispute—let's assume that each thread provides its own answer. The thread that has the last word is right.
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

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day03/src/ex01) Let's orchestrate the argument. Now, each thread can provide its answer only after another thread has done so. Let's assume that the egg thread always answers first. To solve this task, we recommend to explore Producer-Consumer model operation principle

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day03/src/ex02) Try to use multithreading for its intended purpose: distribute computations across the program.
Let's assume there is an array of integer values. Your goal is to calculate the sum of array elements using several "summing" threads. Each thread computes a certain section inside the array. The number of elements in each section is constant, except for the last one (its size can differ upward or downward).
The array shall be randomly generated each time. Array length and the number of threads are passed as command-line arguments.
To make sure the program operates correctly, we should start by calculating the sum of array elements using a standard method.

- [ex03](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/Day03/src/ex03) Let's assume that we need to download a list of files from a network. Some files are downloaded faster, while others are slower.
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