package Random_Revision.Builder;

public class User {
    String name,email,dept;
    int age;
    User(UserBuilder b){
        this.name = b.name;
        this.email= b.email;
        this.dept = b.dept;
        this.age  = b.age;
    }

    @Override
    public String toString() {
        return this.name+" "+this.email+" "+this.dept+" "+this.age;
    }
    public static class Builder{
        String name,email,dept;
        int age;
        Builder name(String name){
            this.name=name;
            return this;
        }
        Builder email(String em){
            this.email = em;
            return this;

        }
        Builder dept(String dp){
            this.dept = dp;
            return this;

        }
        Builder age(int a){
            this.age = a;
            return this;
        }
        // public User Build(){
        //     return new User(this);
        // }
    }
}
