package ex00;

import java.io.*;
import java.util.*;

public class Determinator {
    private final TreeMap<String, List<Integer>> signatures;

    public Determinator() {
        signatures = ParserSignatures.parseSignatures();
    }

    public void determineTypeOfFile(String inputFile) throws Exception{
//        TreeMap<String, List<Integer>> signatures = ParserSignatures.parseSignatures();

        try (FileInputStream FI = new FileInputStream(inputFile);
        BufferedWriter BW = new BufferedWriter(new FileWriter("./src/ex00/res.txt", true))) {
            byte[] prefix = new byte[8];
            int status = FI.read(prefix, 0, 8);
            boolean find = false;
            for(Map.Entry<String, List<Integer>> signature: signatures.entrySet()) {
                find = true;
                for(int i = 0; i < signature.getValue().size(); ++i) {
                    byte tmp = signature.getValue().get(i).byteValue();
                    if(tmp != prefix[i]) {
                        find = false;
                        break;
                    }
                }
                if(find) {
                    BW.write(signature.getKey() + '\n');
                    break;
                }
            }
            if(!find) BW.write("UNDEFINED" + '\n');
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}