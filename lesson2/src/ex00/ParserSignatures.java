package ex00;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ParserSignatures {

    public static TreeMap<String, List<Integer>> parseSignatures(String fileName) {
        return parse(fileName);
    }

    public static TreeMap<String, List<Integer>> parseSignatures() {
        String defaultFileNameSignatures = "/Users/songrash/proj/Java/Java_Bootcamp.Day02-1/src/ex00/signatures.txt";
        return parse(defaultFileNameSignatures);
    }

    private static TreeMap<String, List<Integer>> parse(String fileName) {
        TreeMap<String, List<Integer>> signatures = new TreeMap<>();
        try(BufferedReader FBR = new BufferedReader(new FileReader(fileName))) {
            String signature;
            while((signature = FBR.readLine()) != null) {
                String []tmp = signature.split(", ");
                String type = tmp[0];
                String []bytesStr = tmp[1].split(" ");
                List<Integer> bytes = new ArrayList<>();
                for(String byteStr: bytesStr) {
                    bytes.add(Integer.parseInt(byteStr, 16));
                }
                signatures.put(tmp[0], bytes);
            }
        }
        catch (Exception e) {
            System.out.println("File \"" + fileName + "\" FUCKING BAD" + e.getMessage());
        }
        return signatures;
    }

}
