package Bai5;

public class UserService {

    public enum Role {
        ADMIN, MODERATOR, USER
    }

    public enum Action {
        DELETE_USER, LOCK_USER, VIEW_PROFILE
    }

    public static boolean canPerformAction(Role role, Action action) {
        switch (role) {
            case ADMIN:
                return true;
            case MODERATOR:
                return action == Action.LOCK_USER || action == Action.VIEW_PROFILE;
            case USER:
                return action == Action.VIEW_PROFILE;
            default:
                return false;
        }
    }
}
