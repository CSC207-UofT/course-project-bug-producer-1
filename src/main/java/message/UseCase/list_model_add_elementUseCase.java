package message.useCase;


import javax.swing.*;


/**
 * This is a UseCase class that can be used to add elements into the listmodel.
 * This class is responsible for an action of adding elements.
 *
 * @author GEN LI (Reagan)
 */
public class list_model_add_elementUseCase {
    /**
     * This is a method that can be used to add elements into the listmodel for customer, which is passed as a parameter
     *
     * @param listmodel a new variable that is waiting for adding elements.
     * @param order     a parameter that refers to an order entity.
     */

    public static void add_element_to_list_model_customer(DefaultListModel<String> listmodel, String[] order) {

        listmodel.addElement("<html>Order ID: " + order[1] + "<br/>Order time: " + order[2] +
                "<br/>Order items: " + order[3] + "</html>");
    }

    /**
     * This is a method that can be used to add elements into the listmodel for admin, which is passed as a parameter
     *
     * @param listmodel a new variable that is waiting for adding elements.
     * @param order     a parameter that refers to an order entity.
     */

    public static void add_element_to_list_model_admin(DefaultListModel<String> listmodel, String[] order) {

        listmodel.addElement("<html>Order ID: " + order[1] + "<br/>Order time: " + order[2] +
                "<br/>Order items: " + order[3] + "</html>" + "<br/>User name: " + order[0]);
    }

    /**
     * This is a method that can be used to add elements into the listmodel of order detail, which is passed as a parameter
     *
     * @param listmodel a listmodel that is waiting for adding elements.
     * @param item_name the name of an item in the order.
     * @param quantity  the quantity of an item in the order.
     */

    public static void add_element_to_order_detail_list_model(DefaultListModel<String> listmodel, String item_name, Integer quantity) {
        listmodel.addElement(item_name + " | " + quantity);
    }

    /**
     * This is a method that can be used to add elements into the listmodel of available goods in inventory.
     *
     * @param listmodel a listmodel that is waiting for adding elements.
     * @param item_name the name of an item from the inventory.
     * @param quantity  the quantity of an item available in the inventory.
     */

    public static void add_element_available_inventory_list_model(DefaultListModel<String> listmodel, String item_name, Integer quantity) {
        listmodel.addElement(item_name + " | " + quantity);
    }


}