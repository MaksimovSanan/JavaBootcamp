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