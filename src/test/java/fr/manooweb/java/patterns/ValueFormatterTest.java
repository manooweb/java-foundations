package fr.manooweb.java.patterns;

import fr.manooweb.java.domain.User;
import fr.manooweb.java.domain.UserRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueFormatterTest {

    @Test
    void format_shouldHandleNull() {
        assertEquals("<null>", ValueFormatter.format(null));
    }

    @Test
    void format_shouldTrimStrings() {
        assertEquals("hello", ValueFormatter.format("  hello  "));
    }

    @Test
    void format_shouldFormatIntegers() {
        assertEquals("int:42", ValueFormatter.format(42));
    }

    @Test
    void format_shouldFormatUser() {
        User user = new User("Alice", "alice@example.com", 30);
        assertEquals("user:alice@example.com", ValueFormatter.format(user));
    }

    @Test
    void format_shouldFormatUserRecord() {
        UserRecord user = new UserRecord("Alice", "alice@example.com", 30);
        assertEquals("userRecord:alice@example.com", ValueFormatter.format(user));
    }

    @Test
    void formatWithSwitch_shouldBehaveLikeInstanceofVersion() {
        assertEquals("<null>", ValueFormatter.formatWithSwitch(null));
        assertEquals("hello", ValueFormatter.formatWithSwitch("  hello "));
        assertEquals("int:10", ValueFormatter.formatWithSwitch(10));

        User user = new User("Alice", "alice@example.com", 30);
        assertEquals("user:alice@example.com", ValueFormatter.formatWithSwitch(user));

        UserRecord record = new UserRecord("Bob", "bob@example.com", 25);
        assertEquals("userRecord:bob@example.com", ValueFormatter.formatWithSwitch(record));
    }
}
