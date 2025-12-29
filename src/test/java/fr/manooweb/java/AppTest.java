package fr.manooweb.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    void greeting_shouldMatchExpectedMessage() {
        assertEquals("Hello Java 21 👋", App.greeting());
    }

    @Test
    void greeting_shouldStartWithHello() {
        assertTrue(App.greeting().startsWith("Hello"));
    }

    @Test
    void greeting_shouldMentionJava21() {
        assertTrue(App.greeting().contains("Java 21"));
    }
}
