package javer.src;

import javer.src.engine.EngineGraphic;
import javer.src.entities.Player;
import javer.src.levels.LevelManager;
import javer.src.player.PlayerClass;

import java.awt.*;

// Engine class with game panel & window
public class Engine implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 2f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
    // Entities
    private Player player;
    private LevelManager levelManager;

    // NEW
    private PlayerClass playerClass;

    // on start, create the game panel and game window classes
    public Engine(){
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(GAME_WIDTH, GAME_HEIGHT, gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
        System.out.println("Engine started");
        playerClass = new PlayerClass(10, 10, 100, 100);
    }

    private void initClasses(){
        player = new Player(100, 100, (int) (64 * SCALE), (int) (40 * SCALE));
        levelManager = new LevelManager(this);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
       player.update();
       levelManager.update();
    }

    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);
        playerClass.render(g);
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
    }

    public Player getPlayer(){
        return player;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void windowFocusLost() {
        player.resetDirectionsBooleans();
    }
}
