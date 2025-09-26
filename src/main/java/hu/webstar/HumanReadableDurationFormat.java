package hu.webstar;

import java.util.ArrayList;
import java.util.List;

/**
 * Formats a duration in seconds into a human-readable string.
 * Example: 62 → "1 minute and 2 seconds"
 */
public class HumanReadableDurationFormat {

    /** Represents a time unit (e.g. second, minute, hour). */
    private record Unit(int seconds, String name) {}

    // Time units from largest to smallest
    private static final List<Unit> UNITS = List.of(
            new Unit(365 * 24 * 60 * 60, "year"),
            new Unit(24 * 60 * 60, "day"),
            new Unit(60 * 60, "hour"),
            new Unit(60, "minute"),
            new Unit(1, "second")
    );

    /**
     * Converts a duration in seconds into a human-readable string.
     *
     * @param seconds duration in seconds
     * @return formatted string, e.g. "1 hour, 2 minutes and 3 seconds"
     */
    public static String formatDuration(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Duration must be non-negative");
        }

        if (seconds == 0) {
            return "now";
        }

        List<String> parts = new ArrayList<>();

        // Break down the duration into units
        for (Unit unit : UNITS) {
            int value = seconds / unit.seconds();
            if (value > 0) {
                String word = unit.name();
                if (value != 1) { // pluralize if needed
                    word += "s";
                }
                parts.add(value + " " + word);
                seconds %= unit.seconds();
            }
        }

        // Single unit: just return it, otherwise join with commas and "and"
        if (parts.size() == 1) {
            return parts.getFirst();
        }

        return String.join(", ", parts.subList(0, parts.size() - 1))
                + " and " + parts.getLast();
    }
}
