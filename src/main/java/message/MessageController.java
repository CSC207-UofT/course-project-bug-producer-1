package main.java.message;



import main.java.message.UseCase.SendMailUseCase;
import main.java.order.Order;
import main.java.message.UseCase.SendMessageUseCase;

import java.util.Objects;

/**
 * This class is a controller class of the message used in the project.
 * It controls the message for the popup feedback of order for customer and the feedback of order
 * for admin when he/she require to see the order details. Apart from that, it also controls the email sent
 * by the user via email.
 * This class accept the input of the users and control the action of the program, such as creating new entities.
 * @author GEN LI (Reagan)
 */


public class MessageController {

    public Order order;

    /**
     * This method creates the message entity that will be used in the presenter of the message part.Which present the
     * messages shown in a popup way for Customer when he/she place an order. This method is responsible for creating
     * message_R entity.
     * @return Message_R type variable that contains the information needed by the message part from the order.
     */

    public Message_R create_message_R(Order order) {
        return SendMessageUseCase.create_message_R(order);
    }

    /**
     * This method sends the message typed by User via email to the receiver. The receiver is decided by the User.
     *
     * @param user_input      The user's input, which is used as the content of th email.
     * @param senderAccount   The email address of the sender.
     * @param receiverAccount The email address of the receiver.
     */

    public static void send_mail(String user_input, String senderAccount,
                                 String receiverAccount)  {
        if (Objects.equals(senderAccount, "bugproducer207@gmail.com")) {
            SendMailUseCase.send_mail_admin(user_input, senderAccount, receiverAccount);
        } else {
            SendMailUseCase.send_mail_customer(user_input, senderAccount, receiverAccount);
        }
    }

}