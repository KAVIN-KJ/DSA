import java.util.*;

public class User{
    String name,mob,email,pwd,uid;
    Bank bankAcc;
    List<String> bills;
    int balance;
    User(String un,String pw,String n,String em,String mo){
        this.uid = un;
        this.pwd = pw;
        this.name= n;
        this.email = em;
        this.mob = mo;
        this.balance = 4000;
        this.bills = new ArrayList<>();
    }
    public void setBankAcc(Bank bankAcc) {
        this.bankAcc = bankAcc;
    }
    public void purchase(String cat,int amt, String date){
        if(balance-amt>=0){
            bills.add("TXT-ype - Debit, Category - "+cat+", "+" Rs. "+amt+", "+"Date - "+date+ ", Status - Success");
            balance-=amt;
        }
        else{
            bills.add("TX-Type - Debit, Category - "+cat+", "+" Rs. "+amt+", "+"Date - "+date+ ", Status - Failed");
        }
    }
    @Override
    public String toString() {
        return "Name : "+name+" Wallet Balance : "+balance;
    }
    

}