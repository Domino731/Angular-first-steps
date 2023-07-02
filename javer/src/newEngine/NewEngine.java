package javer.src.newEngine;

import javer.src.newEngine.utils.GameWindow;
import javer.src.newEngine.config.GeneralConfig.GeneralConfig;

public class NewEngine {
    private GeneralConfig generalConfig;
    public NewEngine(){
        this.generalConfig = new GeneralConfig(1280, 720);
        System.out.println('s');
        new GameWindow(this.generalConfig.getWindowWidth(), this.generalConfig.getWindowHeight());
    }

    private void init(){

    }
}
