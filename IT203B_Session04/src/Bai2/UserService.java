package Bai2;

public class UserService {
    public static boolean checkRegistrationAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        return age >= 18;
    }
}
