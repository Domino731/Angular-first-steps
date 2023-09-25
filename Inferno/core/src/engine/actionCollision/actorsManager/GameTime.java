package engine.actionCollision.actorsManager;

public class GameTime {
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;
    private float seconds = 0;
    private float secondsMultipler = 40.2f;

    public void update(float deltaTime) {
        // Update time here
        seconds += deltaTime * secondsMultipler;
        System.out.println(seconds);
        // Handle time overflow (e.g., when seconds reach 60, increment minutes)
        if (seconds >= 60) {
            seconds -= 60;
            minutes += 1;
            if (minutes >= 60) {
                minutes -= 60;
                hours += 1;
                if (hours >= 24) {
                    hours -= 24;
                    days += 1;
                }
            }
        }
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
}