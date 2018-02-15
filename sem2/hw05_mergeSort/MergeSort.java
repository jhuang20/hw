//james huang
//2018-2-7
//hw05
//brown apcs2 pd01
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
My algorithm basically splits the array into two pieces, and keeps on splitting until we reach asorted list.
(or basically 1 element array)
We then use the merge() function to combine two arrays into one sorted one, and we progressively make our way
towards one big sorted list!
  ======================================*/


public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int x=0;
    int y=0;
    int c=0;
    int[] arr=new int[a.length+b.length];
    if(a.length>b.length) {
      while(x<b.length && y<b.length) {
        if(a[x]>b[y]) {
          arr[c]=b[y];
          c++;
          y++;
        }
        else {
          arr[c]=a[x];
          c++;
          x++;
        }
      }
      for(int d=0;d<b.length-x;d++) {
        arr[c]=b[d+x];
        c++;
      }
    }
    else {
      while(x<a.length && y<b.length) {
        if(a[x]>b[y]) {
          arr[c]=b[y];
          c++;
          y++;
        }
        else {
          arr[c]=a[x];
          c++;
          x++;
        }
      }
      for(int d=0;d<b.length-y;d++) {
        System.out.println(d+y);
        arr[c]=b[d+y];
        c++;
      }

    }
      //System.out.println("array merged");
    //printArray(arr);
    return arr;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
    public static int[] sort( int[] arr )
  {
//recursion!
// BASE CASE: if array length is 1, it is already sorted
          if (arr.length <= 1) {
               return arr;
          } int mid = arr.length / 2; // midpoint for splitting arrays

          // these two arrays have lengths that add up to original array
          int[] a = new int[mid];
          int[] b = new int[arr.length - mid];

          // populates the two halves of the original array with
          // their corresponding values
          for (int i = 0; i < mid; i++ ) {
               a[i] = arr[i];
          } for (int x = 0; x < b.length; x++) {
               b[x] = arr[x + mid];
          }
          // recursively call this method to keep merging halves of the original
          // array, until the array is length 1, where it is returned and merged
          // with its complementary array
          //System.out.println("array A");
          //printArray(a);
          //  System.out.println("array b");
        //  printArray(b);
          return (merge(sort(a), sort(b)));

}//end sort()*/



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {


      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4,5,6,7};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {0,2,3,8,16,17,18,19,20};
      int[] arr7 = {8,10,11,9,23};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      //printArray( sort( arr4 ) );
      //printArray( sort( arr5 ) );
      //printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
