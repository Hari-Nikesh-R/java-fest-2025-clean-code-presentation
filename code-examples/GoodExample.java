// GOOD EXAMPLE - Well-structured code
public class UserAccount {
    private int userId;
    private String username;
    
    public UserAccount(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }
    
    public void validateAndDisplay() {
        if (isValidUser()) {
            displayUserInfo();
        }
    }
    
    private boolean isValidUser() {
        return userId > 0 && username != null && username.length() > 5;
    }
    
    private void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
    }
    
    public static void main(String[] args) {
        UserAccount account = new UserAccount(10, "hello world");
        account.validateAndDisplay();
    }
}

