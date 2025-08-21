package Random_Revision.Builder;

public class UserBuilder {
    String name,email,dept;
    int age;

    UserBuilder name(String name){
        this.name = name;
        return this;
    }

    UserBuilder email(String s){
        this.email =s;
        return this;
    }

    UserBuilder dept(String s){
        this.email = s;
        return this;
    }

    UserBuilder age(int a){
        this.age = a;
        return this;
    }

    User Build(){
        return new User(this);
    }
}
