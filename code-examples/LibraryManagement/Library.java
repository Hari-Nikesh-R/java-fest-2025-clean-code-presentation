package LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Library class - Manages books and members
public class Library {
    // Encapsulated fields
    private String name;
    private List<Book> books;
    private List<Member> members;
    
    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public List<Book> getBooks() {
        return new ArrayList<>(books);  // Return copy for encapsulation
    }
    
    public List<Member> getMembers() {
        return new ArrayList<>(members);  // Return copy for encapsulation
    }
    
    // Book management methods
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (books.contains(book)) {
            throw new IllegalStateException("Book already exists in library");
        }
        books.add(book);
    }
    
    public void removeBook(Book book) {
        if (!books.contains(book)) {
            throw new IllegalStateException("Book not found in library");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("Cannot remove book that is checked out");
        }
        books.remove(book);
    }
    
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
    
    public List<Book> findAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
    
    // Member management methods
    public void registerMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        if (members.contains(member)) {
            throw new IllegalStateException("Member already registered");
        }
        members.add(member);
    }
    
    public Member findMemberById(String memberId) {
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }
    
    // Transaction methods
    public void checkoutBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found");
        }
        
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        
        member.borrowBook(book);
    }
    
    public void returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member not found");
        }
        
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        
        member.returnBook(book);
    }
    
    // Reporting methods
    public int getTotalBooks() {
        return books.size();
    }
    
    public int getAvailableBooksCount() {
        return (int) books.stream().filter(Book::isAvailable).count();
    }
    
    public int getTotalMembers() {
        return members.size();
    }
    
    @Override
    public String toString() {
        return String.format("Library{name='%s', books=%d, members=%d}",
                name, books.size(), members.size());
    }
}

