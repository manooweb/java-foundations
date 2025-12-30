package fr.manooweb.java.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapsExample {

    /**
     * Counts how many times each cleaned name appears.
     * - trims spaces
     * - ignores null and blank entries
     * - preserves first-seen order (LinkedHashMap)
     */
    public static Map<String, Integer> countNames(Iterable<String> rawNames) {
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String name : rawNames) {
            if (name == null) {
                continue;
            }

            String trimmed = name.trim();
            if (trimmed.isEmpty()) {
                continue;
            }

            counts.put(trimmed, counts.getOrDefault(trimmed, 0) + 1);
        }

        return counts;
    }
}
