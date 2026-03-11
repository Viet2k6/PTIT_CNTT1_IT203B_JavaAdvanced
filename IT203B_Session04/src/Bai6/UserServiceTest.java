package Bai6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {

    User existing;
    @BeforeEach
    void setUp() {
        existing = new User("user@gmail.com", LocalDate.of(2000,1,1));
    }

    @Test
    void testValidUpdate() {
        UserProfile newProfile = new UserProfile("new@gmail.com", LocalDate.of(1999,1,1));
        List<User> allUsers = List.of(existing);
        User updated = UserService.updateProfile(existing, newProfile, allUsers);
        assertNotNull(updated);
        assertEquals("new@gmail.com", updated.getEmail());
    }

    @Test
    void testFutureBirthDate() {
        UserProfile newProfile = new UserProfile("new@gmail.com", LocalDate.now().plusDays(1));
        User result = UserService.updateProfile(existing, newProfile, List.of(existing));
        assertNull(result);
    }
}