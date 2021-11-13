package test.java.message;

import main.java.message.SendMessageUseCase;
import main.java.order.Order;
import org.junit.Assert;
import org.junit.Test;

public class Test_for_message {
    @Test
    public void test_generate_message_for_customer(){
        Order order = new Order();
        String expect = "Dear Customer," + "\n" + " We are trying our best to process your order." + "\n" +
                "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" + order_status +
                "Thank you for your patience and have a nice day!" + message_date;
        String actual = SendMessageUseCase.generate_message_for_customer(order);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_generate_message_for_admin(){
        Order order = new Order();
        String expect = "Order details: " + order_id + "\n" + order_date + "\n" + item_list + "\n" +
                order_status + message_date;
        String actual = SendMessageUseCase.generate_message_for_customer(order);
        Assert.assertEquals(expect, actual);
    }
}
