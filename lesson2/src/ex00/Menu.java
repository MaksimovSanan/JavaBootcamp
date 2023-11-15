package ex00;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    public static void main(String[] args) {

        Determinator determinator = new Determinator();
        Scanner scanner = new Scanner(System.in);
        String inputFile;

        while(!(inputFile = scanner.nextLine()).equals("42")) {
            try  {
                determinator.determineTypeOfFile(inputFile);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
