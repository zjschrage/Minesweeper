package state;

import game.Minesweeper;
import game.Tile;
import gfx.Display;
import gfx.Assets;
import game.Board;
import java.awt.Graphics2D;

public class GameState extends State {

    public static boolean gameOver = false;
    public int boardX = 24;
    public int boardY = 15;
    public int boardMines = 45;
    public int tSize = 32;
    public int xOffset = 16;
    public int yOffset = 96;

    public int timer = 0;
    public int flags = 45;
    public static int buttonState = 0;

    public static boolean isFirstClick = true;

    public GameState(Minesweeper msp) {
        super(msp);
        new Board(boardX, boardY, boardMines, 0, 0);
        msp.repaint();
    }

    // function to reveal tiles when a tile with no adjacent mines is clicked
    public void reveal(int tx, int ty) {
        // Check if tile is within board
        if (tx < 0 || tx >= Board.board.length || ty < 0 || ty >= Board.board[0].length) return;

        // If at any point the checked tile is already uncovered return
        if(!Board.board[tx][ty].getIsCovered()) return;
        
        // Reveal tile
        Board.board[tx][ty].setIsCovered(false);

        // If tile has no adjacent mines, call reveal on all adjacent tiles
        if (Board.board[tx][ty].getAdjMines() == 0) {
            reveal(tx-1, ty-1);
            reveal(tx, ty-1);
            reveal(tx+1, ty-1);
            reveal(tx-1, ty);
            reveal(tx+1, ty);
            reveal(tx-1, ty+1);
            reveal(tx, ty+1);
            reveal(tx+1, ty+1);
        }
    }

    public void checkWin() {
        int uncovered = boardX * boardY;
        for (int i = 0; i < Board.board.length; i++) {
            for (int j = 0; j < Board.board[0].length; j++) {
                if (!Board.board[i][j].getIsCovered()) uncovered--;
            } 
        }
        if (uncovered == boardMines) {
            gameOver = true;
            buttonState = 3;
            msp.stop();
        }
    }

    //This Method is called when the player clicks a tile (that is NOT flagged and that IS covered)
    @Override
    public void update(char button, int x, int y) {

        int tx = (x - xOffset)/tSize;
        int ty = (y - yOffset)/tSize;
        if (isFirstClick) {
            new Board(boardX, boardY, boardMines, tx, ty);
            isFirstClick = false;
        }

        //Click on the reset button
        if (x >= (Display.width - 52)/2 && x <= (Display.width - 52)/2 + 52 && y >= 22 && y <= 74) {
            new Board(boardX, boardY, boardMines, 0, 0);
            buttonState = 0;
            msp.repaint();
            gameOver = false;
            flags = 45;
            timer = 0;
            isFirstClick = true;
            Assets.counterStates[1][0] = Assets.times[0];
            Assets.counterStates[1][1] = Assets.times[0];
            Assets.counterStates[1][2] = Assets.times[0];
            msp.start();
        }

        if (gameOver) return;

        //Click on the minesweeper board
        if (tx < 0 || tx >= Board.board.length || ty < 0 || ty >= Board.board[0].length) return;
        Tile t = Board.board[tx][ty];
        if (button == 'l' && !t.getIsFlagged()) {
            if (t.getIsMine()) {
                Board.board[tx][ty].setIsBlownUp(true);
                buttonState = 4;
                gameOver = true;
                msp.stop();
            }
            // if the tile clicked has 0 adjacent mines then reveal tiles until getting tile with an adjacent mine
            reveal(tx, ty);
    
            // otherwise reveals tile
            // Board.board[tx][ty].setIsCovered(false);
        }
        else if (button == 'r') {
            if (t.getIsCovered() && !t.getIsFlagged()) {
                Board.board[tx][ty].setIsFlagged(true);
                if (!t.getIsMine()) Board.board[tx][ty].setIsFalseFlag(true);
                flags--;
            }
            else if (t.getIsCovered() && t.getIsFlagged()) {
                Board.board[tx][ty].setIsFlagged(false);
                if (!t.getIsMine()) Board.board[tx][ty].setIsFalseFlag(false);
                flags++;
            }
            //Update Flags Counter
            int flagsCopy = flags;
            int i = 2;
            while (flagsCopy > 0) {
                Assets.counterStates[0][i] = Assets.times[flagsCopy % 10];
                flagsCopy = flagsCopy/10;
                i--;
            }
        }

        checkWin();
        msp.repaint();
    }


    //The tick and render methods below run every second by default 

    @Override
    public void tick() {
        timer++;
        //Increment Timer
        if (timer < 999) {
            int timerCopy = timer;
            int i = 2;
            while (timerCopy > 0) {
                Assets.counterStates[1][i] = Assets.times[timerCopy % 10];
                timerCopy = timerCopy/10;
                i--;
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(Assets.minesweeperPanel, 0, 0, Display.width, Display.height-22, null);
        g.drawImage(Assets.buttonStates[buttonState], (Display.width - 52) / 2, 22, 52, 52, null);
        g.drawImage(Assets.counterStates[0][0], 25, 25, 26, 46, null);
        g.drawImage(Assets.counterStates[0][1], 25+26, 25, 26, 46, null);
        g.drawImage(Assets.counterStates[0][2], 25+52, 25, 26, 46, null);
        g.drawImage(Assets.counterStates[1][0], 749-52, 25, 26, 46, null);
        g.drawImage(Assets.counterStates[1][1], 749-26, 25, 26, 46, null);
        g.drawImage(Assets.counterStates[1][2], 749, 25, 26, 46, null);
        for (int i = 0; i < Board.board.length; i++) {
            for (int j = 0; j < Board.board[0].length; j++) {
                Tile t = Board.board[i][j];
                    if (t.getIsCovered()) {
                        if (t.getIsFlagged()) g.drawImage(Assets.flaggedTile, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                        else g.drawImage(Assets.coveredTile, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                    }
                    else {
                        switch (t.getAdjMines()) {
                            case 0:
                                g.drawImage(Assets.uncoveredTile, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 1:
                                g.drawImage(Assets.one, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 2:
                                g.drawImage(Assets.two, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 3:
                                g.drawImage(Assets.three, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 4:
                                g.drawImage(Assets.four, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 5:
                                g.drawImage(Assets.five, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 6:
                                g.drawImage(Assets.six, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 7:
                                g.drawImage(Assets.seven, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                            case 8:
                                g.drawImage(Assets.eight, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                                break;
                        }
                    }
                    if (gameOver) {
                        if (t.getIsMine()) {
                            if (t.getIsBlownUp()) g.drawImage(Assets.redMine, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                            else if (t.getIsFlagged()) g.drawImage(Assets.flaggedTile, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                            else g.drawImage(Assets.mine, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                        }
                        if (t.getIsFalseFlag()) g.drawImage(Assets.xMine, tSize*i + xOffset, tSize*j + yOffset, tSize, tSize, null);
                    }
            }  
        }    
    }
    
}
