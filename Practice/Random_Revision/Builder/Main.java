package Random_Revision.Builder;
public class Main {
    public static void main(String[] args) {
        User u = new UserBuilder().name("KJKR").age(20).email("kavinkj2004@gmail.com").Build();
        System.out.println(u.toString());
    }
}
