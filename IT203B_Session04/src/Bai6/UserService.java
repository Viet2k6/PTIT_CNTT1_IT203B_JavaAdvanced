package Bai6;

import java.time.LocalDate;
import java.util.List;

public class UserService {
    public static User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        for (User u : allUsers) {
            if (!u.equals(existingUser) && u.getEmail().equalsIgnoreCase(newProfile.getEmail())) {
                return null;
            }
        }

        existingUser.setEmail(newProfile.getEmail());
        existingUser.setBirthDate(newProfile.getBirthDate());
        return existingUser;
    }
}
