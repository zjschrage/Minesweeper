package game;

public class Board {

    public static Tile[][] board;

    public Board(int x, int y, int mines, int cx, int cy) {
        board = new Tile[x][y];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Tile(false, 0, false, true, false, false);
            }
        }
        generateBoard(mines, cx, cy);
    }

    public void generateBoard(int mines, int cx, int cy) {
        
        //Generate Mines
        while (mines > 0) {
            int x = (int)(Math.random() * board.length);
            int y = (int)(Math.random() * board[0].length);
            if (!board[x][y].getIsMine() && Math.abs(cx - x) > 1 && Math.abs(cy - y) > 1) {
                board[x][y].setIsMine(true);
                mines--;
            }
        }

        //Generate the number of adjacent mines to each tile
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getIsMine()) {
                    for (int m = -1; m <= 1; m++) {
                        for (int n = -1; n <= 1; n++) {
                            if (inBounds(i+m, j+n)) {
                                board[i+m][j+n].setAdjMines(board[i+m][j+n].getAdjMines() + 1);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean inBounds(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        else return true;
    }
    
}
