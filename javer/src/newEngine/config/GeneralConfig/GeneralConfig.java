package javer.src.newEngine.config.GeneralConfig;

public class GeneralConfig {
    private float windowHeight;
    private float windowWidth;
    private final float scale;

    public GeneralConfig(float windowWidth, float windowHeight){
      this.windowHeight = windowHeight;
      this.windowWidth = windowWidth;
      this.scale = 2.0f;
    }

    // setters
    public void setWindowHeight(float windowHeight) {
        this.windowHeight = windowHeight;
    }
    public void setWindowWidth(float windowWidth) {
        this.windowWidth = windowWidth;
    }

    // getters
    public float getWindowHeight() {
        return windowHeight;
    }
    public float getWindowWidth() {
        return windowWidth;
    }
    public float getScale() {
        return scale;
    }
    public static float getTileSize(){
        return 16;
    }
}
