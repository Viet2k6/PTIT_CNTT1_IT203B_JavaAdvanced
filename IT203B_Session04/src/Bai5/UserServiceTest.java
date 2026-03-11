package Bai5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService.Role role;
    @AfterEach
    void cleanup() {
        role = null;
    }

    @Test
    void adminPermissions() {
        role = UserService.Role.ADMIN;
        assertTrue(UserService.canPerformAction(role, UserService.Action.DELETE_USER));
        assertTrue(UserService.canPerformAction(role, UserService.Action.LOCK_USER));
        assertTrue(UserService.canPerformAction(role, UserService.Action.VIEW_PROFILE));
    }

    @Test
    void moderatorPermissions() {
        role = UserService.Role.MODERATOR;
        assertFalse(UserService.canPerformAction(role, UserService.Action.DELETE_USER));
        assertTrue(UserService.canPerformAction(role, UserService.Action.LOCK_USER));
        assertTrue(UserService.canPerformAction(role, UserService.Action.VIEW_PROFILE));
    }

    @Test
    void userPermissions() {
        role = UserService.Role.USER;
        assertFalse(UserService.canPerformAction(role, UserService.Action.DELETE_USER));
        assertFalse(UserService.canPerformAction(role, UserService.Action.LOCK_USER));
        assertTrue(UserService.canPerformAction(role, UserService.Action.VIEW_PROFILE));
    }
}
