package engine.utils;

public class EngineLog {
    public static void print(String text){
        System.out.println("Engine log: " + text);
    }

    public static void success(String text) {
        System.out.println("Engine log.success: " + text);
    }

    public static void error(String text) {
        System.out.println("Engine log.error: " + text);
    }

    public static void alert(String text) {
        System.out.println("Engine log.alert: " + text);
    }

    public static void classSuccess(String text) {
        System.out.println("Engine log.success: " + text + " class created");
    }
}
