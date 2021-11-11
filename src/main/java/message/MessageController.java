package main.java.message;


import main.java.order.Order;



public class MessageController {

    public Order order;
    public MessageController(Order order){
        this.order = order;
    }


    public String generate_message_for_customer(Order order) {
        return SendMessageUseCase.generate_message_for_customer(this.order);

    }

    public String generate_message_for_admin(Order order) {
        return SendMessageUseCase.generate_message_for_admin(order);
    }
    public void send_chat_message_mail(String user_input, String senderAccount,
                                       String receiverAccount, String senderPassword) throws Exception {
        SendChatMessageUseCase.sendChatMessage_mail(user_input, senderAccount, receiverAccount, senderPassword);
    }
}