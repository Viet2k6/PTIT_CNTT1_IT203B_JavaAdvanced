package Bai4;

public class PasswordService {
    public static String evaluatePasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return "Yếu";
        }

        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Mạnh";
        }
        if ((hasUpper && hasLower) || (hasDigit && hasSpecial)) {
            return "Trung bình";
        }
        return "Yếu";
    }
}
