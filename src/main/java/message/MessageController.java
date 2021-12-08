package message;

import message.useCase.SendMailUseCase;
import message.useCase.SendMessageUseCase;
import order.Order;

import javax.swing.*;
import java.util.Objects;

/**
 * This class is a controller class of the message used in the project.
 * It controls the message for the popup feedback of order for customer and the feedback of order
 * for admin when he/she require to see the order details. Apart from that, it also controls the email sent
 * by the user via email.
 * This class accept the input of the users and control the action of the program, such as creating new entities.
 *
 * @author GEN LI (Reagan)
 */


public class MessageController {


    /**
     * This method creates the message entity that will be used in the presenter of the message part.Which present the
     * messages shown in a popup way for Customer when he/she place an order. This method is responsible for creating
     * message_R entity.
     *
     * @param order this is the parameter that passed by the caller of this method, which represents an order placed by users.
     * @return Message_R type variable that contains the information needed by the message part from the order.
     */

    public static Message_R create_message_R(Order order) {
        return SendMessageUseCase.create_message_R(order);
    }

    /**
     * This is a method that is used to create a new variable of DefaultListModel.
     *
     * @return this method returns a new variable of DefaultListModel.
     */

    public static DefaultListModel<String> create_new_list_model() {
        return new DefaultListModel<>();
    }


    /**
     * This method sends the message typed by User via email to the receiver. The receiver is decided by the User.
     *
     * @param user_input      The user's input, which is used as the content of th email.
     * @param senderAccount   The email address of the sender.
     * @param receiverAccount The email address of the receiver.
     */

    public static void send_mail(String user_input, String senderAccount,
                                 String receiverAccount) {
        if (Objects.equals(senderAccount, "bugproducer207@gmail.com")) {
            SendMailUseCase.send_mail_admin(user_input, senderAccount, receiverAccount);
        } else {
            SendMailUseCase.send_mail_customer(user_input, "bugproducer.customer@gmail.com", receiverAccount);
        }
    }

}