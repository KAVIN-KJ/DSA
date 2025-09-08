public class Bank {
    String name,acc,uname;
    int balance;
    Bank(String n,String acc,String uname){
        this.name = n;
        this.acc = acc;
        this.uname = uname;
        this.balance = 10000;
    }
    @Override
    public String toString() {
        return name+" Acc.No : "+acc+" User Name : "+uname+" Balance : "+balance;
    }

    public void debit(int amt){
        if(balance-amt>=0){
            System.out.println("Amount Debited succesfully");
            balance-=amt;
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

}
