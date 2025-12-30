package fr.manooweb.java.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MapsExampleTest {

    @Test
    void countNames_shouldCountOccurrences_andIgnoreNullOrBlank() {
        List<String> input = List.of("Alice", "Bob", "Alice", "   ", "Bob ", "Charlie");

        Map<String, Integer> result = MapsExample.countNames(input);

        assertEquals(2, result.get("Alice"));
        assertEquals(2, result.get("Bob"));
        assertEquals(1, result.get("Charlie"));
        assertFalse(result.containsKey("")); // blanks ignored
    }

    @Test
    void countNames_shouldIgnoreNullValues() {
        List<String> input = new ArrayList<>();
        input.add("Alice");
        input.add(null);
        input.add("Bob");
        input.add("   ");
        input.add(null);
        input.add("Bob");

        Map<String, Integer> result = MapsExample.countNames(input);

        assertEquals(1, result.get("Alice"));
        assertEquals(2, result.get("Bob"));
        assertFalse(result.containsKey(""));
    }

    @Test
    void countNames_shouldPreserveFirstSeenOrder() {
        List<String> input = List.of("Bob", "Alice", "Bob", "Charlie", "Alice");

        Map<String, Integer> result = MapsExample.countNames(input);

        // LinkedHashMap preserves insertion order (first time a key is seen)
        assertEquals(
                List.of("Bob", "Alice", "Charlie"),
                List.copyOf(result.keySet()));
    }
}
