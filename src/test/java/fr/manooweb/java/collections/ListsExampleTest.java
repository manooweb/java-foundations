package fr.manooweb.java.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListsExampleTest {

    @Test
    void cleanNames_shouldTrimAndRemoveBlanks_butKeepOrderAndDuplicates() {
        List<String> input = List.of("  Alice  ", "", "Bob", "Alice", "   ", "Bob ");

        List<String> cleaned = ListsExample.cleanNames(input);

        assertEquals(List.of("Alice", "Bob", "Alice", "Bob"), cleaned);
    }

    @Test
    void cleanNames_shouldRemoveNullItems() {
        List<String> input = new ArrayList<>(
                List.of("  Alice  ", "", "Bob", "Alice", "   ", "Bob "));
        input.add(null);

        List<String> cleaned = ListsExample.cleanNames(input);

        assertEquals(List.of("Alice", "Bob", "Alice", "Bob"), cleaned);
    }

    @Test
    void cleanNames_shouldReturnEmptyList_whenInputIsEmpty() {
        List<String> input = List.of();

        List<String> cleaned = ListsExample.cleanNames(input);

        assertTrue(cleaned.isEmpty());
    }

    @Test
    void cleanNamesWithStreams_shouldMatchLoopImplementation() {
        List<String> input = new ArrayList<>(
                List.of("  Alice  ", "", "Bob", "Alice", "   ", "Bob "));
        input.add(null);

        assertEquals(
                ListsExample.cleanNames(input),
                ListsExample.cleanNamesWithStreams(input));
    }
}
