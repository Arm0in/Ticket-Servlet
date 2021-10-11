package ir.maktab.ticket.util;


import ir.maktab.ticket.domain.User;

public class SecurityContext {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SecurityContext.currentUser = currentUser;
    }

    public static void logout() {
        currentUser = null;
    }
}
