
package java.order;
import main.java.item.*;
import main.java.order.Order;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;
import main.java.order.OrderGenerateUseCase;
import java.util.Date;
package test.java.order;

public class OrderControllerTest {
    HashMap<Item, Integer> f;
    HashMap<Item, Integer> k;
    Order m;
    Order n;

    @Before
    public void setUp(){
        Item a = new Apple("apple",123, 1, 3);
        Item b = new Banana("banana",344,1,2);
        Item c = new Beef("Beef",987,2,4);
        Item d = new Carrot("carrot",555,1,7);
        Date z = new Date();
        f = new HashMap<>();
        k = new HashMap<>();
        f.put(a,a.getQuantity());
        f.put(b, b.getQuantity());
        k.put(a,a.getQuantity());
        k.put(b, b.getQuantity());
        k.put(c, c.getQuantity());
        k.put(d, d.getQuantity());
        m = OrderGenerateUseCase.Generate_order_customer(z,f);
        n = OrderGenerateUseCase.Generate_order_customer(z,k);
    }

    @Test(timeout = 50)
    public void Test_Order_customer() {
        assertEquals(m.get_item_list(),f);
        assertEquals(n.get_item_list(),k);
        assertEquals(m.get_status(),"Order_out");
        assertEquals(n.get_status(),"Order_in");
    }
}
