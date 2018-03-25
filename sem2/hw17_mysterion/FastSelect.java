//james huang
//2018-03-11
//hw17--so fast
//brown apcs pd01
/*after researching with partition did, the only
algorithm i could think of was an O(n^2) algorithm that basically
traversees through the list using parition, and then finds the nth smallest
element. WHile this runs in O(n^2) time, I believe that it is actually slightly faster.
The parition function is faster than just traversing through the entire list, so the
normalized case scenario will likely be faster for this one than it was for selection or bubble sort
*/

public class FastSelect {
  //int[] cent;
  public String printArray(int[] arr) {
    String ret="[]";
    for(int i=0; i< arr.length; i++) {
      ret+=arr[i]+",";
    }
    return ret+"]";
  }
  public int[] swap(int[] arr,int a, int b){
    int v=arr[a];
    arr[a]=arr[b];
    arr[b]=v;
    return arr;
  }
  public int partition(int[] arr, int left, int right, int pvtPos) {
    System.out.println(printArray(arr));

    int pvtVal=arr[pvtPos];
    arr=swap(arr,pvtPos,right);
    int s=left;
    System.out.println(printArray(arr));
    //System.out.println(arr);
    for(int i=left; i<=right-1; i++) {
      if (arr[i]<pvtVal) {
        arr=swap(arr,s,i);
        s+=1;
        System.out.println(printArray(arr));
        //System.out.println(arr);
      }
    }
    arr=swap(arr,right,s);
    System.out.println(printArray(arr));
    //System.out.println(arr);
    //cent=arr;
    return s;
  }
  //we must sort algorithm, uses partition
  public int quickFind(int[] arr,int size) {
    //int x=0;
    int[] cent=new int[arr.length];
    int i=0;
    for(int x=0;x<arr.length-1;x++ ){
      i=partition(arr,0,arr.length-1,x);
      cent[i]=arr[x];

  }
return cent[size];

  }
  public static void main(String[] args) {
    FastSelect g=new FastSelect();
    int[] d={1,2,3,4,5};
    int[] e={2,5,4};
    int[] f={17,12,72,128,7,3,1,5};
    /*parition test
    System.out.println(g.partition(d,1,2,3));//returns 1
    System.out.println(g.partition(e,0,0,0));//what happens if everything is 0(nothing changes)
    System.out.println(g.partition(e,0,2,1));//returns 2(exception case)
    System.out.println(g.partition(f,1,7,3));//returns 6*/
    //sort tester
      //System.out.println(g.quickFind(f,0));//doenst work
      System.out.println(g.quickFind(f,1));
        System.out.println(g.quickFind(f,2));
          System.out.println(g.quickFind(f,3));
            System.out.println(g.quickFind(f,4));
              System.out.println(g.quickFind(f,5));
                System.out.println(g.quickFind(f,6));
                  System.out.println(g.quickFind(f,7));//doesnt work
                }
              }
