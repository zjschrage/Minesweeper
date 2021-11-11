package game;
import javax.swing.JPanel;

import gfx.Assets;
import gfx.Display;
import input.MouseInput;
import state.GameState;
import state.MenuState;
import state.State;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Minesweeper extends JPanel implements Runnable {

    private Display display;
    private Thread thread;
    private boolean running = false;

    public String title;
    public int width;
    public int height;

    public State gameState;
    public State menuState;

    private MouseInput mouseManager;

    public static final int FPS = 1;

    public Minesweeper(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        mouseManager = new MouseInput(this);
    }

    public void init() {
        //Load Assets
        Assets.init();

        //Create JFrame and add JPanel to JFrame
        display = new Display(title, width, height);
        setSize(width, height);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.addPanel(this);

        //Create State Objects and set state
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);

    }

    private void tick() {
        if (State.getState() != null) State.getState().tick();
    }

    private void render() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (State.getState() != null) State.getState().render((Graphics2D) g);
    }

    public void run() {

        double timePerTick = 1000000000 / FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public MouseInput getMouseManager() {
    	return mouseManager;
    }

}