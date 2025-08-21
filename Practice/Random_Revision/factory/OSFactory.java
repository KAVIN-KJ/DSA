package Random_Revision.factory;

public class OSFactory {
    public OS createObject(String type){
        if(type.equals("bloat")){
            return new Windows();
        }
        else if(type.equals("opensource")){
            return new Linux();
        }
        else if(type.equals("spy")){
            return new ios();
        }
        else{
            System.out.println("Invalid Object");
            return null;
        }
    }
}
