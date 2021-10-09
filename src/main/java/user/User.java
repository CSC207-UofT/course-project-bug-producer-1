package main.java.user;

public abstract class User {
    private final int id;
    private String pwd;
    private String acc_type;

    public User(int id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }

    public String getpwd(){
        return this.pwd;
    }
    public String getAcc_type(){
        return this.acc_type;
    }

    public void setAcc_type(String Type){
        this.acc_type = Type;
    }
}
