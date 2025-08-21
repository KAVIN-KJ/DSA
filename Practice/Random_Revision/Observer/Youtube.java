package Random_Revision.Observer;

public class Youtube {
    public static void main(String[] args) {
        Channel KJKR = new Channel("KJKR");
        Subscriber s1 = new Subscriber("AAAAA");
        Subscriber s2 = new Subscriber("BBBBB");
        Subscriber s3 = new Subscriber("CCCCC");
        Subscriber s4 = new Subscriber("DDDDD");
        Subscriber s5 = new Subscriber("EEEEE");

        s1.subscribe(KJKR);
        s2.subscribe(KJKR);
        s3.subscribe(KJKR);
        s4.subscribe(KJKR);
        s5.subscribe(KJKR);

        KJKR.Upload();

    }
}
