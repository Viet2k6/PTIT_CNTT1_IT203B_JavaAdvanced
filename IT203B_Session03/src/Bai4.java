import java.util.*;

public class Bai4{
    public static void main(String[] args) {
        record User4(String username, String email) {}
        List<User4> users = Arrays.asList(
                new User4("alice", "alice@gmail.com"),
                new User4("bob", "bob@yahoo.com"),
                new User4("alice", "alice@outlook.com"),
                new User4("charlie", "charlie@gmail.com"),
                new User4("bob", "bob@mail.com")
        );

        Set<String> seen = new HashSet<>();
        List<User4> uniqueUsers = new ArrayList<>();
        for (User4 u : users) {
            if (seen.add(u.username())) {
                uniqueUsers.add(u);
            }
        }
        uniqueUsers.forEach(System.out::println);
    }
}
