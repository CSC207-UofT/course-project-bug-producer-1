package main.java.Database;

import java.io.*;
import java.util.ArrayList;



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
    public static ArrayList<String[]> readItems() throws IOException {
        File csv = new File("itemname.csv ");
        ArrayList<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                result.add(values);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}