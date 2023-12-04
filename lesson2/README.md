## [Lesson2](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2)
IO and Files. Today you will learn how to use input/output in Java and implement programs to manipulate a file system.

- [ex00](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2/src/ex00) You need to implement an application that accepts the signatures.txt as an input (you should describe it on your own; the file name is explicitly stated in the program code). It contains a list of file types and their respective signatures in the HEX format. During execution, your program shall accept full paths to files on hard disk and keep the type which file signature corresponds to. The result of program execution should be written to result.txt file. If a signature cannot be defined, the execution result is UNDEFINED

- [ex01](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2/src/ex01) Your goal is to implement an application that accepts two files as an input (both files are passed as command-line arguments) and displays their similarity comparison outcome (cosine measure).

- [ex02](https://github.com/MaksimovSanan/JavaBootcamp/tree/main/lesson2/src/ex02) Let's implement a utility handling the files. The application shall display information about the files, folder content and size, and provide moving/renaming functionality. In essence, the application emulates a command line of Unix-like systems.
  The program shall accept as an argument the absolute path to the folder where we start to work, and support the following commands:
  `mv` WHAT WHERE – enables to transfer or rename a file if WHERE contains a file name without a path.
  `ls` – displays the current folder contents (file and subfolder names and sizes in KB)
  `cd FOLDER_NAME` – changes the current directory
