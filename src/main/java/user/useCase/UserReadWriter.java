package user.useCase;

import java.io.*;
import java.util.ArrayList;


@SuppressWarnings("unused")
public class UserReadWriter {
    /**
     * Writes the users to file at filePath.
     *
     * @param name       A string representing username
     * @param user_email A string representing user's email
     * @param pwd        A string representing user's password
     * @param type       A string representing user's type
     */

    public static void writeUsers(String name, String user_email, String pwd, String type) throws IOException {
        try {
            File csv = new File("userdatabase.csv");
            if (!csv.exists()) {
                boolean newFile = csv.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));

            String values = name + "," + user_email + "," + pwd + "," + type;
            bw.write(values);
            bw.newLine();

            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Store the users to file at filePath.
     *
     * @return A list of user
     */
    public static ArrayList<String[]> readUsers() throws IOException {
        File csv = new File("userdatabase.csv");
        ArrayList<String[]> result = new ArrayList<>();
        if (!csv.exists()) {
            boolean newFile = csv.createNewFile();
        }
        FileReader fileReader = new FileReader(csv);
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String s;
            // Reads it line by line
            while ((s = br.readLine()) != null) {
                String[] values = s.split(",");
                result.add(values);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
