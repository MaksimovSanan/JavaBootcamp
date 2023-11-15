1. To compilate class files:
    javac -d target -cp lib/JColor-5.5.1.jar:lib/jcommander-1.82.jar:src/java:target/resources src/java/edu/school21/printer/app/Program.java

2.1. To compilate JAR file:
    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

3. To run JAR file:
    java -jar target/images-to-chars-printer.jar --white=<color to white pixel> --blackPixel=<color to black pixel>
    for example : java -jar target/images-to-chars-printer.jar --white WHITE --black GREEN

2.2 To run class file:
    java -cp lib/jcommander-1.82.jar:target:target/resources edu/school21/printer/app/Program