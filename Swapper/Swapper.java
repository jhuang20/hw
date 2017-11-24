import cs1.Keyboard;
public class Swapper {
    /*v2 changes::
changed the 2D array to a random assortment of 3-letter strings, instead of a predetermined randomly arranged order of words
-added the concat(x) function to achieve this goal
edited the arrayStr() fxn to be neater and eaiser for the user to navigate
-made user input with row/column easier to understand for the end user

     */
    //instance vars
    public static int e,b,c,d;//
    public static String[][] ini=new String[10][10];//creating an empty array to populate with random 3 letter words
    public static final String a="abcdefghijklmnopqrstuvwxyz";//a reference string from which we create strings
    public static String stor;//stores value of one "cell" in the array
    
    /*concat(int)
uses String a to create a random string of length int
-int must be positive

    */
    public static String concat(int x){
	String y="";
	int start=0;
	for(int i=0;i<x;i++) {//constructs a string letter by letter(until it reaches the specified length
	    start=(int)(26*Math.random());//random number from 0-25
	    y+=a.substring(start,start+1);//add a random letter (from position 0 to 25)to the string
	}
	return y;//returns 3-letter word
    }
    /*fill()
populates array with 3 letter strings!
     */
    public static void fill(){
	for(int i=0; i<ini.length; i++) {//for each row
	    for(int x=0;x<ini[i].length; x++) {//go through each column(or each element)
		
		ini[i][x]=concat(3);//and fill it with a random 3 letter string
	    }
		
	}
  

	}
    /*arrayStr(String[] [])
takes a 2D array and presents it in a user-friendly form
     */
    public static String arrayStr(String[][] b) {
	String fab="";//start with the beginning of every list
	for (int i=0;b[0].length+1>i;i++) {//for the first row, list out the various columns to make it easier for the user to navigate
	    fab+="col"+i+" | ";;
	}
	fab+="\n";//new line for new row
	
	for(int x=0; x<b.length;x++) {//go through every row  in the list
	    fab+="row"+(x+1)+" | ";
	    for(int i=0; i<b[x].length;i++) {//each element in the row
	    fab+=b[x][i]+"  | ";//concatenate it to the string
	    }
	    fab+="\n";//new line because we reached the end of the row

	}

	return fab+"";
    }
    /*swap()
switches the position of two elements(locations specified by user)

     */
    public static void swap() {
	if (e<0 || b<0 || c<0 || d<0) {//if the user specified position is 0 or less, then display an error
	    System.out.println("error: all rows and colums must be 1 or greater");
	}
	stor=ini[e][b];//store the data of one of the elements
	ini[e][b]=ini[c][d];//set the element value of the coordinate position defined by (e,b) to the element value of the coordinate position defined by (c,d)
	ini[c][d]=stor;//(c,d)=(e,b)
      
    }
	
    
    public static void main(String[] args) {
	Swapper r=new Swapper();
	r.fill();
	System.out.println(arrayStr(ini));
	System.out.println("please pick a row");
	e=Keyboard.readInt()-1;
	System.out.println("please pick column");
	b=Keyboard.readInt()-1;
	System.out.println("pick a row to swap with");
	c=Keyboard.readInt()-1;
	System.out.println("pick a column to swap with");
	d=Keyboard.readInt()-1;
	r.swap();
	System.out.println(arrayStr(ini));
	System.out.println("swapped "+stor+" in position ("+(e+1)+","+(b+1)+") with "+ini[e][b]+" in position ("+(c+1)+","+(d+1)+")");
	
	
    }
}
