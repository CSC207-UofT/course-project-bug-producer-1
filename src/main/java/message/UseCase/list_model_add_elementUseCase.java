package main.java.message.UseCase;



import javax.swing.*;



/**
 * This is a UseCase class that can be used to add elements into the listmodel.
 * This class is responsible for an action of adding elements.
 */
public class list_model_add_elementUseCase {
    /**
     * This is a method that can be used to add elements into the listmodel, which is passed as a parameter
     * @param listmodel a new variable that is waiting for adding elements.
     * @param order a parameter that refers to an order entity.
     */

    public static void add_element_to_list_model(DefaultListModel<String> listmodel, String order){

        String[] helper = order.split(",");
        listmodel.addElement("<html>Order ID: " + helper[0] + "<br/>Order time: " + helper[1] +
                "<br/>Order items: " + helper[2] +"</html>");
    }

    /**
     * This is a method that can be used to add elements into the listmodel of order detail, which is passed as a parameter
     * @param listmodel a new variable that is waiting for adding elements.
     * @param item_name the name of an item in the order.
     * @param quantity the quantity of an item in the order
     */

    public static void add_element_to_order_detail_list_model(DefaultListModel<String> listmodel, String item_name, Integer quantity){
        listmodel.addElement(item_name + "|" + quantity);
    }

}