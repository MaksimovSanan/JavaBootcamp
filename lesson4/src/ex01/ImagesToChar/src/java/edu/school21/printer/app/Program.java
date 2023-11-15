package edu.school21.printer.app;

import edu.school21.printer.logic.InputBmpFile;
import edu.school21.printer.logic.OutputTerminal;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {
    private static char blackPix = '.';
    private static char whitePix = '0';
    private static String BMPPath = "/resources/it.bmp";
    public static void main(String[] args) {

        parseOptions(args);

        try {
            List<List<Boolean>> pixArray= InputBmpFile.ReadBMPFile(BMPPath);
            OutputTerminal.printTerminal(pixArray, blackPix, whitePix);
        } catch (Exception e) {
            if(BMPPath == null){
                System.out.println("Enter path to file.bmp with option --BMPPath=file.bmp");
            }
            else{
                System.out.println("File not found " + BMPPath);
            }
        }
    }

    private static void parseOptions(String[] args) {
        for(String option: args) {
            String[] optionsParam = option.split("=");
            switch (optionsParam[0]) {
                case "--blackPixel":
                    try{
                        blackPix = optionsParam[1].charAt(0);
                    }
                    catch(Exception e) {
                        System.err.println("Illegal Argument: " + option);
                        return;
                    }
                    break;
                case "--whitePixel":
                    try{
                        whitePix = optionsParam[1].charAt(0);
                    }
                    catch(Exception e) {
                        System.err.println("Illegal Argument: " + option);
                        return;
                    }
                    break;
                case "--BMPPath":
                    try{
                        BMPPath = optionsParam[1];
                    }
                    catch(Exception e) {
                        System.err.println("Illegal Argument: " + option);
                        return;
                    }
                    break;
                default:
                    System.out.println("Illegal argument - " + option);
            }
        }
    }


}
//  "../src/resources/it.bmp"