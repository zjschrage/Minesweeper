package input;

import game.Minesweeper;
import gfx.Display;
import state.GameState;
import state.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {

    public Minesweeper msp;
    public boolean isPressed;

    public MouseInput(Minesweeper msp) {
        this.msp = msp;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        if (e.getY() <= 100) {
            if (e.getX() >= (Display.width - 52)/2 && e.getX() <= (Display.width - 52)/2 + 52 && e.getY() - 22 >= 22 && e.getY() - 22 <= 74) GameState.buttonState = 1;
        }
        else if (!GameState.gameOver) GameState.buttonState = 2;
        msp.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        if (!GameState.gameOver) GameState.buttonState = 0;
        if (e.getButton() == MouseEvent.BUTTON1) State.getState().update('l', e.getX(), e.getY() - 22);
        else if (e.getButton() == MouseEvent.BUTTON3) State.getState().update('r', e.getX(), e.getY() - 22);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
