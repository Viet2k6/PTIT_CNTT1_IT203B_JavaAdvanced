import java.util.Arrays;
import java.util.List;

class User2 {
    private String username;
    private String email;
    public User2(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
public class Bai2 {
    public static void main(String[] args) {
        List<User2> users = Arrays.asList(
                new User2("alice", "alice@gmail.com"),
                new User2("bob", "bob@yahoo.com"),
                new User2("charlie", "charlie@gmail.com")
        );

        users.stream()
                .filter(u -> u.getEmail().endsWith("@gmail.com"))
                .map(User2::getUsername)
                .forEach(System.out::println);
    }
}


