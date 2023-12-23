package game.hud.clock;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

// TODO: temporary class, add styles later
public class Clock extends Stage {
    private final Time time = new Time();
    // TODO: move up to actorsManager or PlayScreen class
    BitmapFont font = new BitmapFont();

    public Clock() {
        addActor(time);
    }

    public class Time extends Actor {
        private String timeString = "";

        public Time() {
            setX(0);
            setY(10);
        }

        public void setTime(int days, int hours, int minutes) {
            timeString = String.format("%02d:%02d:%02d", days, hours, minutes);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            font.draw(batch, timeString, 30, 30);
        }
    }


    public void setTime(int days, int hours, int minutes) {
        time.setTime(days, hours, minutes);
    }
}
