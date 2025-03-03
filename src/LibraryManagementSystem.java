import models.Book;
import models.Library;
import models.Member;
import models.PremiumMember;

import java.util.Scanner;

// Main Class
public class LibraryManagementSystem {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Book Details");
            System.out.println("6. Display Member Details");
            System.out.println("7. View Issued Books Log");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    library.addBook(new Book(bookId, title, author, price));
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Membership Type (Regular/Premium): ");
                    String membershipType = scanner.nextLine();
                    try {
                        if (membershipType.equalsIgnoreCase("Premium")) {
                            System.out.print("Enter Max Books Allowed: ");
                            int maxBooksAllowed = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            library.addMember(new PremiumMember(memberId, name, membershipType, maxBooksAllowed));
                        } else {
                            library.addMember(new Member(memberId, name, membershipType));
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String issueMemberId = scanner.nextLine();
                    library.issueBook(issueBookId, issueMemberId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    library.returnBook(returnBookId);
                    break;
                case 5:
                    System.out.print("Enter Book ID to display details: ");
                    String displayBookId = scanner.nextLine();
                    library.displayBookDetails(displayBookId);
                    break;
                case 6:
                    System.out.print("Enter Member ID to display details: ");
                    String displayMemberId = scanner.nextLine();
                    library.displayMemberDetails(displayMemberId);
                    break;
                case 7:
                    library.displayIssuedBooksLog();
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}