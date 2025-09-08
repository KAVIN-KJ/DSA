import java.util.*;

public class UserDataBase {
    HashMap<String,User> db;
    UserDataBase(){
        this.db = new HashMap<>();
    }
    boolean addUser(User u){
        if(db.containsKey(u.uid)){
            return false;
        }
        else{
            db.put(u.uid,u);
            return true;
        }
    }
    User getUser(String s){
        return db.get(s);
    }
    boolean contains(String s){
        return (db.containsKey(s));
    }
}
