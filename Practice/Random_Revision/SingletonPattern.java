package Random_Revision;

class Demo{
    private static Demo obj;
    private Demo() {}
    public static Demo getObj(){
        if(obj==null){
            obj=new Demo();
        }
        return obj;
    } 
}

public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println(Demo.getObj());
        System.out.println(Demo.getObj());
        System.out.println(Demo.getObj());
        System.out.println(Demo.getObj());
    }
}

