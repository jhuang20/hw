//james huang
//hw41-
//apcs pd01 brown
//2017-11-27
/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
      _data=new int[10];//initializes data as a 10-item array(it was previously initialized)
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
      String ret="[";//start out with a bracket at beginning
      for (int i=0;i<_data.length; i++) {
	  ret+=_data[i]+",";//for each element add it to the returned string, and add a comma
      }
      return ret+"]";//add a bracket to top it all off
  }


  //double capacity of SuperArray
  private void expand()
  {
      int[] copy=new int[10];//initializes an array we will use for copying data in _data(its the same length)
      for (int i=0;i<copy.length; i++) {
	  copy[i]+=_data[i];//for each element in _data copy it over to the corresponding element in copy
      }
      _data=new int[_data.length * 2];//reinitialize data after copying to an int array with double the length
      for (int i=0;i<copy.length; i++) {
	  _data[i]+=copy[i];//copy over the values from copy to _data
      }
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
      return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
      
  {
      int ret=_data[index];
      _data[index]=newVal;
      return ret;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
