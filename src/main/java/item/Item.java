package item;

/**
 * This class is an entity class for items in inverntory . It is a parent class and subclasses are
 * Apple, Banana, Beef and so on.
 * @author Xingru Ren
 */
public class Item {
    private final String name;
    private int quantity;
    /**
     * This method is the initiator of class Item.
     * It requires the name and quantity of each item.
     */
    public Item(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * This method return the name of the item.
     * This method does not require parameter.
     */
    public String getName() {
        return name;
    }


    /**
     * This method return the quantity of the item.
     * This method does not require parameter.
     */
    public int getQuantity() {
        return quantity;
    }
}
