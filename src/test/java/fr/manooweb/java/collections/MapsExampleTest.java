package fr.manooweb.java.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MapsExampleTest {

    @Test
    void countNames_shouldCountOccurrences_andIgnoreNullOrBlank() {
        List<String> input = List.of("Alice", "Bob", "Alice", "   ", "Bob ", "Charlie");

        Map<String, Long> result = MapsExample.countNames(input);

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

        Map<String, Long> result = MapsExample.countNames(input);

        assertEquals(1L, result.get("Alice"));
        assertEquals(2L, result.get("Bob"));
        assertFalse(result.containsKey(""));
    }

    @Test
    void countNames_shouldPreserveFirstSeenOrder() {
        List<String> input = List.of("Bob", "Alice", "Bob", "Charlie", "Alice");

        Map<String, Long> result = MapsExample.countNames(input);

        // LinkedHashMap preserves insertion order (first time a key is seen)
        assertEquals(
                List.of("Bob", "Alice", "Charlie"),
                List.copyOf(result.keySet()));
    }

    @Test
    void countNamesWithStreams_shouldMatchLoopImplementation() {
        var input = Arrays.asList("Alice", "Bob", "Alice", "   ", "Bob ", null);

        assertEquals(
                MapsExample.countNames(input),
                MapsExample.countNamesWithStreams(input));
    }

    @Test
    void countNamesWithStreams_shouldPreserveInsertionOrder() {
        var input = List.of("Bob", "Alice", "Bob", "Charlie", "Alice");

        Map<String, Long> result = MapsExample.countNamesWithStreams(input);

        assertEquals(
                List.of("Bob", "Alice", "Charlie"),
                List.copyOf(result.keySet()));
    }
}
