package fr.manooweb.java.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void recordUser_shouldHaveGeneratedAccessors() {
        UserRecord user = new UserRecord("Alice", "alice@example.com", 30);

        assertEquals("Alice", user.name());
        assertEquals("alice@example.com", user.email());
        assertEquals(30, user.age());
    }

    @Test
    void recordUser_shouldHaveValueBasedEquality() {
        UserRecord u1 = new UserRecord("Alice", "alice@example.com", 30);
        UserRecord u2 = new UserRecord("Alice", "alice@example.com", 30);

        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void recordUser_shouldRejectNegativeAge() {
        assertThrows(IllegalArgumentException.class,
                () -> new UserRecord("Alice", "alice@example.com", -1));
    }

    @Test
    void isAdult_shouldReturnTrue_whenAgeIs18OrMore() {
        UserRecord user = new UserRecord("Bob", "bob@example.com", 20);
        assertTrue(user.isAdult());
    }

    @ParameterizedTest
    @CsvSource({
            // name, email,             age
            "'',     alice@example.com, 30",
            "'   ',  alice@example.com, 30",
            "Alice,  '',                30",
            "Alice,  '   ',             30",
            "Alice,  alice,             30",
            "Alice,  alice@,            30",
            "Alice,  @example.com,      30",
            "Alice,  alice.example.com, 30",
            "Alice,  alice@example.com, -10"
    })
    void constructor_shouldRejectInvalidNameOrEmail(String name, String email, int age) {
        assertThrows(IllegalArgumentException.class,
                () -> new UserRecord(name, email, age));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "NULL,  alice@example.com",
            "Alice, NULL"
    }, nullValues = "NULL")
    void constructor_shouldRejectNullNameOrEmail(String name, String email) {
        assertThrows(IllegalArgumentException.class,
                () -> new UserRecord(name, email, 30));
    }

    @ParameterizedTest
    @CsvSource({
            // rawName,    rawEmail,             expectedName, expectedEmail
            "' Alice ',   ' ALICE@EXAMPLE.COM ', Alice,        alice@example.com",
            "'Bob',       'bob@example.com',     Bob,          bob@example.com",
            "' Manu  ',   ' Manu@Example.Com ',  Manu,         manu@example.com"
    })
    void constructor_shouldNormalizeNameAndEmail(
            String rawName,
            String rawEmail,
            String expectedName,
            String expectedEmail) {
        UserRecord user = new UserRecord(rawName, rawEmail, 30);

        assertEquals(expectedName, user.name());
        assertEquals(expectedEmail, user.email());
    }
}
