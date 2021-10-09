package main.java.user;

public class Customer extends User {
    public Customer(int id, String pwd, String Acc_Type) {
        super(id, pwd);
        this.setAcc_type(Acc_Type);
    }
}
