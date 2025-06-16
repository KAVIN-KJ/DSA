package Zoho_Level_3_Practice;

import java.util.*;

class Book {
    int id;
    String title, author, status;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = "Available";
    }

    public void display() {
        System.out.printf("%-6d %-20s %-20s %-20s\n", id, title, author, status);
    }

}

public class BookIssueing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Book> mp = new HashMap<>();
        while (true) {
            System.out.println(
                    "\n\nWelcome to the Library\n\n1. Add Book\n2.Issue Book\n3. Return Book\n4. View Books\n5.Exit");
            System.out.println("Enter Choice : ");
            int i = in.nextInt();
            in.nextLine();
            if (i == 1) {
                System.out.println("Adding a new Book : \nEnter ID : ");
                int id = in.nextInt();
                in.nextLine();
                if (mp.getOrDefault(id, null) != null) {
                    System.out.println("Book already exists with ID " + id);
                    continue;
                }
                System.out.println("Enter Title : ");
                String title = in.nextLine();
                System.out.println("Enter Author : ");
                String author = in.nextLine();
                Book b = new Book(id, title, author);
                mp.put(id, b);
                System.out.println("Book added Successfully");
            }
            if (i == 2) {
                System.out.println("Issueing a book : \nEnter ID : ");
                int id = in.nextInt();
                in.nextLine();
                Book b = mp.getOrDefault(id, null);
                if (b == null) {
                    System.out.println("No Book exists with ID " + id);
                    continue;
                }
                b.status = "Issued";
                System.out.println("Book Issued Succesfully");

            }
            if (i == 3) {
                System.out.println("Returning a book : \nEnter ID : ");
                int id = in.nextInt();
                in.nextLine();
                Book b = mp.getOrDefault(id, null);
                if (b == null) {
                    System.out.println("No Book exists with ID " + id);
                    continue;
                }
                b.status = "Available";
                System.out.println("Book Returned Succesfully");
            }
            if (i == 4) {
                System.out.printf("\n%-6s %-20s %-20s %-20s\n", "ID", "TITLE", "AUTHOR", "STATUS");

                for (int x : mp.keySet()) {
                    mp.get(x).display();
                }
            }
            if (i == 5) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
