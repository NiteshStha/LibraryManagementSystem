package models;

import java.io.*;
import java.util.*;

// Library Class
public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private Set<String> memberIds = new HashSet<>();

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Method to add a member
    public void addMember(Member member) throws Exception {
        if (memberIds.contains(member.getMemberId())) {
            throw new Exception("Error: Member ID already exists.");
        } else {
            memberIds.add(member.getMemberId());
            members.add(member);
            member.registerMember();
        }
    }

    // Method to issue a book to a member
    public void issueBook(String bookId, String memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book != null && member != null) {
            if (book.isAvailable()) {
                try {
                    member.borrowBook(book);
                    logIssuedBook(book, member);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("Book or Member not found.");
        }
    }

    // Method to return a book
    public void returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to display book details
    public void displayBookDetails(String bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.displayDetails();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to display member details
    public void displayMemberDetails(String memberId) {
        Member member = findMemberById(memberId);
        if (member != null) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Membership Type: " + member.getMembershipType());
        } else {
            System.out.println("Member not found.");
        }
    }

    // Method to log issued books to a file
    public void logIssuedBook(Book book, Member member) {
        try (FileWriter writer = new FileWriter("IssuedBooks.txt", true)) {
            writer.write("BookID: " + book.getBookId() + ", Title: " + book.getTitle() +
                    ", Issued to MemberID: " + member.getMemberId() + ", Name: " + member.getName() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    // Method to display issued books log
    public void displayIssuedBooksLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader("IssuedBooks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    // Helper method to find a book by ID
    private Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find a member by ID
    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}