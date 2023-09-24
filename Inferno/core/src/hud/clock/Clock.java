package hud.clock;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Clock extends Stage {
    private final Time time = new Time();
    BitmapFont font = new BitmapFont(); //or use alex answer to use custom font

    public Clock() {
        addActor(time);
    }

    public class Time extends Actor {
        private String hourDigits = "";
        private String minuteDigits = "";

        public Time() {
            setX(0);
            setY(10);
        }

        public void setTime(int days, int hours, int minutes) {
            minuteDigits = Integer.toString(minutes);
            hourDigits = Integer.toString(hours);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            font.draw(batch, hourDigits, 30, 30);
            font.draw(batch, minuteDigits, 60, 30);
        }
    }


    public void setTime(int days, int hours, int minutes) {
        time.setTime(days, hours, minutes);
    }
}
