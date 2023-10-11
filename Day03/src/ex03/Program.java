package ex03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {

    private static String fileWithUrls = "ex03//files_urls.txt";
    private static int threadsCount = 3;

    public static void main(String[] args) {

        parseOptions(args);

        File folderToDownloads = new File("Downloads");
        if(!folderToDownloads.exists()) {
            folderToDownloads.mkdir();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        try (BufferedReader br = new BufferedReader(new FileReader(fileWithUrls));){
            String url;
            while((url = br.readLine()) != null) {
                try{
                    String[] data = url.split(" ");
                    String URLPath = data[1];
                    int filesCount = Integer.parseInt(data[0]);
                    executorService.submit(new DownloaderFromURL(data[1], filesCount));
                }
                catch (Exception e) {
                    throw new RuntimeException(e + "\nreason: " + url);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    private static void parseOptions(String[] args) {
        for(String option: args) {
            String[] optionsParam = option.split("=");
            switch (optionsParam[0]) {
                case "--threadsCount":
                    try{
                         threadsCount = Integer.parseInt(optionsParam[1]);
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