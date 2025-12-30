package fr.manooweb.java.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsExampleTest {

    @Test
    void concatWithString_shouldConcatenate() {
        assertEquals("HelloWorld", StringsExample.concatWithString("Hello", "World"));
    }

    @Test
    void concatWithStringBuilder_shouldConcatenate() {
        assertEquals("HelloWorld", StringsExample.concatWithStringBuilder("Hello", "World"));
    }

    @Test
    void multilineText_shouldContainLineBreaks() {
        String text = StringsExample.multilineText();

        assertTrue(text.contains("Hello,"));
        assertTrue(text.contains("Java 21"));
    }

    @Test
    void string_shouldBeImmutable_whenReassigned() {
        // Initial string reference
        String text = "foo";

        // Another variable pointing to the same String instance
        String sameReference = text;

        // Concatenation creates a NEW String instance
        String modified = text + "!";

        // The original String content is unchanged
        assertEquals("foo", text);

        // Both variables still reference the same original String object
        assertSame(text, sameReference);

        // The concatenation result is a different String instance
        assertNotSame(text, modified);
    }
}
