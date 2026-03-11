package Bai4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordServiceTest {
    @Test
    void testStrongPassword() {
        String input = "Abc123!@";
        String result = PasswordService.evaluatePasswordStrength(input);
        assertEquals("Mạnh", result);
    }

    @Test
    void testMissingUppercase() {
        String input = "abc123!@";
        String result = PasswordService.evaluatePasswordStrength(input);
        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingSpecialCharacter() {
        String input = "Abc12345";
        String result = PasswordService.evaluatePasswordStrength(input);
        assertEquals("Trung bình", result);
    }

    @Test
    void testTooShortPassword() {
        String input = "Ab1l";
        String result = PasswordService.evaluatePasswordStrength(input);
        assertEquals("Yếu", result);
    }

    @Test
    void testMultipleCasesWithAssertAll() {
        assertAll(
                () -> assertEquals("Mạnh", PasswordService.evaluatePasswordStrength("Abc123!@")),
                () -> assertEquals("Trung bình", PasswordService.evaluatePasswordStrength("ABC123!@")),
                () -> assertEquals("Yếu", PasswordService.evaluatePasswordStrength("password"))
        );
    }
}
