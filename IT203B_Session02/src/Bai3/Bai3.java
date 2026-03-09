package Bai3;

public class Bai3 {
    public static void main(String[] args) {
        User user1 = new User("mypassword");
        User user2 = new User("");

        System.out.println("User1 authenticated: " + user1.isAuthenticated()); // true
        System.out.println("User2 authenticated: " + user2.isAuthenticated()); // false

        String encrypted = Authenticatable.encrypt("mypassword");
        System.out.println("Encrypted password: " + encrypted);
    }
}
