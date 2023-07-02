package javer.src.newEngine.config.GeneralConfig;

public class GeneralConfig {
    private int windowHeight;
    private int windowWidth;
    private final float scale;

    public GeneralConfig(int windowWidth, int windowHeight){
      this.windowHeight = windowHeight;
      this.windowWidth = windowWidth;
      this.scale = 2.0f;
    }

    // setters
    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }
    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    // getters
    public int getWindowHeight() {
        return windowHeight;
    }
    public int getWindowWidth() {
        return windowWidth;
    }
    public float getScale() {
        return scale;
    }
    public static float getTileSize(){
        return 16;
    }
}
