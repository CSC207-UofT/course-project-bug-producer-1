package item.useCase;

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
            if (!csv.exists()) {
                boolean newFile = csv.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            String c = Integer.toString(capacity);
            String values = name + "," + c;

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
     * @return A hashmap of items
     */

    public static HashMap<String, Integer> readItems() throws IOException {
        File csv = new File("itemname.csv");
          if (!csv.exists()) {
              boolean newFile = csv.createNewFile();
          }
        HashMap<String, Integer> result = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String s;
            // Reads it line by line

            br.readLine();
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                String key = values[0];
                int capacity = Integer.parseInt(values[1]);
                result.put(key, capacity);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}