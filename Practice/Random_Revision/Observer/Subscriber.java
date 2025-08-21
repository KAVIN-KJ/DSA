package Random_Revision.Observer;

import java.util.ArrayList;

public class Subscriber {
    String name;
    ArrayList<Channel> ch;
    Subscriber(String name){
        this.name = name;
        ch = new ArrayList<>();
    }
    void subscribe(Channel c){
        c.subs.add(this);
        ch.add(c);
    }
    void unsubscribe(Channel c){
        c.subs.remove(c);
        ch.remove(c);
    }
    void Notify(Channel c){
        System.out.println("Hey "+name+" Check out this video from "+c.name);
    }
}
