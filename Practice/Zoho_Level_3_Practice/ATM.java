package Zoho_Level_3_Practice;

import java.util.*;

class transaction {
    String type;
    float amount;

    transaction(String s, float a) {
        this.type = s;
        this.amount = a;
    }
}

class account {
    String name;
    int attempt;
    float balance;
    long acno;
    boolean isLocked;
    int pin;
    ArrayList<transaction> stmt;

    account(String name, float balace, long acno) {
        this.stmt = new ArrayList<>();
        this.balance = balace;
        this.name = name;
        this.pin = -1;
        this.isLocked = false;
        this.attempt = 3;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean auth(int pin) {

        if (this.isLocked) {
            System.out.println("Account Locked !");
            return false;
        }

        if (this.pin == pin) {
            return true;
        } else {
            this.attempt--;
            if (this.attempt == 0)
                isLocked = true;
            return false;
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        HashMap<Long, account> st = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1. Open Account\n2. WithDraw\n3. Deposit\n4.VIew Statement\n5.exit");
            int ch = in.nextInt();
            in.nextLine();
            if (ch == 1) {
                System.out.println("Opening a new Account enter A/C Number of your choice : ");
                long acn = in.nextLong();
                in.nextLine();
                System.out.println("Enter Account Name : ");
                String n = in.nextLine();
                System.out.println("Set Pin : ");
                int pin = in.nextInt();
                in.nextLine();
                account ac = new account(n, 0, acn);
                ac.setPin(pin);
                boolean auth = false;
                while (ac.attempt > 0 && !ac.isLocked) {
                    System.out.println("Enter Pin to deposit opening balance : ");
                    int ip = in.nextInt();
                    in.nextLine();
                    if (ac.auth(ip)) {
                        auth = true;
                        break;
                    } else {
                        System.out.println("Wrong Pin Please Try again");
                    }
                }
                if (auth) {
                    System.out.println("Enter Opening Balance : ");
                    float open = in.nextFloat();
                    in.nextLine();
                    ac.balance += open;
                    ac.stmt.add(new transaction("Deposit", open));
                    st.put(acn, ac);
                }
            } else if (ch == 2) {
                System.out.println("Amount Withdrawal\nEnter A/C Number : ");
                long acn = in.nextLong();
                account ac = st.getOrDefault(acn, null);
                if (ac == null) {
                    System.out.println("Accound Does Not Exist !");
                } else {
                    if (ac.isLocked) {
                        System.out.println("Account is Locked");
                        continue;
                    } else {
                        while (ac.attempt > 0 && !ac.isLocked) {
                            System.out.println("Enter PIN : ");
                            int p = in.nextInt();
                            in.nextLine();
                            if (ac.auth(p)) {
                                System.out.println("Enter Amount to Withdraw : ");
                                float a = in.nextFloat();
                                in.nextLine();
                                if (a > ac.balance) {
                                    System.out.println("Amount greater than available balance please try again");
                                } else {
                                    ac.balance -= a;
                                    ac.stmt.add(new transaction("Withdrawal", a));
                                    System.out.println("WithDrawal successful !");
                                }
                                break;
                            } else {
                                System.out.println(
                                        "Wrong Pin please try again. You are left with " + ac.attempt + " attempts");
                            }
                        }
                    }
                }
            } else if (ch == 3) {
                System.out.println("Amount Deposit\nEnter A/C Number : ");
                long acn = in.nextLong();
                account ac = st.getOrDefault(acn, null);
                if (ac == null) {
                    System.out.println("Accound Does Not Exist !");
                } else {
                    if (ac.isLocked) {
                        System.out.println("Account is Locked");
                        continue;
                    } else {
                        while (ac.attempt > 0 && !ac.isLocked) {
                            System.out.println("Enter PIN : ");
                            int p = in.nextInt();
                            in.nextLine();
                            if (ac.auth(p)) {
                                System.out.println("Enter Amount to Deposit : ");
                                float a = in.nextFloat();
                                in.nextLine();
                                ac.balance += a;
                                ac.stmt.add(new transaction("Deposit", a));
                                System.out.println("Deposit successful !");
                                break;
                            } else {
                                System.out.println(
                                        "Wrong Pin please try again. You are left with " + ac.attempt + " attempts");
                            }
                        }
                    }
                }
            } else if (ch == 4) {
                System.out.println("Mini Statement\nEnter Account Number : ");
                long acn = in.nextLong();
                account ac = st.getOrDefault(acn, null);
                if (ac == null) {
                    System.out.println("Accound Does Not Exist !");
                } else {
                    if (ac.isLocked) {
                        System.out.println("Account is Locked");
                        continue;
                    } else {
                        while (ac.attempt > 0 && !ac.isLocked) {
                            System.out.println("Enter PIN : ");
                            int p = in.nextInt();
                            in.nextLine();
                            if (ac.auth(p)) {
                                System.out.printf("%-6s %-10s %-10s\n", "S.NO", "TYPE", "AMOUNT");
                                for (int i = 0; i < ac.stmt.size(); i++) {
                                    transaction t = ac.stmt.get(i);
                                    System.out.printf("%-6d %-10s %-10.2f\n", (i + 1), t.type, t.amount);
                                }
                                break;
                            } else {
                                System.out.println("Wrong Pin please try again. You are left with " + ac.attempt + " attempts");
                            }
                        }
                    }
                }
            }
            if(ch==5){
                System.out.println("Exiting...");
                break;
            }

        }
    }
}
