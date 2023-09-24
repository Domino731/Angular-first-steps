package engine.actorsManager;

public class GameTime {
    private int days;
    private int hours;
    private int minutes;

    private final int minutesPerSecond = 40;

    public void update(float deltaTime) {
        // Update time based on delta time
        minutes = (int) (minutes + (deltaTime * minutesPerSecond));
        System.out.println(deltaTime);
        if (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
        if (hours >= 24) {
            hours -= 24;
            days++;
        }
        System.out.println("DAY: " + days);
        System.out.println("HOURS: " + hours);
        System.out.println("MINUTES: " + minutes);
        System.out.println("----------------------------");
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getMinutesPerSecond() {
        return minutesPerSecond;
    }

}