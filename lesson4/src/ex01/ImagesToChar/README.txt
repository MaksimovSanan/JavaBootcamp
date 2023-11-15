1. To compilate class files:
    javac -d target src/java/edu/school21/printer/*/*.java
    
2.1. To compilate JAR file:
    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

3. To run JAR file:
    java -jar target/images-to-chars-printer.jar --whitePixel=<char to white pixel> --blackPixel=<char to black pixel>
    for example : java -jar target/images-to-chars-printer.jar --whitePixel=. --blackPixel=0

2.2 To run class file:
    java -cp target/resources:target edu/school21/printer/app/Program --whitePixel=<char to white pixel> --blackPixel=<char to black pixel>
    for example : java -cp target/resources:target edu/school21/printer/app/Program --whitePixel=. --blackPixel=0