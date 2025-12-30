package fr.manooweb.java.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeValidatorTest {

    @Test
    void validate_shouldNotThrowException_forValidAge() {
        assertDoesNotThrow(() -> AgeValidator.validate(30));
    }

    @Test
    void validate_shouldThrowException_forNegativeAge() {
        InvalidAgeException exception =
                assertThrows(InvalidAgeException.class,
                        () -> AgeValidator.validate(-5));

        assertTrue(exception.getMessage().contains("-5"));
    }
}
