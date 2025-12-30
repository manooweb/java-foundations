package fr.manooweb.java.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetsExample {

    /**
     * Returns a set of unique, cleaned names:
     * - trims spaces
     * - removes blank entries
     * - removes duplicates
     * - keeps insertion order (LinkedHashSet)
     */
    public static Set<String> uniqueCleanNames(Iterable<String> rawNames) {
        Set<String> result = new LinkedHashSet<>();

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
}
