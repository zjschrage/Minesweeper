package state;

import java.awt.Graphics2D;

import game.Minesweeper;

public abstract class State {

    private static State currentState = null;

    //Game State Manager
    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    //Game State Abstract Methods

    protected Minesweeper msp;

    public State(Minesweeper msp) {
        this.msp = msp;
    }
    
    public abstract void update(char button, int x, int y);
    public abstract void tick();
    public abstract void render(Graphics2D g);
    
}
