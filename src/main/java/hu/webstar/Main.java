package hu.webstar;

public class Main {

    public static void main(String[] args) {
        final int[] testValues = {
                0,                          // now
                2,                          // 2 seconds
                60 + 2,                     // 1 minute + 2 seconds
                2 * 60 * 60 + 60 + 1,       // 2 hours + 1 minute + 1 second
                365 * 24 * 60 * 60,         // 1 year
                365 * 24 * 60 * 60 + 60     // 1 year + 1 minute
        };

        for (int seconds : testValues) {
            System.out.println(seconds + " seconds: '"
                    + HumanReadableDurationFormat.formatDuration(seconds) + "'");
        }
    }
}
