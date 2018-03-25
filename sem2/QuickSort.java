//Shafali Gupta
//APCS2 pd01
//HW18 -- QuickSort
//2018-03-13t

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 *Find the final position of the last element of the unsorted list using partition.
 *Then, you split the array into two, based on the pivot and recursively split it into two, using partition each time.
 * 2a. Worst pivot choice and associated runtime:
 * pivot is the first or last element, runtime of n^2
 * 2b. Best pivot choice and associated runtime:
 *pivot is the middle, nlog(n)
 * 3. Approach to handling duplicate values in array:
 * don't swap unless the value is less than the pivot.
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }
  public static void printToCSV( int[] r){
      //System.out.println("target, size (nanos), size");
      long pre = System.nanoTime();
      qsort(r);
      long current = System.nanoTime();
      System.out.println( r.length + ", " + (current-pre));
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
    QuickSort(d, 0, d.length -1);
  }
  public static int[] QuickSort(int[] d, int low, int high){
    if (low< high){
      int pivot= partition(d, low, high);
      QuickSort(d, low, pivot - 1);
      QuickSort(d, pivot +1, high);
    }
    return d;
  }
  public static int partition( int arr[], int left, int right)
  {
    int v = arr[right];
    int i = left - 1;
    for (int j = left; j< right; j++){
      if (arr[j] < v){
        i +=1;
        swap(i, j, arr);
      }}
    swap(i+1, right, arr);
    return i+1;

  }//end partition

  //you may need a helper method...


  //main method for testing
  public static void main( String[] args )
  {
    int j=2000;
  for(;j<40000; j+=500) {
    // arrays of randomly generated ints
    int[] arrMatey = new int[j];
    for( int i = 0; i < arrMatey.length; i++ ) {
      arrMatey[i] = (int)( 10000* Math.random() );
    }
    printToCSV(arrMatey);
  }
  }//end main

}//end class QuickSort
