package fr.manooweb.java.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class UserTest {

    @Test
    void constructor_shouldCreateValidUser() {
        User user = new User("Alice", "alice@example.com", 30);

        assertEquals("Alice", user.getName());
        assertEquals(30, user.getAge());
    }

    @Test
    void constructor_shouldTrimName() {
        User user = new User("  Bob  ", "bob@example.com", 20);

        assertEquals("Bob", user.getName());
    }

    @Test
    void constructor_shouldRejectBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("   ", "test@example.com", 25));
    }

    @Test
    void constructor_shouldRejectNegativeAge() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Charlie", "charlie@example.com", -1));
    }

    @Test
    void isAdult_shouldReturnTrue_forAge18OrMore() {
        User user = new User("Dana", "dana@example.com", 18);

        assertTrue(user.isAdult());
    }

    @Test
    void isAdult_shouldReturnFalse_forMinor() {
        User user = new User("Eve", "eve@example.com", 17);

        assertFalse(user.isAdult());
    }

    @Test
    void constructor_shouldNormalizeEmail() {
        User user = new User("Alice", "  ALICE@EXAMPLE.COM  ", 30);

        assertEquals("alice@example.com", user.getEmail());
    }

    @Test
    void constructor_shouldRejectBlankEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Bob", "   ", 20));
    }

    @Test
    void constructor_shouldRejectInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Charlie", "not-an-email", 20));
    }

    @Test
    void toString_shouldContainUsefulInformation() {
        User user = new User("Alice", "alice@example.com", 30);

        String result = user.toString();

        assertTrue(result.contains("alice@example.com"));
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("30"));
    }

    @Test
    void findByEmail_shouldReturnUser_whenPresent() {
        UserRepository repo = new UserRepository();
        User user = new User("Alice", "alice@example.com", 30);

        repo.save(user);

        Optional<User> result = repo.findByEmail("alice@example.com");

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void findByEmail_shouldReturnEmptyOptional_whenAbsent() {
        UserRepository repo = new UserRepository();

        Optional<User> result = repo.findByEmail("missing@example.com");

        assertTrue(result.isEmpty());
    }
}
