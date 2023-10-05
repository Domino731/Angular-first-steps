package constants.actors.EnvironmentActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.items.DropItemData;

import java.util.ArrayList;

public class EnvironmentActorConfig {
    public class Stage {
        private final byte stage;
        private final TextureRegion txt;
        private final byte width;
        private final byte height;
        private final int nextStage;
        private final String groundCheckboxId;
        private final String actionCollisionId;
        private final short actionWidth;
        private final short actionHeight;
        private final short actionX;
        private final short actionY;
        private final ArrayList<DropItemData> drop;

        public Stage(byte stage, TextureRegion txt, byte width, byte height, int nextStage, String groundCheckboxId, String actionCollisionId, ArrayList<DropItemData> drop) {
            this.stage = stage;
            this.width = width;
            this.height = height;
            this.txt = txt;
            this.nextStage = nextStage;
            this.groundCheckboxId = groundCheckboxId;
            this.actionCollisionId = actionCollisionId;
            this.drop = drop;
        }

        public byte getStage() {
            return stage;
        }

        public TextureRegion getTxt() {
            return txt;
        }

        public byte getWidth() {
            return width;
        }

        public byte getHeight() {
            return height;
        }

        public int getNextStage() {
            return nextStage;
        }
    }

    public class Config {
        private final String id;
        private final String name;

        public Config(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }


}
