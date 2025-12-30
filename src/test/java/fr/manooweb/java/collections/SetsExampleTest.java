package fr.manooweb.java.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class SetsExampleTest {

    @Test
    void uniqueCleanNames_shouldRemoveDuplicates_andKeepInsertionOrder() {
        List<String> input = List.of("  Alice  ", "Bob", "Alice", "Bob ", "   ");

        Set<String> result = SetsExample.uniqueCleanNames(input);

        assertEquals(Set.of("Alice", "Bob"), result);
    }

    @Test
    void uniqueCleanNames_shouldPreserveInsertionOrder() {
        List<String> input = List.of("Bob", "Alice", "Bob", "Charlie", "Alice");

        Set<String> result = SetsExample.uniqueCleanNames(input);

        // Convert the Set to a List to assert order
        assertEquals(
                List.of("Bob", "Alice", "Charlie"),
                List.copyOf(result));
    }
}
