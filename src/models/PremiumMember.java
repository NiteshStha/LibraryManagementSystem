package models;

public class PremiumMember extends Member {
    private int maxBooksAllowed;

    // Constructor
    public PremiumMember(String memberId, String name, String membershipType, int maxBooksAllowed) {
        super(memberId, name, membershipType);
        this.maxBooksAllowed = maxBooksAllowed;
    }

    // Override borrowBook method for additional functionality
    @Override
    public void borrowBook(Book book) throws Exception {
        System.out.println("Premium member borrowing book: " + book.getTitle());
        super.borrowBook(book);
    }
}
