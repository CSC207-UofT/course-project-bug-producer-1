package main.java.user;

public class Admin extends User{
    public Admin(int id, String pwd, String Acc_Type) {
        super(id, pwd);
        this.setAcc_type(Acc_Type);
    }
}
