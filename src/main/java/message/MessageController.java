package main.java.message;


import main.java.order.Order;

/**
 * This class is a controller class of the message used in the project.
 * It controls the message for the popup feedback of order for customer and the feedback of order
 * for admin when he/she require to see the order details. Apart from that, it also controls the chat message sent
 * by the user via email.
 * This class accept the input of the users and control the action of the program according to the content of the input.
 * @author GEN LI
 */


public class MessageController {

    public Order order;

    /**
     * This method is an initiator of the class, which set the order attribute to the parameter order.
     * It requires an Order type variable as parameter.
     */

    public MessageController(Order order){
        this.order = order;
    }

    /**
     * This method generates the message shown in a popup way for Customer when he/she place an order.
     * The method requires an Order type variable as parameter and return a String.
     */

    public String generate_message_for_customer(Order order) {
        return SendMessageUseCase.generate_message_for_customer(this.order);

    }

    /**
     * This method generates the message shown for Admin when he/she require to view the details of the order.
     * The method requires an Order type variable as parameter and return a String.
     */

    public String generate_message_for_admin(Order order) {
        return SendMessageUseCase.generate_message_for_admin(order);
    }

    /**
     * This method sends the message typed by User via email to the receiver. The receiver is decided by the User.
     * The method return nothing and requires the input pf User, the account of the sender, the account of receiver
     * and te password of sender as parameter.
     */

    public void send_chat_message_mail(String user_input, String senderAccount,
                                       String receiverAccount, String senderPassword) throws Exception {
        SendChatMessageUseCase.sendChatMessage_mail(user_input, senderAccount, receiverAccount, senderPassword);
    }
}