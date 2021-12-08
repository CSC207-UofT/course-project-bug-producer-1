package message.useCase;


import message.Message_R;
import order.Order;


/**
 * This class is an UseCase class of the message shown to customer or admin. This kind of message is for the popup
 * feedback of order for customer and the feedback of order for admin when he/she require to see the order details.
 * This class is used for creating new message entity for Customer and Admin.
 *
 * @author GEN LI (Reagan_)
 */

public class SendMessageUseCase {

    /**
     * This method is used for the creation of the popup message entity for Customer when he/she place an order
     * or admin when he/she required to see the order detail.
     *
     * @param order An Order type variable that represents an order generated by customers.
     * @return Return the content of the message generated for the customers.
     */

    public static Message_R create_message_R(Order order) {
        return new Message_R(order);
    }


}