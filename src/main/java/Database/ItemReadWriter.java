package main.java.Database;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;



public class ItemReadWriter {
    /**
     * Writes the items to file at filePath.
     * @param name A string representing the item name
     * @param capacity An integer representing the item capacity
     */

    public static void writeItems(String name, int capacity) throws IOException {
        try {
            File csv = new File("itemname.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));

            String values = name + "," + capacity;

            bw.newLine();
            bw.write(values);

            bw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Store the items to file at filePath.
     * @return A list of items
     */

//    public static HashMap<String, Integer> readItems() throws IOException {
////        File csv = new File("itemname.csv ");
////        HashMap<String, Integer> result = new HashMap<>();
////        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
////            String s;
////            // Reads it line by line
////            br.readline();
////            while ((s = br.readLine()) != null) {
////                String[] values = s.split(",");
////                result.put(values[0], values[1])
////            }
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////        return result;
//    }
}