package fr.manooweb.java.domain;

public record UserRecord(String name, String email, int age) {

    public UserRecord {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be blank");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be blank");
        }

        String normalizedEmail = email.trim().toLowerCase();
        if (!normalizedEmail.contains("@")) {
            throw new IllegalArgumentException("Email must be valid");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age must be non-negative");
        }

        // IMPORTANT: reassign record components when normalizing values
        name = name.trim();
        email = normalizedEmail;
    }

    public boolean isAdult() {
        return age >= 18;
    }
}
