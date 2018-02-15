//Team Grapefruit
//Roster: James Huang, Sophia Xia
//APCS1 pd1
//HW53 -- Solid Comparative Analysis
//2017-12-13

import java.util.ArrayList;

public class SortTester {

    //Main Method
    public static void main(String[] args) {
	//efficient coding calls for Ctr- , M-w, Ctr-y, and M-%
	
	//--------------------BUBBLESORT TEST--------------------
	/*BEST CASE SCENARIO:the list is completely sorted(no passes need to sort)
	  WORST CASE SCENARIO: list is in descending order(n-1 passes needed to sort) 
	*/
	System.out.println("Testing bubbleSort...");
	ArrayList bestbob = new ArrayList<Integer>();
	bestbob.add(1);
	bestbob.add(2);
	bestbob.add(3);
	bestbob.add(4);
	bestbob.add(5);
	System.out.println( "ArrayList bestbob before sorting:\n" + bestbob );
	MySorts.bubbleSortV(bestbob);
	System.out.println( "ArrayList bestbob after sorting:\n" + bestbob );
	
	ArrayList worstbob = new ArrayList<Integer>();
	worstbob.add(5);
	worstbob.add(4);
	worstbob.add(3);
	worstbob.add(2);
	worstbob.add(1);
	System.out.println( "ArrayList worstbob before sorting:\n" + worstbob );
	MySorts.bubbleSortV(worstbob);
	System.out.println( "ArrayList worstbob after sorting:\n" + worstbob );

	ArrayList bobatea = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList bobatea before sorting:\n" + bobatea );
	MySorts.bubbleSortV(bobatea);
	System.out.println( "ArrayList bobatea after sorting:\n" + bobatea );

	
	//--------------------SELECTION SORT--------------------
	/*** there is no best or worst case scenario, each number is still being compared to the other numbers no matter what!
	     (even if SelectionSort was totally ordered, it would be the same number of passes)
	     why?
	     because we still need to compare the "reigning champ" to every other number, and thus the same number of comparisons must be performed.
	     HOWEVER, in some cases, fewer swaps may be needed.***/

	System.out.println("Testing selectionSort...");
	ArrayList twinStacey = new ArrayList<Integer>();
	twinStacey.add(7);
	twinStacey.add(1);
	twinStacey.add(5);
	twinStacey.add(12);
	twinStacey.add(3);
	System.out.println( "ArrayList twinStacey before sorting:\n" + twinStacey );
	MySorts.selectionSortV(twinStacey);
	System.out.println( "ArrayList twinStacey after sorting:\n" + twinStacey );

	ArrayList twinSerina = new ArrayList<Integer>();
	twinSerina.add(1);
	twinSerina.add(3);
	twinSerina.add(5);
	twinSerina.add(7);
	twinSerina.add(12);
	System.out.println( "ArrayList twinSerina before sorting:\n" + twinSerina );
	MySorts.selectionSortV(twinSerina);
	System.out.println( "ArrayList twinSerina after sorting:\n" + twinSerina );
	
	ArrayList sugar = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList sugar before sorting:\n" + sugar );
	MySorts.selectionSortV(sugar);
	System.out.println( "ArrayList sugar after sorting:\n" + sugar );

	
	//--------------------INSERTION SORT--------------------
	/*BEST CASE SCENARIO: List already sorted
	  WORST CASE SCENARIO: List is in descending order(most swaps required)
	*/

	ArrayList bestirene = new ArrayList<Integer>();
	bestirene.add(1);
	bestirene.add(3);
	bestirene.add(5);
	bestirene.add(7);
	bestirene.add(12);
	System.out.println( "ArrayList bestirene before sorting:\n" + bestirene );
	MySorts.insertionSortV(bestirene);
	System.out.println( "ArrayList bestirene after sorting:\n" + bestirene );

	System.out.println("Testing insertionSort...");
	ArrayList worstirene = new ArrayList<Integer>();
	worstirene.add(7);
	worstirene.add(1);
	worstirene.add(5);
	worstirene.add(12);
	worstirene.add(3);
	System.out.println( "ArrayList worstirene before sorting:\n" + worstirene );
	MySorts.insertionSortV(worstirene);
	System.out.println( "ArrayList worstirene after sorting:\n" + worstirene );

	ArrayList icing = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList icing before sorting:\n" + icing );
	MySorts.insertionSortV(icing);
	System.out.println( "ArrayList icing after sorting:\n" + icing );

    }//end main
    
}//end class SortTester.java
