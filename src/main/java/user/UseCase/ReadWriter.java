package main.java.user.UseCase;

import java.io.IOException;
import java.util.ArrayList;

public interface ReadWriter {
    void writeUsers () throws IOException;

    static ArrayList<String[]> readUsers() throws IOException {
        return null;
    }
}
