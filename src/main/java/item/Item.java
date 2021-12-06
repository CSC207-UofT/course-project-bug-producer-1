package main.java.item;

/**
 * This class is an entity class for items in inverntory . It is a parent class and subclasses are
 * Apple, Banana, Beef and so on.
 * @author Xingru Ren
 */
public class Item {
    private final String name;
//    private final int capacity;
    private int quantity;
    /**
     * This method is the initiator of class Item.
     * It requires the name, ID, capacity and quantity of each item.
     */
    public Item(String name, int quantity){
        this.name = name;
//        this.capacity = capacity;
        this.quantity = quantity;
    }

    /**
     * This method update the quantity of item by adding specific number to quantity.
     * This method does not return anything.
     */
    public void update_quantity_in(int num){
        this.quantity = this.quantity + num;
    }


    /**
     * This method update the quantity of item by subtracting specific number to quantity.
     * This method does not return anything.
     */
    public void update_quantity_out(int num){
        this.quantity = this.quantity - num;
    }


    /**
     * This method return the name of the item.
     * This method does not require parameter.
     */
    public String getName() {
        return name;
    }

//    /**
//     * This method return the capacity of the item.
//     * This method does not require parameter.
//     */
//    public int getCapacity() {
//        return capacity;
//    }
//

    /**
     * This method return the quantity of the item.
     * This method does not require parameter.
     */
    public int getQuantity() {
        return quantity;
    }
}
