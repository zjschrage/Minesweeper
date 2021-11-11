# collaboration_warmup
## Names

Zack Schrage  
Jay Don Scott

Basic project to interact with data contained in a remote data source.

- [The assignment](https://sites.duke.edu/compsci_390_01_f21/collaboration-warmup-project/)
- [Advice on writing a useful README](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

## Project: Nifty Minesweeper
Basic minesweeper game, using sprites to make it look clean.  
  
Project idea based on [Minesweeper Nifty Assignment](http://nifty.stanford.edu/2004/LehmanMinesweeper/)

### Timeline

Start Date: 8/26/2021  
Finish Date: 9/15/2021

### Language and IDE
Language: Java  
IDE: None  
Code Editor: Visual Studio Code

### Features
- 24 x 15 tile board  
- gfx assets and sprites to make the game look as close as possible to original Minesweeper.
- 45 mines
- Players are able to assign flag by right clicking.
- 45 flag counter which decreases as the players assigns a flag.
- As the player clicks or holds the left mouse button, the face graphic turns to one in suspence, similar to the original Minesweeper game.
- If the player click on a mine, all mines are revealed, the mine clicked becomes red, the counter stops, false flags are revealed with a red "X", and the smiley face is replaced with a dead one to symbolize a game over.
- If the player wins, the smiley face turns into one with cool sunglasses.
- Players are able to reset the game by clicking on the smiley face.

### Known Bugs
- Once the flag counter goes down to 10, counter resets to 19 then stops counting at 11.
- Flag counter does not reset after restarting the game.
- Clearing the game reveals the final mine and some false flags on mines that do not exist. 

### How to Run
Java JDK on machine is required to run the Launcher.java file
  
[Download Java JDK](https://www.oracle.com/java/technologies/downloads/#jdk17)

To Run:  
- Launch Launcher.java file
  
### Attributions
**[Note, all resources must be royalty free and not "stolen" off of the web](https://thenextweb.com/basics/2020/09/01/google-search-find-free-images/)**!
- [Minesweeper Sprites](https://www.spriters-resource.com/pc_computer/minesweeper/sheet/19849/)

### Resources Consulted 
- [How to make a 2d Game in Java](https://learncodebygaming.com/blog/how-to-make-a-video-game-in-java-2d-basics) (Used to understand the basics of game design and game states)
- [How to Add Sound During Button Press](http://suavesnippets.blogspot.com/2011/06/add-sound-on-jbutton-click-in-java.html)
- [Graphics2D Oracle Documentation](https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html)

### Notes
- In the future, we would like to figure out why these bugs occur and fix them. 
- We would also like to expand on this game and create a menu which allows players to change the difficultly which changes the board size and the number of mines correspondingly.
- Other features that we are interested in implementing onto our game are music and special graphic effects when players click on a tile or when the board is revealing tiles.
