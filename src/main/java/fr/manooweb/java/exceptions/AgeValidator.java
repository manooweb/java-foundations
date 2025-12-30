package fr.manooweb.java.exceptions;

/**
 * Utility class used to validate age values.
 */
public class AgeValidator {

    /**
     * Validates that the given age is non-negative.
     *
     * @param age the age to validate
     * @throws InvalidAgeException if the age is negative
     */
    public static void validate(int age) {
        if (age < 0) {
            throw new InvalidAgeException(age);
        }
    }
}
