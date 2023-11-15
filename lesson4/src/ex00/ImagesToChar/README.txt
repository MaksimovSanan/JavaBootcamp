1. To compilate:
    javac -d target src/java/edu/school21/printer/*/*.java

2. To run:
    java -cp target/ edu/school21/printer/app/Program --BMPPath=<path to file.bmp> --whitePixel=<char to white pixel> --blackPixel=<char to black pixel>
    for example : java -cp target/ edu/school21/printer/app/Program --BMPPath=src/resources/it.bmp --whitePixel=. --blackPixel=0