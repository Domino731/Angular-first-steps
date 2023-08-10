package utils;

/**
 * UTILITY CLASS - contains methods for game logs - success, default, alerts...
 */
public class EngineLog {
    // ANSI escape code for yellow text
    private static final String ANSI_YELLOW = "\u001B[33m";
    // ANSI escape code for green text
    private static final String ANSI_GREEN = "\u001B[32m";
    // ANSI escape code for red text
    private static final String ANSI_RED = "\u001B[31m";
    // ANSI escape code to reset text color
    private static final String ANSI_RESET = "\u001B[0m";

    public static void print(String message) {
        System.out.println("Engine log: " + message);
    }

    public static void success(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void error(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static void alert(String message) {
        System.out.println(ANSI_YELLOW + "Engine log.alert: " + message + ANSI_RESET);
    }

    public static void classSuccess(String text) {
        System.out.println(ANSI_GREEN + "Engine log.success: " + text + " class created" + ANSI_RESET);
    }

    public static void resourceSuccess(String resourceSrc) {
        System.out.println(ANSI_GREEN + "Engine log.resource success: load " + resourceSrc + ANSI_RESET);
    }

    public static void resourceError(String resourceSrc) {
        System.out.println(ANSI_RED + "Engine log.resource error: failed to load " + resourceSrc + ANSI_RESET);
    }
}