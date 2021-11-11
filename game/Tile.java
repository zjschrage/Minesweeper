package game;

public class Tile {

    private boolean isMine;
    private int adjMines;
    private boolean isFlagged;
    private boolean isCovered;

    //For death screen
    private boolean blownUp;
    private boolean falseFlag;

    public Tile(boolean isMine, int adjMines, boolean isFlagged, boolean isCovered, boolean blownUp, boolean falseFlag) {
        this.isMine = isMine;
        this.adjMines = adjMines;
        this.isFlagged = isFlagged;
        this.isCovered = isCovered;
        this.blownUp = blownUp;
        this.falseFlag = falseFlag;
    }

    public boolean getIsMine() {
        return this.isMine;
    }

    public int getAdjMines() {
        return this.adjMines;
    }

    public boolean getIsFlagged() {
        return this.isFlagged;
    }

    public boolean getIsCovered() {
        return this.isCovered;
    }

    public boolean getIsBlownUp() {
        return this.blownUp;
    }

    public boolean getIsFalseFlag() {
        return this.falseFlag;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public void setAdjMines(int adjMines) {
        this.adjMines = adjMines;
    }

    public void setIsFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public void setIsCovered(boolean isCovered) {
        this.isCovered = isCovered;
    }

    public void setIsBlownUp(boolean blownUp) {
        this.blownUp = blownUp;
    }

    public void setIsFalseFlag(boolean falseFlag) {
        this.falseFlag = falseFlag;
    }
    
}
