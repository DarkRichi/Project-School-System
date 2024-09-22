import java.util.HashMap;

public class Account {
    HashMap<String,String> User = new HashMap<String,String>();
    HashMap<String,String> Admin = new HashMap<String,String>();

    Account(){
        User("Dara","123");
        Admin("Chetra","1");

    }

    void User(String username, String password){
        User.put(username, password);
    }
    void Admin(String username, String password){
        Admin.put(username, password);
    }
    protected HashMap getuserInfo(){
        return User;
    }
    protected HashMap getadminInfo(){
        return Admin;
    }
}
