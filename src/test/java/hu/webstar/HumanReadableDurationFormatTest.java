package hu.webstar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanReadableDurationFormatTest {

    @Test
    void testNegativeSecondsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> HumanReadableDurationFormat.formatDuration(-1));
    }

    @Test
    void testNow() {
        assertEquals("now", HumanReadableDurationFormat.formatDuration(0));
    }

    @Test
    void testSingleUnits() {
        assertEquals("1 second", HumanReadableDurationFormat.formatDuration(1));
        assertEquals("1 minute", HumanReadableDurationFormat.formatDuration(60));
        assertEquals("1 hour", HumanReadableDurationFormat.formatDuration(60 * 60));
        assertEquals("1 day", HumanReadableDurationFormat.formatDuration(24 * 60 * 60));
        assertEquals("1 year", HumanReadableDurationFormat.formatDuration(365 * 24 * 60 * 60));
    }

    @Test
    void testPluralUnits() {
        assertEquals("2 seconds", HumanReadableDurationFormat.formatDuration(2));
        assertEquals("5 minutes", HumanReadableDurationFormat.formatDuration(5 * 60));
        assertEquals("10 hours", HumanReadableDurationFormat.formatDuration(10 * 60 * 60));
    }

    @Test
    void testMixedUnits() {
        assertEquals("1 minute and 2 seconds", HumanReadableDurationFormat.formatDuration(60 + 2));
        assertEquals("1 hour, 1 minute and 2 seconds",
                HumanReadableDurationFormat.formatDuration(60 * 60 + 60 + 2));
        assertEquals("2 hours and 1 second", HumanReadableDurationFormat.formatDuration(2 * 60 * 60 + 1));
        assertEquals("1 year, 2 days and 3 seconds",
                HumanReadableDurationFormat.formatDuration(365 * 24 * 60 * 60 + 2 * 24 * 60 * 60 + 3));
    }

    @Test
    void testLargeValues() {
        assertEquals("2 years", HumanReadableDurationFormat.formatDuration(2 * 365 * 24 * 60 * 60));
        assertEquals("5 years, 10 days and 1 second",
                HumanReadableDurationFormat.formatDuration(5 * 365 * 24 * 60 * 60 + 10 * 24 * 60 * 60 + 1));
    }
}
