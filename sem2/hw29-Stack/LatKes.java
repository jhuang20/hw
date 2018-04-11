//james huang
//hw30-Stacks on Stacks on Stacks
//brown apcs pd01
//2018-4-9
/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *To the best of my understanding, this is basically an implementation of LinkedList, but in array form.
 * I did the HW with that interpretaton in mind
 *****************************************************/
//not sure how to do error messages.. and theres a null error, and of course theres the chance i completely misunderstood what the qaf is saying...but heres what i have!
public class Latkes
{
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
    _stack=new String[size];
    _stackSize=0;
    //create a new, empty list with size specified by user. Size should be 0 because THERE ARENT ANY ELEMENTS
  }

  //means of insertion
  public void push( String s )
  {
    //according to the ever so knowledgable being that is the QAF, push adds to the beginning of an array!
    if(isFull()) {
      throw new StackOverflowError("too long!");
    }
    else {
    String p;
    String stor=_stack[0];
    _stack[0]=s;
    p=_stack[1];
    _stack[1]=stor;
    for(int i=2; i<_stack.length-1;i++) {
      String n=_stack[i];
      _stack[i]=p;
      p=_stack[i+1];
    }
    _stackSize+=1;
  }
  }

  //means of removal
  public String pop( )
  {

    String ret=_stack[_stackSize-1];
    _stack[_stackSize-1]=null;
    _stackSize-=1;
    return ret;
  }

  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize==0;
  }

  //chk for fullness
  public boolean isFull()
  {
    return _stackSize>=_stack.length;
  }


  //main method for testing
  public static void main( String[] args )
  {
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v*/
      Latkes tastyStack = new Latkes(10);

      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
      //tastyStack.push("coocoo");
      //tastyStack.push("cachoo");
      System.out.println(tastyStack._stack[0]);
      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
      /*^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
