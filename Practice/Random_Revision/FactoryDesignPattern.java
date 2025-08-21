package Random_Revision;
import Random_Revision.factory.OS;
import Random_Revision.factory.OSFactory;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        OSFactory osf = new OSFactory();
        OS os1 = osf.createObject("bloat");
        OS os2 = osf.createObject("opensource");
        OS os3 = osf.createObject("spy");
        os1.details();
        os2.details();
        os3.details();
    }
}
