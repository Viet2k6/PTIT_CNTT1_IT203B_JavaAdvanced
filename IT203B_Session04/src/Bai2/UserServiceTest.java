package Bai2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {
    @Test
    void testValidAge18() {
        int age = 18;
        boolean result = UserService.checkRegistrationAge(age);
        assertEquals(true, result);
    }

    @Test
    void testInvalidAge17() {
        int age = 17;
        boolean result = UserService.checkRegistrationAge(age);
        assertEquals(false, result);
    }

    @Test
    void testNegativeAgeThrowsException() {
        int age = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            UserService.checkRegistrationAge(age);
        });
    }
}
