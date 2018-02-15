//Team Grapefruit
//Roster: James Huang, Sophia Xia
//APCS1 pd1
//HW54 -- One File to Bring Them All...
//2017-12-13
import java.util.ArrayList;
public class MySorts {
    //array constructors
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
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~Selection Sort~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*** there is no best or worst case scenario, each number is still being compared to the other numbers no matter what!
	 (even if SelectionSort was totally ordered, it would be the same number of passes)
	 why?
	 because we still need to compare the "reigning champ" to every other number, and thus the same number of comparisons must be performed.
    HOWEVER, in some cases, fewer swaps may be needed.***/

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	System.out.println("this is the selction sort algorithm on"+ data);
	int sort_mult=data.size();//tells us how many times we need to go through to sort the array
	for(int p=0; p<sort_mult; p++) {//this is the pass counter(p stands for pass). p is also the element for which we will be finding the correct number for
	    System.out.println("Commencing pass #"+(p+1)+"...");
	    for(int i=sort_mult-1;i>=p;i--) {//int i is the last element in the list, and we will compare every number from the location of the last element to the location of p.
		if (data.get(i).compareTo(data.get(p))<0){ //if i is smaller than the element currently at p
		    data.set(i,data.set(p,data.get(i)));//swap the elements
		    //continue this until we reach the element immediately adjacent, and then we will have found the smallest element in the subset [p,i]
		}
	    }
	}
    }//end selectionSortV
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Bubble Sort~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*BEST CASE SCENARIO:the list is completely sorted(no passes need to sort)
      WORST CASE SCENARIO: list is in descending order(n-1 passes needed to sort) 
    */
    public static void bubbleSortV( ArrayList<Comparable> data )
    {
	System.out.println("this is the bubble sort algorithm on"+ data);
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
		//System.out.println(data); //diag: show current state of list
	    }
	}
    }//end BubbleSort V


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Insertion Sort~~~~~~~~~~~~~~~~~~~~
    /*BEST CASE SCENARIO: List already sorted
      WORST CASE SCENARIO: List is in descending order(most swaps required)
    */
    public static void insertionSortV( ArrayList<Comparable> data )
    {
	System.out.println("this is the insertion sort algorithm on"+ data);
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSortV
}
