package game;

public class Launcher {

    public static void main(String[] args) {
        Minesweeper msp = new Minesweeper("Minesweeper", 800, 616);
        msp.init();
        msp.start();
    }
    
}