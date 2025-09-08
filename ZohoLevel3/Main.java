import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UserDataBase db = new UserDataBase();
        User currentUser = null;
        HashMap<String, Integer> mpp = new HashMap<>();
        mpp.put("dining", 400);
        mpp.put("books", 200);
        mpp.put("travel", 600);
        mpp.put("subscription", 1000);
        mpp.put("entertainment", 400);
        while (true) {
            if (currentUser == null) {
                System.out.println("*******Welcome to Zoho Wallet !******");
                System.out.println("1. Signin\n2. Signup\n10.Exit");
                String ch = in.nextLine();
                if (ch.equals("1")) {
                    System.out.println("Enter your user name : ");
                    String uname = in.nextLine();
                    User tp = db.getUser(uname);
                    if (tp != null) {
                        System.out.println("Enter Password : ");
                        String pwd = "";
                        for (int i = 3; i >= 0; i--) {
                            pwd = in.nextLine();
                            if (db.getUser(uname).pwd.equals(pwd)) {
                                System.out.println("Login Succesfull ! welcome back " + tp.name);
                                currentUser = tp;
                                break;
                            } else {
                                System.out
                                        .println("Incorrect password, Please try again\nAttempts remaining : "
                                                + (i + 1));
                            }
                        }
                    } else {
                        System.out.println("Invalid UserName");
                    }
                } else if (ch.equals("2")) {
                    System.out.println("Creating a new Account");
                    System.out.println("Enter yout Full name : ");
                    String n = in.nextLine();
                    System.out.println("Enter your email Address : ");
                    String em = in.nextLine();
                    System.out.println("Enter your mobile number : ");
                    String mob = in.nextLine();
                    System.out.println("Enter your unique User_Name : ");
                    String uid = in.nextLine();
                    int cnt = 3;
                    boolean br = false;
                    while (db.contains(uid)) {
                        System.out.println(
                                "That user name is Taken, Please try something else : (Enter \'exit\' to exit)");
                        uid = in.nextLine();
                        if (uid.equals("exit")) {
                            br = true;
                            break;
                        }
                    }
                    if (br)
                        continue;
                    System.out.println("Set your password : ");
                    String pwd = in.nextLine();
                    User newuser = new User(uid, pwd, n, em, mob);
                    db.addUser(newuser);
                    System.out.println("Welcome to Zoho Wallet " + newuser.name);
                } else if (ch.equals("10")) {
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            } else {
                while (true) {
                    System.out.println(
                            "1. Update Bank Details\n2. Pay Or Purchase" +
                                    "\n3. Transaction History\n4. Bill Generation" +
                                    "\n5.Rewards\n6.Penalties\n7.Freeze accounts\n8.Logout");
                    System.out.println("Enter your choice : ");
                    String ch = in.nextLine();
                    // EXIT
                    if (ch.equals("8")) {
                        currentUser = null;
                        break;
                    }
                    // BANK DETAILS
                    else if (ch.equals("1")) {
                        if (currentUser.bankAcc == null) {
                            System.out.println(
                                    "You haven't set up your bank account yet, Please enter your Account Details ");
                            System.out.println("Enter Bank Name : ");
                            String n = in.nextLine();
                            System.out.println("Enter Your Account number : ");
                            String acc = in.nextLine();
                            System.out.println("Enter your name in your Bank Account : ");
                            String acnam = in.nextLine();
                            Bank b = new Bank(n, acc, acnam);
                            currentUser.setBankAcc(b);
                        } else {
                            System.out.println("Bank Details Updation Page : ");
                            Bank b = currentUser.bankAcc;
                            while (true) {
                                System.out.println("*********************\n");
                                System.out.println("Current Bank Details : ");
                                System.out.println(b.toString());
                                System.out.println("\n*********************");
                                System.out.println("What do you want to update in your Account ? \n1. Account Number" +
                                        "\n2. Account Name\n3. Bank Name\n4. Exit");
                                System.out.println("Enter your choice : ");
                                ch = in.nextLine();
                                if (ch.equals("1")) {
                                    System.out.println("Enter new Account Number : ");
                                    String an = in.nextLine();
                                    b.acc = an;
                                } else if (ch.equals("2")) {
                                    System.out.println("Enter new Account Name : ");
                                    String an = in.nextLine();
                                    b.uname = an;
                                } else if (ch.equals("3")) {
                                    System.out.println("Enter new Bank Name : ");
                                    String an = in.nextLine();
                                    b.name = an;
                                } else if (ch.equals("4")) {
                                    break;
                                } else {
                                    System.out.println("Invalid Choice");
                                }
                            }
                        }
                    }
                    // PAY OR PURCHASE
                    else if (ch.equals("2")) {
                        System.out.println("Choose Category of purchase : ");
                        System.out.println("1. Dining");
                        System.out.println("2. Books");
                        System.out.println("3. Travel");
                        System.out.println("4. Subscription");
                        System.out.println("5. Entertainment");
                        System.out.println("6. Exit");
                        ch = in.nextLine();
                        String cat = "";
                        if (ch.equals("1"))
                            cat = "dining";
                        else if (ch.equals("2"))
                            cat = "books";
                        else if (ch.equals("3"))
                            cat = "travel";
                        else if (ch.equals("4"))
                            cat = "subscription";
                        else if (ch.equals("5"))
                            cat = "entertainment";
                        else if (ch.equals("6"))
                            continue;
                        System.out.println("Enter Purchase amount : ");
                        int amt = in.nextInt();
                        in.nextLine();
                        System.out.println("Enter Purchase Date");
                        String date = in.nextLine();
                        System.out.println("Choose Payment Method : ");
                        System.out.println("1. Bank\n2.Wallet\n3.Exit");

                        System.out.println("Your wallet Details : ");
                        System.out.println(currentUser.toString());
                        
                        System.out.println("Your Bank Details");
                        System.out.println(currentUser.bankAcc!=null ? currentUser.bankAcc.toString() : "Bank Not configured yet");

                        ch = in.nextLine();
                        if (ch.equals("1")) {
                            System.out.println("Payment by Bank Account");
                            if (currentUser.bankAcc == null) {
                                System.out.println(
                                        "Youn Haven't Configured your bank details, Please COnfigure it in the Main menu");
                                continue;
                            }
                            OTP x = new OTP();
                            System.out.println("An OTP has been sent to you, Please enter it : ");
                            for (int i = 3; i >= 0; i--) {
                                String otp = in.nextLine();
                                if (x.otp.equals(otp)) {
                                    System.out.println("You are authorised");
                                    currentUser.bankAcc.debit(amt);
                                    break;
                                } else {
                                    System.out.println("Please enter Correct OTP Attempts remaining : " + (i + 1));
                                }
                            }
                        } else if (ch.equals("2")) {
                            System.out.println("Payment by Wallet");
                            OTP x = new OTP();
                            System.out.println("An OTP has been sent to you, Please enter it : ");
                            for (int i = 3; i >= 0; i--) {
                                String otp = in.nextLine();
                                if (x.otp.equals(otp)) {
                                    System.out.println("You are authorised");
                                    currentUser.purchase(cat, amt, date);
                                    System.out.println("Payment Succesful");
                                    break;
                                } else {
                                    System.out.println("Please enter Correct OTP Attempts remaining : " + (i + 1));
                                }
                            }
                        }

                    }
                    // TRANSACTION HISTORY
                    if (ch.equals("3")) {
                        for (String s : currentUser.bills) {
                            System.out.println(s);
                        }
                    }
                    // INVALID CHOICE
                    else {
                        System.out.println("Enter a valid choice");
                    }
                }
            }

        }
    }
}
