package main.java.message;


import main.java.message.UseCase.SendMailUseCase_Admin;
import main.java.message.UseCase.SendMailUseCase_Customer;
import main.java.order.Order;
import main.java.message.UseCase.SendMessageUseCase;

import java.util.Objects;

/**
 * This class is a controller class of the message used in the project.
 * It controls the message for the popup feedback of order for customer and the feedback of order
 * for admin when he/she require to see the order details. Apart from that, it also controls the chat message sent
 * by the user via email.
 * This class accept the input of the users and control the action of the program according to the content of the input.
 * @author GEN LI (Reagan)
 */


public class MessageController {

    public Order order;


    /**
     * This method is an initiator of the class, which set the order attribute to the parameter order.
     *
     * @param order An Order type variable that represents an order generated by customers.
     */

    public MessageController(Order order) {
        this.order = order;
    }


    /**
     * This method generates the message shown in a popup way for Customer when he/she place an order.
     *
     * @param order An Order type variable that represents an order generated by customers.
     * @return return a message String that generated for customers.
     */

    public String generate_message_for_customer(Order order) {
        return SendMessageUseCase.generate_message_for_customer(this.order);

    }


    /**
     * This method generates the message shown for Admin when he/she require to view the details of the order.
     *
     * @param order An Order type variable that represents an order generated by customers.
     * @return return a message String that generated for admins.
     */

    public String generate_message_for_admin(Order order) {
        return SendMessageUseCase.generate_message_for_admin(order);
    }


    /**
     * This method sends the message typed by User via email to the receiver. The receiver is decided by the User.
     *
     * @param user_input      The user's input, which is used as the content of th email.
     * @param senderAccount   The email address of the sender.
     * @param receiverAccount The email address of the receiver.
     */

    public static void send_mail(String user_input, String senderAccount,
                                 String receiverAccount) throws Exception {
        if (Objects.equals(senderAccount, "bugproducer207@gmail.com")) {
            SendMailUseCase_Admin.send_mail(user_input, senderAccount, receiverAccount);
        } else {
            SendMailUseCase_Customer.send_mail(user_input, senderAccount, receiverAccount);
        }
    }
}