public class MatrixFinder {
/*OUR ALGO:
The essence of our algo is a recursive function, search, that goes through the 2D array from the top right to the bottom left. It's faster than just going from top left 
to the end of the list because it allows us to take some shortcuts. If the vlaue you are looking for in greater than the number in the top right, you would move down 
one row. If you get to the bottom right and the value is greater than the number at the bottom right, then return (-1,-1). If the number is smaller in any row, it 
would go across to the left my one each time.
*/
//instance var
int[][] a;
int size;
//method
  public String isThere(int[][] c, int value){
    a=c;
    size=c.length-1;
    return search(0,size, value);
  }
//recursive function that snakes through the list(TOP RIGHT to BOTTOM )
  public String search(int row, int col, int value) {
    //base case 1: we already went through entire list, we end it(emergency end)

    //idk i think its okay cause its easier for us in main class
    
    //base case 2: we found the number, hooray!
    if(a[row][col]==value) {
      return "("+row+","+col+")";
    }
    //express skip!
    else if(a[row][col]<value) {
      search(row+1, size, value);//moves to next row, last number in array
    }
    //ugh the SLOW way
    else if(row<size){
      if(col>=0) {
        search(row+1, size, value);//moves to next row, last number in array
      }
      else {
        search(row, col-1, value);//moves to next col
      }
      }
    else {
	return "-1,-1";
    }
    return "-1";
  }
//main class
  public static void main(String[] args) {
    MatrixFinder test=new MatrixFinder();
    int[][] b=new int[4][4];//make a test array
    int c=0;
    //construct an array
    for(int i=0; i<b.length; i++) {
      for(int a=0; a<b.length; a++) {
        b[i][a]=c;
	System.out.println(c);
        c+=10;
      }
    }
    
    System.out.println(test.isThere(b, 20));
    System.out.println(test.isThere(b, -1));
    System.out.println(test.isThere(b, 1000));
      


  }
}
