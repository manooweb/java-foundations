package fr.manooweb.java.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapsExample {

    /**
     * Counts how many times each cleaned name appears.
     * - trims spaces
     * - ignores null and blank entries
     * - preserves first-seen order (LinkedHashMap)
     */
    public static Map<String, Long> countNames(Iterable<String> rawNames) {
        Map<String, Long> counts = new LinkedHashMap<>();

        for (String name : rawNames) {
            if (name == null) {
                continue;
            }

            String trimmed = name.trim();
            if (trimmed.isEmpty()) {
                continue;
            }

            counts.merge(trimmed, 1L, Long::sum);
        }

        return counts;
    }

    public static Map<String, Long> countNamesWithStreams(Collection<String> rawNames) {
        return rawNames.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(
                        s -> s, // key mapper
                        LinkedHashMap::new, // preserve insertion order
                        Collectors.counting() // count occurrences
                ));
    }
}
