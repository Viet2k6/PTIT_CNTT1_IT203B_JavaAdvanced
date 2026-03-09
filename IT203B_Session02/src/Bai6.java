@FunctionalInterface
interface UserProcessor {
    String process(User2 u);
}

class User2 {
    private String username;
    public User2(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class UserUtils {
    public static String convertToUpperCase(User2 u) {
        return u.getUsername().toUpperCase();
    }
}

public class Bai6 {
    public static void main(String[] args) {
        UserProcessor processor = UserUtils::convertToUpperCase;
        User2 user2 = new User2("Việt");
        String result = processor.process(user2);
        System.out.println("Kết quả: " + result);
    }
}
