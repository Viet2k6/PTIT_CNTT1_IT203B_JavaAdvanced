package Bai1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserValidatorTest {
    @Test
    void TC01() {
        String input = "user123";
        boolean result = UserValidator.isValidUsername(input);
        assertTrue(result);
    }

    @Test
    void TC02() {
        String input = "abc";
        boolean result = UserValidator.isValidUsername(input);
        assertFalse(result);
    }

    @Test
    void TC03() {
        String input = "user name";
        boolean result = UserValidator.isValidUsername(input);
        assertFalse(result);
    }
}

