//james huang
//apcs pd01
//2017-12-10
//hw50--dat bubbly tho
/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
      int sort_mult=data.size();//tells us how many times we need to go through to sort the array
      for(int p=0; sort_mult>0; sort_mult--) {//we go through the list size(0-1 times(thats what the algo tells us to do)
	  for(int i=data.size()-1;i>0;i--) {//goes from last element to first element, 
	      if (data.get(i).compareTo(data.get(i-1))<0) {//if the element is larger
		  Comparable a=data.get(i-1);
		  data.set(i,a);
		  data.set(i-1, i);//swap positions
	      }
	  }
	  
      }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
      ArrayList<Comparable> data=new ArrayList<Comparable>();//makes a totally new list;
      for (Comparable i:input) {//goes through each element of the input ArrayList
	  data.add(i);
      }
      //fellow thinkers on the QAF solved this issue :) Thank you fellow thinkers :)
      //the problem was that I was originally creating an ALIAS of the list, not a totally different copy
      bubbleSortV(data);
      //System.out.println(data);
      
      return data;
  }


  public static void main( String [] args )
  {

    
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      //============================================*/

      //==========for AL-returning methods==========
    	ArrayList alen = new ArrayList<Integer>();
      alen.add(7);
      alen.add(1);
      alen.add(5);
      alen.add(12);
      alen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + alen );
      ArrayList alenSorted = bubbleSort( alen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + alenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + alen );

      ArrayList boco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + boco );
      ArrayList bocoSorted = bubbleSort( boco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + bocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + boco );
      
      //============================================*/

  }//end main

}//end class BubbleSort
