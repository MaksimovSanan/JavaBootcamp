package ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    private static String filePath = "Undefined";
    private static File currentFile;

    public static void main(String[] args) throws RuntimeException{

        Scanner scanner = new Scanner(System.in);
        for(String flag:args) {
            String[] params = flag.split("=");
            if(params[0].equals("--current-folder")) {
                filePath = params[1];
            }
        }
        if(filePath.equals("Undefined")) {
            filePath = "/Users/";
        }

        currentFile = new File(filePath);
        if(!currentFile.exists()) {
            System.err.println("Illegal argument");
            return;
        }


        while (true) {
            System.out.println(currentFile);
            System.out.print("->");
            String command = scanner.nextLine();
            String[] options = command.split(" ");
            switch(options[0]) {
                case "ls": printFile(); break;
                case "cd": changeDir(options[1]); break;
                case "mv": moveDir(options[1], options[2]); break;
                case "exit": return;
                default:
                    System.out.println("Illegal command");
            }
        }
    }

    public static void moveDir(String what, String where) {
        try {
            File sourceFile = new File(currentFile.getCanonicalPath(), what);
            File destinationFile = new File(currentFile.getCanonicalPath(), where);
            if (sourceFile.exists() && sourceFile.isFile()) {
                if (!sourceFile.renameTo(destinationFile)) {
                    System.out.println("Не удалось переместить файл.");
                }
            } else {
                System.out.println("Файл не существует или это не файл.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeDir(String fileName) {
        File newFile = null;
        try {
            newFile = new File(currentFile.getCanonicalPath(), fileName);
            if(newFile.isDirectory()) currentFile = newFile;
            else System.out.println("NOT DIRECTORY");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printFile() {
        File []listFiles = currentFile.listFiles();

        for(File elemOfFile: listFiles) {
            long length = 0;
            if(elemOfFile.isFile()) length += elemOfFile.length();
            else {
                length += folderSize(elemOfFile);
            }
            System.out.println(elemOfFile.getName() + " " + length/1000 + " KB");
        }
    }

    private static long folderSize(File elemOfFile) {
        long length = 0;
        File[] files = elemOfFile.listFiles();
        if(files == null) return length;
        for(File oneElemOfFile: files) {
            if (oneElemOfFile.isFile()) length += oneElemOfFile.length();
            else {
                length += folderSize(oneElemOfFile);
            }
        }
        return length;
    }

}
