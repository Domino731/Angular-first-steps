package engine.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class Items {
    private HashMap<String, Config> data = new HashMap<>();

    public class Config {
        private TextureRegion txt;
        private String id;
        private String name;

        public Config(String id) {

        }
    }
}
