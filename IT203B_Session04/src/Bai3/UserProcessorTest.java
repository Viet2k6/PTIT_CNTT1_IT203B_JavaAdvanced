package Bai3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {
    private UserProcessor userProcessor;
    @BeforeEach
    void setUp() {
        userProcessor = new UserProcessor();
    }

    @Test
    void testValidEmail() {
        String input = "user@gmail.com";
        String result = userProcessor.processEmail(input);
        assertEquals("user@gmail.com", result);
    }

    @Test
    void testEmailMissingAtSymbol() {
        String input = "usergmail.com";
        assertThrows(IllegalArgumentException.class, () -> {
            userProcessor.processEmail(input);
        });
    }

    @Test
    void testEmailMissingDomain() {
        String input = "user@";
        assertThrows(IllegalArgumentException.class, () -> {
            userProcessor.processEmail(input);
        });
    }

    @Test
    void testEmailNormalizationToLowercase() {
        String input = "Example@Gmail.com";
        String result = userProcessor.processEmail(input);
        assertEquals("example@gmail.com", result);
    }
}

