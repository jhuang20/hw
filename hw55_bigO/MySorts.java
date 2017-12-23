//Team Grapefruit
//Roster: James Huang, Sophia Xia
//APCS1 pd1
//HW55 
//2017-12-13
/***
FOR OrderedArrayList
add()--
Exceution time:
Best case scenario: O(1), this is when the element we are adding is smaller than all other terms in the ArrayList. It is O(1) because you are adding one term and it requires only 1 pass to complete what you need to do.
Worst Case Scenario: O(n), this is when the element we are adding is larger than all the numbers (or Comparables) in an OrderedArrayList of Length n. THus, the method must perform n passes( with each pass being a comparison between the number being added and the element at index i), before it reaches the place where it can be added.
addBin()--
Best case scenario: O(1), this is when the element we are adding is smaller than all other terms in the ArrayList. It is O(1) because you are adding one term and it requires only 1 pass to complete what you need to do.
Worst Case Scenario:O(log2(n)). In the worst case scenario, addBin would reach the ceiling of log2(n) *n refers to number of terms in list, as it would keep on subdividing the list into 2 until reaching 1 definitive term!
 ***/
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
    HOWEVER, in some cases, fewer swaps may be needed.
Classification: for all cases, O(n^2)--you're making n passes going through n elements!
***/

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
    /*BEST CASE SCENARIO:O(1),the list is completely sorted(no passes need to sort)
      WORST CASE SCENARIO:O(n^2), list is in descending order(n-1 passes needed to sort). ex: You are making 5 swaps per pass, and 5 passes for a 5 element list

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
    /*BEST CASE SCENARIO: List already sorted (O(1))
      WORST CASE SCENARIO: O(n^2)List is in descending order(most swaps required). You are creating a partition by comparing n numbers n times.
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
