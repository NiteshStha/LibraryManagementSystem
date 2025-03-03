package models;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;
    private boolean availability;
    private static int totalBooksIssued = 0;

    // Constructor
    public Book(String bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true; // By default, the book is available
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // Method to issue a book
    public void issueBook() throws Exception {
        if (availability) {
            availability = false;
            totalBooksIssued++;
            System.out.println("Book issued: " + title);
        } else {
            throw new Exception("Book is not available.");
        }
    }

    // Method to return a book
    public void returnBook() {
        availability = true;
        System.out.println("Book returned: " + title);
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
    }

    // Static method to get total books issued
    public static int getTotalBooksIssued() {
        return totalBooksIssued;
    }
}