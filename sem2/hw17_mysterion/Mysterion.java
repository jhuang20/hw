//james huang
//2018-03-11
//hw17--so fast
//brown apcs pd01
/*PSEUDOCODE
*function Mysterion(a, b, c, arr)
   v = arr[c]
   swap arr[c], arr[b]
   s = a
   for i in [a ... b-1]
      if arr[i] < v
         swap arr[s], arr[i]
         s += 1
   swap arr[b], arr[s]
   return s

*/
//after multiple test calls, I still am unable to determine what the hell this thing does!
//It seems to defy all my expectations. I thought it couldve been a sort related thing, but it wasnt
// partition WHAT IT IS!!!
public class FastSelect {
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
    //System.out.println(printArray(arr));

    int pvtVal=arr[pvtPos];
    arr=swap(arr,pvtPos,right);
    int s=left;
    //System.out.println(printArray(arr));
    //System.out.println(arr);
    for(int i=left; i<right-1; i++) {
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
    return s;
  }
  public int quickFinder
  public static void main(String[] args) {
    Mysterion g=new Mysterion();
    int[] d={1,2,3,4,5};
    int[] e={2,5,4};
    int[] f={17,12,72,128,7,3,1,5};
    //parition test
    System.out.println(g.partition(d,1,2,3));//returns 1
    System.out.println(g.partition(e,0,0,0));//what happens if everything is 0(nothing changes)
    System.out.println(g.partition(e,0,2,1));//returns 2(exception case)
    System.out.println(g.partition(f,1,7,3));//returns 6



  }
}
