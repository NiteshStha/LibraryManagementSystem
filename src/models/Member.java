package models;

public class Member {
    private String memberId;
    private String name;
    private String membershipType;

    // Constructor
    public Member(String memberId, String name, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    // Method to register a member
    public void registerMember() {
        System.out.println("Member registered: " + name);
    }

    // Method to borrow a book
    public void borrowBook(Book book) throws Exception {
        book.issueBook();
    }

    // Method to return a book
    public void returnBook(Book book) {
        book.returnBook();
    }
}