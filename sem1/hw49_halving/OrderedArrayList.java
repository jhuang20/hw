//james huang
//hw49--halving the halves
//apcs pd01
//2017-12-7

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }


  public String toString()
  {
    return _data.toString(); 
  }


  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }


  public int size()
  { 
    return _data.size();
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); 
  }


  /***
   * add takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a linear search to find appropriate index
   ***/
  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }
    /***
     * addBin has a prerequisite of already having a sorted list(it cannot be used to initialize)
     * goes to the halfway point of the list
     * makes a "guess", the parameters for guessing change based on whether the newVal is bigger or smaller than the element at the halfway point.
     * keeps on halving the range until we reach a point where the upper bound and lower bounds for possible locations are the same
     * inserts it there
     ***/
    public void addBin(Comparable newVal)
    {
	int upper=_data.size();//the initial upper bound is at the end of the list(last element)
	int lower=0;//lower bound is first element
	
	
	int guess=0;//counts guesses
	while(true) {
	   
	    if(upper==lower) {//if the upper and lower bounds for the possible elements are the same, then of course there is only one option...
		_data.add(upper,newVal);//to add the newVal at that element
		System.out.println(guess);
		break;//ends program
	    }
	    if( ( (int)newVal.compareTo((int)_data.get((int)((upper+lower)/2)))<0)) {//if the newVal is smaller than the element halfway location-wise in the possible ranges... 
		upper=(int)(upper+lower)/2;//make the  halfway point the upper range
		guess+=1;
		
	    }
	    else {//otherwise, newVal must be larger than the element halfway location-wise in the possible ranges...
		lower=((int)(upper+lower)/2)+1;//make the halfway point the lower range, add one to ensure future parity
		guess+=1;
		
		    
	    }

	   
	}
    }


  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
    Franz.addBin(2);
    Franz.addBin(4);
    Franz.addBin(0);
    Franz.addBin(38);
    Franz.addBin(-10);
    System.out.println(Franz);
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
