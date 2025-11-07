package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

// Member class - Represents a library member
public class Member {
    // Encapsulated fields
    private String memberId;
    private String name;
    private String email;
    private List<Book> borrowedBooks;
    private int maxBorrowLimit;
    
    // Constructor
    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
        this.maxBorrowLimit = 5;  // Default limit
    }
    
    // Getters
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);  // Return copy for encapsulation
    }
    
    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }
    
    // Setters with validation
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }
    
    public void setMaxBorrowLimit(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("Borrow limit must be at least 1");
        }
        this.maxBorrowLimit = limit;
    }
    
    // Business logic methods
    public boolean canBorrowMore() {
        return borrowedBooks.size() < maxBorrowLimit;
    }
    
    public void borrowBook(Book book) {
        if (!canBorrowMore()) {
            throw new IllegalStateException("Member has reached borrow limit");
        }
        if (borrowedBooks.contains(book)) {
            throw new IllegalStateException("Book already borrowed by this member");
        }
        book.checkout();
        borrowedBooks.add(book);
    }
    
    public void returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            throw new IllegalStateException("Member did not borrow this book");
        }
        book.returnBook();
        borrowedBooks.remove(book);
    }
    
    public int getBorrowedCount() {
        return borrowedBooks.size();
    }
    
    @Override
    public String toString() {
        return String.format("Member{id='%s', name='%s', email='%s', borrowed=%d/%d}",
                memberId, name, email, borrowedBooks.size(), maxBorrowLimit);
    }
}

