package LibraryManagement;

// Demo class to test the Library Management System
public class LibraryDemo {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library("City Central Library");
        
        // Add books
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018);
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra", 2005);
        Book book3 = new Book("978-0132350884", "Clean Code", "Robert Martin", 2008);
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        // Register members
        Member member1 = new Member("M001", "Alice Johnson", "alice@example.com");
        Member member2 = new Member("M002", "Bob Smith", "bob@example.com");
        
        library.registerMember(member1);
        library.registerMember(member2);
        
        // Display initial state
        System.out.println("=== Library Management System Demo ===");
        System.out.println(library);
        System.out.println("\nAvailable Books: " + library.getAvailableBooksCount());
        
        // Checkout books
        System.out.println("\n--- Checking out books ---");
        library.checkoutBook("M001", "978-0134685991");
        library.checkoutBook("M001", "978-0596009205");
        
        System.out.println("Member: " + member1);
        System.out.println("Borrowed: " + member1.getBorrowedCount() + " books");
        
        // Try to checkout unavailable book
        try {
            library.checkoutBook("M002", "978-0134685991");
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        
        // Return a book
        System.out.println("\n--- Returning a book ---");
        library.returnBook("M001", "978-0134685991");
        System.out.println("Member: " + member1);
        System.out.println("Available Books: " + library.getAvailableBooksCount());
        
        // Find books by author
        System.out.println("\n--- Finding books by author ---");
        var booksByAuthor = library.findBooksByAuthor("Joshua Bloch");
        booksByAuthor.forEach(System.out::println);
    }
}

