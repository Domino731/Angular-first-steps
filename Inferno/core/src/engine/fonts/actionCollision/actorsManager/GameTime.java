package engine.fonts.actionCollision.actorsManager;

import java.util.ArrayList;

public class GameTime {
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;
    private int minutesAbsolute = 0;
    private float seconds = 0;
    private float secondsMultipler = 40.2f;
    private ArrayList<GameTimeNewMinute> minuteActions = new ArrayList<>();

    public void update(float deltaTime) {
        // Update time here
        seconds += deltaTime * secondsMultipler;
        // Handle time overflow (e.g., when seconds reach 60, increment minutes)
        if (seconds >= 60) {
            seconds -= 60;
            minutes++;
            minutesAbsolute++;
            runMinuteActions();
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

    public void removeMinuteAction(GameTimeNewMinute gameTimeNewMinute) {
        minuteActions.remove(gameTimeNewMinute);
    }

    public void removeMinuteAction(ArrayList<GameTimeNewMinute> gameTimeNewMinute) {
        minuteActions.removeAll(gameTimeNewMinute);
    }


    private void runMinuteActions() {
        for (GameTimeNewMinute gameTimeNewMinute : minuteActions) {
            gameTimeNewMinute.action(minutes, minutesAbsolute);
        }
    }

    public void addNewMinuteAction(GameTimeNewMinute gameTimeNewMinute) {
        minuteActions.add(gameTimeNewMinute);
    }

    public void addNewMinuteActions(ArrayList<GameTimeNewMinute> gameTimeNewMinute) {
        minuteActions.addAll(gameTimeNewMinute);
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

    public int getMinutesAbsolute() {
        return minutesAbsolute;
    }
}