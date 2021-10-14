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
}