import java.util.*;

public class Bai5 {
    public static void main(String[] args) {
        record User5(String username) {}
        List<User5> users = Arrays.asList(
                new User5("alexander"),
                new User5("alice"),
                new User5("charlotte"),
                new User5("benjamin"),
                new User5("Mai")
        );
        users.stream()
                .sorted(Comparator.comparingInt(u -> -u.username().length()))
                .limit(3)
                .forEach(u -> System.out.println(u.username()));
    }
}
