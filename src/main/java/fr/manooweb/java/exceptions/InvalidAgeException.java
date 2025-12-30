package fr.manooweb.java.exceptions;

/**
 * Custom exception thrown when an invalid age is provided.
 */
public class InvalidAgeException extends IllegalArgumentException {

    public InvalidAgeException(int age) {
        super("Invalid age: " + age);
    }
}
