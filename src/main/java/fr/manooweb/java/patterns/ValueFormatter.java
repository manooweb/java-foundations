package fr.manooweb.java.patterns;

import fr.manooweb.java.domain.User;
import fr.manooweb.java.domain.UserRecord;

/**
 * Demonstrates pattern matching with instanceof (Java 16+).
 */
public final class ValueFormatter {

    private ValueFormatter() {
        // Utility class
    }

    /**
     * Formats known value types into a readable string.
     */
    public static String format(Object value) {
        if (value == null) {
            return "<null>";
        }

        if (value instanceof String s) {
            return s.trim();
        }

        if (value instanceof Integer i) {
            return "int:" + i;
        }

        if (value instanceof User u) {
            return "user:" + u.getEmail();
        }

        if (value instanceof UserRecord u) {
            return "userRecord:" + u.email();
        }

        return "unknown:" + value.getClass().getSimpleName();
    }

    public static String formatWithSwitch(Object value) {
        return switch (value) {
            case null -> "<null>";
            case String s -> s.trim();
            case Integer i -> "int:" + i;
            case User u -> "user:" + u.getEmail();
            case UserRecord u -> "userRecord:" + u.email();
            default -> "unknown:" + value.getClass().getSimpleName();
        };
    }
}
