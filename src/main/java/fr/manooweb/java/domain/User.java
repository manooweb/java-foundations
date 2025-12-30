package fr.manooweb.java.domain;

/**
 * Represents a user with a name and an age.
 * Demonstrates basic encapsulation principles.
 */
public class User {

    private final String name;
    private final int age;
    private final String email;

    /**
     * Creates a new User instance.
     *
     * @param name the user name (must not be blank)
     * @param age  the user age (must be non-negative)
     * @throws IllegalArgumentException if validation fails
     */
    public User(String name, String email, int age) {
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

        this.name = name.trim();
        this.email = normalizedEmail;
        this.age = age;
    }

    /**
     * Returns the user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Indicates whether the user is an adult.
     */
    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
