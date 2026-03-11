package Bai3;

public class UserProcessor {
    public String processEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException();
        }

        String[] parts = email.split("@");
        if (parts.length != 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException();
        }
        return email.toLowerCase();
    }
}
