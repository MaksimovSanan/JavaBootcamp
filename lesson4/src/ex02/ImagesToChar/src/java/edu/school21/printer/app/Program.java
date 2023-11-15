package edu.school21.printer.app;

import com.beust.jcommander.*;
import edu.school21.printer.logic.InputBmpFile;
import edu.school21.printer.logic.OutputTerminal;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Program {
//    @Parameter
//    private List<String> parameters = new ArrayList<>();
    @Parameter(names={"--black"})
    private static String blackPix = "RED";
    @Parameter(names={"--white"})
    private static String whitePix = "GREEN";
    @Parameter(names="--BMPPath", description = "Path to BMP file")
    private static String BMPPath = "/resources/it.bmp";
    public static void main(String[] args) {

        try{
            Program program = new Program();
            JCommander.newBuilder().addObject(program).build().parse(args);
            program.run();
        }
        catch (Exception e) {
            System.out.println("Illegal argument: " + e.getMessage());
        }
    }

    private void run() {
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
}