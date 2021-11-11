package gfx;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage minesweeperPanel;
    public static BufferedImage coveredTile;
    public static BufferedImage uncoveredTile;
    public static BufferedImage flaggedTile;
    public static BufferedImage mine;
    public static BufferedImage redMine;
    public static BufferedImage xMine;
    public static BufferedImage smile;
    public static BufferedImage smilePressed;
    public static BufferedImage shocked;
    public static BufferedImage cool;
    public static BufferedImage dead;
    public static BufferedImage one;
    public static BufferedImage two;
    public static BufferedImage three;
    public static BufferedImage four;
    public static BufferedImage five;
    public static BufferedImage six;
    public static BufferedImage seven;
    public static BufferedImage eight;
    public static BufferedImage time0;
    public static BufferedImage time1;
    public static BufferedImage time2;
    public static BufferedImage time3;
    public static BufferedImage time4;
    public static BufferedImage time5;
    public static BufferedImage time6;
    public static BufferedImage time7;
    public static BufferedImage time8;
    public static BufferedImage time9;
    public static BufferedImage[] buttonStates = new BufferedImage[5];
    public static BufferedImage[] times = new BufferedImage[10];
    public static BufferedImage[][] counterStates = new BufferedImage[2][3];

    public static void init() {
        
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/minesweeper-sprites.png"));
        SpriteSheet panel = new SpriteSheet(ImageLoader.loadImage("/res/textures/minesweeper-panel.png"));
        
        minesweeperPanel = panel.crop(0, 0, 2000, 1270);
        coveredTile = sheet.crop(0, 51, 16, 16);
        uncoveredTile = sheet.crop(17, 51, 16, 16);
        flaggedTile = sheet.crop(34, 51, 16, 16);
        mine = sheet.crop(85, 51, 16, 16);
        redMine = sheet.crop(102, 51, 16, 16);
        xMine = sheet.crop(119, 51, 16, 16);
        smile = sheet.crop(0, 24, 26, 26);
        smilePressed = sheet.crop(27, 24, 26, 26);
        shocked = sheet.crop(54, 24, 26, 26);
        cool = sheet.crop(81, 24, 26, 26);
        dead = sheet.crop(108, 24, 26, 26);
        one = sheet.crop(0, 68, 16, 16);
        two = sheet.crop(17, 68, 16, 16);
        three = sheet.crop(34, 68, 16, 16);
        four = sheet.crop(51, 68, 16, 16);
        five = sheet.crop(68, 68, 16, 16);
        six = sheet.crop(85, 68, 16, 16);
        seven = sheet.crop(102, 68, 16, 16);
        eight = sheet.crop(119, 68, 16, 16);
        time0 = sheet.crop(126, 0, 13, 23);
        time1 = sheet.crop(0, 0, 13, 23);
        time2 = sheet.crop(14, 0, 13, 23);
        time3 = sheet.crop(28, 0, 13, 23);
        time4 = sheet.crop(42, 0, 13, 23);
        time5 = sheet.crop(56, 0, 13, 23);
        time6 = sheet.crop(70, 0, 13, 23);
        time7 = sheet.crop(84, 0, 13, 23);
        time8 = sheet.crop(98, 0, 13, 23);
        time9 = sheet.crop(112, 0, 13, 23);
        buttonStates[0] = smile;
        buttonStates[1] = smilePressed;
        buttonStates[2] = shocked;
        buttonStates[3] = cool;
        buttonStates[4] = dead;
        times[0] = time0;
        times[1] = time1;
        times[2] = time2;
        times[3] = time3;
        times[4] = time4;
        times[5] = time5;
        times[6] = time6;
        times[7] = time7;
        times[8] = time8;
        times[9] = time9;
        counterStates[0][0] = times[0];
        counterStates[0][1] = times[4];
        counterStates[0][2] = times[5];
        counterStates[1][0] = times[0];
        counterStates[1][1] = times[0];
        counterStates[1][2] = times[0];
        
    }
    
}
