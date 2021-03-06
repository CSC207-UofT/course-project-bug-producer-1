package item;

import item.useCase.ItemReadWriter;

import java.io.IOException;
import java.util.HashMap;

/**
 * Gateway controls the interaction between database and use cases.
 */
public class Gateway {


    public static void writeItems(String name, int capacity) throws IOException {
        ItemReadWriter.writeItems(name, capacity);

    }

    public static HashMap<String, Integer> readItems() throws IOException {
        return ItemReadWriter.readItems();
    }
}
