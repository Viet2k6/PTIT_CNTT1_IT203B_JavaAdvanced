record User(String username, String email, String status) {}

public class Bai1 {
    public static void main(String[] args) {
        User u1 = new User("alice", "alice@gmail.com", "ACTIVE");
        User u2 = new User("bob", "bob@gmail.com", "INACTIVE");
        User u3 = new User("charlie", "charlie@gmail.com", "ACTIVE");
        java.util.List<User> users = java.util.Arrays.asList(u1, u2, u3);
        users.forEach(System.out::println);
    }
}
