package Random_Revision.Observer;
import java.util.*;
public class Channel {
    String name;
    public ArrayList<Subscriber>subs;

    Channel(String n){
        this.name = n;
        subs = new ArrayList<>();
    }

    void Upload(){
        for(Subscriber i : subs){
            i.Notify(this);
        }
    }
    
}
