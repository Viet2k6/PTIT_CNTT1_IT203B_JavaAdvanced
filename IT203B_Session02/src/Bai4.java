import java.util.Arrays;
import java.util.List;

class User {
    private String username;
    public User() {
        this.username = "default";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Bai4 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Tiến"),
                new User("Việt"),
                new User("Thành")
        );

        // Tham chiếu instance method của đối tượng bất kỳ thuộc kiểu cụ thể
        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        // Tham chiếu instance method của một đối tượng cụ thể
        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        // Tham chiếu Constructor
        UserFactory factory = User::new;
        User newUser = factory.create();
        System.out.println("New user: " + newUser.getUsername());
    }
}

@FunctionalInterface
interface UserFactory {
    User create();
}
