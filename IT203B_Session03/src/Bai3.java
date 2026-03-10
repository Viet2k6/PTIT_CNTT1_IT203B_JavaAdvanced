import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class User3 {
    private String username;
    public User3(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        List<User3> users = Arrays.asList(
                new User3("alice"),
                new User3("bob"),
                new User3("charlie")
        );

        Optional<User3> userOpt = users.stream()
                .filter(u -> u.getUsername().equals("alice"))
                .findFirst();
        userOpt.ifPresentOrElse(u -> System.out.println("Welcome " + u.getUsername()),
                () -> System.out.println("Guest login")
        );
    }
}
