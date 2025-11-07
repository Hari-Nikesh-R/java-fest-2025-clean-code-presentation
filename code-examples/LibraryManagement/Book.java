package LibraryManagement;

// Book class - Represents a book in the library
public class Book {
    // Encapsulated fields
    private String isbn;
    private String title;
    private String author;
    private int yearPublished;
    private boolean isAvailable;
    
    // Constructor
    public Book(String isbn, String title, String author, int yearPublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isAvailable = true;  // New books are available by default
    }
    
    // Getters
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYearPublished() {
        return yearPublished;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setters with validation
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    // Business logic methods
    public void checkout() {
        if (!isAvailable) {
            throw new IllegalStateException("Book is already checked out");
        }
        this.isAvailable = false;
    }
    
    public void returnBook() {
        if (isAvailable) {
            throw new IllegalStateException("Book is already available");
        }
        this.isAvailable = true;
    }
    
    @Override
    public String toString() {
        return String.format("Book{isbn='%s', title='%s', author='%s', year=%d, available=%s}",
                isbn, title, author, yearPublished, isAvailable);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }
    
    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }
}

