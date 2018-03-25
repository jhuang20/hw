/*team smarties--james huang, shafali gupta, kevin feng
 * apcs pd01
 * hw15--Thinkers of the Corn, Do You Hear the People SING!
 * 2018/3/6
/***
 * OUR ALGO:
 * State your cleanest algo for finding your way out of the maze.
You start out in one direction until you cannot move in that direction.
Check if you can move in any other direction. If you cannot, then go back on move and try a different direction.
More specifically, we will default on always making a right turn, if that doesn;t work,  then moving forward, then moving left, then moving backwards.
Our algorithm basically follows the maxim of following the right wall to the exit path.
If there is a dead end, it will backtrack until it reaches a new path. If it has already explored a path, it will not explore it anymore(marked by a new symbol!)
Pseudocode:
solutionFinder(int x, int y)
if(we are on the exit)
Return;
if(the coordinate is NOT a path)
Return;
else(
Current location== symbol for already traversed path
solutionFinder(x+1,y);
solutionFinder(x,y+1);
//each possibility of move is explored!
)

 * SKEELTON for class
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 *  <INSERT YOUR SUMMARY OF ALGO HERE>
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  private char[][] maze;
  private int h, w; //height, width of maze
  private boolean solved;

  //initialize constants for map component symbols
  final private char HERO =         '$';
  final private char PATH =         '~';
  final private char WALL =         '#';
  final private char EXIT =         '@';
  final private char VISITED_PATH = '.';


  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          maze[i][row] = line.charAt( i );

        h++;
        row++;
	    }

	    for( int i=0; i<w; i++ )
        maze[i][row] = WALL;
	    h++;
	    row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    solved = false;
  }//end constructor


  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
        retStr = retStr + maze[j][i];
	    retStr = retStr + "\n";
    }
    return retStr;
  }


  //helper method to keep try/catch clutter out of main flow
  private void delay( int n )
  {
    try {
	    Thread.sleep(n);
    } catch( InterruptedException e ) {
	    System.exit(0);
    }
  }


  /*********************************************
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   *********************************************/
  public void solve( int x, int y ) {

    delay(50); //slow it down enough to be followable

    //primary base case
    if ((maze[x][y]==EXIT)) {
      maze[x][y]= HERO;
	   solved=true;
     System.out.println(this);
     System.out.println("maze solved");
     System.exit(0);
    }
    //other base case(s)...
    else if(x<0||y<0||x>w||y>h) {// out of bounds
      return;
    }
    else if (maze[x][y]==WALL) {//if the coordinate is a wall, dont do anything. We cant do anything.
      return;
    }
    else if (maze[x][y]==VISITED_PATH) {//if we already visited this path once, then do nothing
      return;
    }
    else if (!(onPath(x,y)) ) {
	    /* YOUR AMAZEING CODE HERE */
      return;
    }
    //recursive reduction
    else {
      maze[x][y]=VISITED_PATH;
      solve(x+1,y);
      solve(x,y+1);
      solve(x-1,y);
      solve(x,y-1);
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    try {
	    String mazeInputFile = args[0];

	    MazeSolver ms = new MazeSolver( mazeInputFile );
	    //clear screen
	    System.out.println( "[2J" );

	    //display maze
	    System.out.println( ms );

	    //drop hero into the maze (coords must be on path)
	    //comment next line out when ready to randomize startpos
	    ms.solve( 4, 3 );

	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	    //drop our hero into maze at random location on path
	    //the Tim Diep way:
	    Random r = new Random();
	    int startX = r.nextInt( 80 );
	    int startY = r.nextInt( 25 );
	    while ( !ms.onPath(startX,startY) ) {
      startX = r.nextInt( 80 );
      startY = r.nextInt( 25 );
	    }

	    ms.solve( startX, startY );
	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    } catch( Exception e ) {
	    System.out.println( "Error reading input file." );
	    System.out.println( "Usage: java Maze <filename>" );
    }
  }

}//end class Maze
