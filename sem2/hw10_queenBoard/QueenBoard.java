/***
 * james huang and shafali gupta--team awsome
 * 2018-02-29
 * hw10
 * brown apcs pd01
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */
/***
 * well this doesn't seem to be working...
 * All functions are working with the exception of the two most importnat ones!
 * solve and solveH both do not work. We believe that there is a problem
 *with the way we implmented the recursive calls in solveH. Because we
 * traverse each column for 0s, every spot in the 1st column is valid.
 * Thus, this locks the entire board out.
 * WE believe that our algorithm was too simple, and we've spent 2 hours, so we're claling it a night.
 * ***/

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    /*
     * algo idea:
     * start out at the top left and use addQueen so that all the places are marked
     * go on to the next row and find the first viable spot. Keep on doing this until u either finish or reach a point where there is no available spot
     * if there are no available spots, then start over with 0,1 instead of 0,1 (the top left)
     *
     *
     * */
        return solveH(0);

  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
      boolean b=false;
    for(int i=0; i<_board.length; i++){
      if (i>0 && _board[i-1][col]==1){
        solveH(col+1);
      }
      if (_board[col][i]==0){
        addQueen(i,col);//add queen if possibl
      }
      else if (i == _board.length && _board[col][i] != 0){
        b=false;
      }
    }
    if (col < _board.length-1){
      solveH( col+1); //moves onto the next column
    }
//    else if (col >= _board.length) {
//      return true; //wait WHY? cuase this means that they r done with all the columns and this is gonna go out of bounds. That's y it should return false
//    }// exactly so if we managed to go through whole board then there is a solution and we should print true! When should we return false then???
    /*else {
      return false; //
  } */
  return b;
  }


  public void printSolution()
  {
      /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
     String ret=toString();
    String newR = "\n";
    for (int i=0; i<ret.length()-1; i++) {
      if(ret.substring(i,i+1).equals("-")) {
        newR+="_";
        i++;
      }
      else if(ret.substring(i,i+1).equals("1")) {
        newR+="Q";
      }

      else if(ret.substring(i,i+1).equals("\t")) {//nah this is not the way we can jst make the else statement underscore....
        newR+="\t";
      }
      else if(ret.substring(i,i+1).equals("\n")) {
        newR+="\n";
      }
      else{
           newR += "_";
         }
    }
         System.out.println(newR);

  }



  //================= YE OLDE SEPARATOR =================

  /***
   * adds queen to board, and blocks off all adjacent spaces with moves.
   * precondition: space is not occupied and spcae is not attackable.
   * postcondition: queen is placed in specified pos, and all spaces that the queen can move to are blocked off.
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false; //if it's not 0, that means it's either not a viable spot or it alreafy has a queen
    }
    _board[row][col] = 1; //puts queen
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--; // makes everything to the right of the queen decrease by one (makes it more negative)
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--; // the upward diagnol gets subtracted by one
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--; //the downward diagnol gets subtracted by one
 	    }
	    offset++;
    }
    return true;
  }


  /***
   * removes a queen from board, and also opens up spaces that are now available because there is no queen that can attack
   * precondition: there is a queen at this location!
   * postcondition: the queen is removed, all attackable spaces are opened up
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) { //if there is no queen
	    return false;
    }
    _board[row][col] = 0; //removes the queen
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++; //everything to the right plus one
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++; //the upward diagnol gets added by one
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++; //the downward diagnol gets added by one
	    }
	    offset++;
    }
    return true;
  }


  /***
   * prints out string representation of our chessboard!
   * precondition: chessboard initialized
   * postcondition: printed out
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    b.printSolution();
    QueenBoard c=new QueenBoard(6);
    System.out.println(c);
    b.solve();
    System.out.println(c);
  }

}//end class
