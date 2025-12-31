package fr.manooweb.java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListsExample {

    /**
     * Cleans a list of raw names:
     * - trims spaces
     * - removes blank entries
     * - keeps insertion order
     * - keeps duplicates
     */
    public static List<String> cleanNames(List<String> rawNames) {
        List<String> result = new ArrayList<>();

        for (String name : rawNames) {
            if (name == null) {
                continue;
            }

            String trimmed = name.trim();
            if (trimmed.isEmpty()) {
                continue;
            }

            result.add(trimmed);
        }

        return result;
    }

    public static List<String> cleanNamesWithStreams(List<String> rawNames) {
        return rawNames.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}
