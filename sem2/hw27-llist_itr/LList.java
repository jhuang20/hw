//jamss huang and richard wong
//hw27--list iterator
//2018-03-27
//brown apcs pd01
// I think we have something working here, but I'm not sure if we are implementing iterable(I feel like at least our idea is solid,
//i dont really have the time to do debugging rn )

/*****************************************************
 * class LList v6
 * Implements a linked list of DLLNodes.
 * Version 06 is iterable via FOREACH loop
 * (...because modifications were made to local List interface.)
 *****************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LList<T> implements List<T>
{
  // Your List.java must be in same dir to supersede
  // built-in Java List interface

  //instance vars
  private DLLNode<T> _head, _tail; //pointers to first and last nodes
  private int _size;

  // constructor -- initializes instance vars
  public LList()
  {
    _head = _tail = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------------------------------------------------
  //--------------v  List interface methods  v--------------
  //--------------------------------------------------------

  //append a new node to end of list
  public boolean add( T newVal )
  {
    addLast( newVal );
    return true; //per Java API spec
  }


  //insert a node containing newVal at position index
  public void add( int index, T newVal )
  {
    if ( index < 0 || index > size() )
	    throw new IndexOutOfBoundsException();

    else if ( index == size() )
	    addLast( newVal );

    DLLNode<T> newNode = new DLLNode<T>( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
	    addFirst( newVal );
    else {
	    DLLNode<T> tmp1 = _head; //create alias to head

	    //walk tmp1 to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp1 = tmp1.getNext();

	    //init a pointer to node at insertion index
	    DLLNode<T> tmp2 = tmp1.getNext();

	    //insert new node
	    newNode.setNext( tmp2 );
	    newNode.setPrev( tmp1 );
	    tmp1.setNext( newNode );
	    tmp2.setPrev( newNode );

	    //increment size attribute
	    _size++;

    }
  }//end add-at-index


  //remove node at pos index, return its cargo
  public T remove( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    if ( index == 0 )
	    return removeFirst();
    else if ( index == size()-1 )
	    return removeLast();
    else {
	    DLLNode<T> tmp1 = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ ) {
        tmp1 = tmp1.getNext();
        System.out.println( "tmp1: " + tmp1.getCargo() );
	    }
	    //check target node's cargo hold
	    T retVal = tmp1.getNext().getCargo();

	    //remove target node
	    tmp1.setNext( tmp1.getNext().getNext() );
	    System.out.println( "tmp1.getNext: " + tmp1.getNext().getCargo() );
	    tmp1.getNext().setPrev( tmp1 );

	    _size--;

	    return retVal;
    }
  }


  public T get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------------------------------------------------
  //--------------^  List interface methods  ^--------------
  //--------------------------------------------------------


  //--------------v  Helper methods  v--------------

  public void addFirst( T newFirstVal )
  {
    //insert new node before first node (prev=null, next=_head)
    _head = new DLLNode<T>( newFirstVal, null, _head );

    if ( _size == 0 )
	    _tail = _head;
    else
	    _head.getNext().setPrev( _head );
    _size++;
  }


  public void addLast( T newLastVal )
  {
    //insert new node before first node (prev=_last, next=null)
    _tail = new DLLNode<T>( newLastVal, _tail, null );

    if ( _size == 0 )
	    _head = _tail;
    else
	    _tail.getPrev().setNext( _tail );
    _size++;
  }


  public T getFirst() { return _head.getCargo(); }

  public T getLast() { return _tail.getCargo(); }


  public T removeFirst()
  {
    T retVal = getFirst();
    if ( size() == 1 ) {
	    _head = _tail = null;
    }
    else {
	    _head = _head.getNext();
	    _head.setPrev( null );
    }
    _size--;
    return retVal;
  }


  public T removeLast()
  {
    T retVal = getLast();
    if ( size() == 1 ) {
	    _head = _tail = null;
    }
    else {
	    _tail = _tail.getPrev();
	    _tail.setNext( null );
    }
    _size--;
    return retVal;
  }
  //--------------^  Helper methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }



  /*****************************************************
   * inner class MyIterator
   * Adheres to specifications given by Iterator interface.
   * Uses dummy node to facilitate iterability over LList.
   *****************************************************/
  public class MyIterator implements Iterator<T>
  {
    private DLLNode<T> _dummy;   // dummy node to tracking pos
    private boolean _okToRemove; // flag indicates next() was called

    //constructor
    public MyIterator iterator()
    {
				MyIterator retItr = new MyIterator();
      	return retItr;
    }


  /*****************************************************
   * inner class MyIterator
   * Adheres to specifications given by Iterator interface.
   * Uses dummy node to facilitate iterability over LList.
   *****************************************************/
public class MyIterator<T> implements Iterator<T>
  {
    private DLLNode<T> _dummy;   // dummy node to tracking pos
    private boolean _okToRemove; // flag indicates next() was called

    //constructor
    public MyIterator()
    {
      /* "Follow your inner moonlight; don't hide the madness."
         -Allen Ginsberg */
         _dummy = _head;//copies Linked list
         _okToRemove = false;//initally true cause we have not called it!

    }

    //-----------------------------------------------------------
    //--------------v  Iterator interface methods  v-------------
    //return true if iteration has more elements.
    public boolean hasNext()
    {
      /* "Follow your inner moonlight; don't hide the madness."
         -Allen Ginsberg */

         return _dummy.getNext() != null;//

    }


    //return next element in this iteration
    public T next()
    {
      /* "Follow your inner moonlight; don't hide the madness."
         -Allen Ginsberg */
        if (!(hasNext())) {
        throw new IndexOutOfBoundsException();
        }
        else {
         _dummy = _dummy.getNext();
         _okToRemove=true;
         return _dummy;

         }
    }


    //remove last element returned by this iterator (from last next() call)
    //postcondition: maintains invariant that _dummy always points to a node
    //               (...so that hasNext() will not crash)
    public void remove()
    {
      //Q: What is significance/purpose of these lines?
      //If okToRemove is false, it is not okay to remove
      if ( ! _okToRemove )
        throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false

	    //if we are removing the first element!
	    if (_dummy.getPrev()==null) {
      _dummy=_dummy.getNext();
	    }
	    //if we are removing the last element
	    else if (_dummy.getNext()==null) {
      _dummy=_dummy.getPrev();
	    }
      //
      //
      // Q: How many ELSE-IF's are necessary?
      // Q: What are the cases you must consider?
      //we only need to consider the first, and the last, and all the element in the middle
      //
	    //if we are removing anything else!
	    else {
      _dummy.setPrev(_dummy.next());//removes element!
	    }

      //Q: Anything else need to be done?

    }//end remove()
    //--------------^  Iterator interface methods  ^-------------
    //-----------------------------------------------------------
  }//*************** end inner class MyIterator ***************



  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println("initially: " );
    System.out.println( james + "\tsize: " + james.size() );

    james.add("beat");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("a");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("need");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("I");
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james + "\tsize: " + james.size() );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james + "\tsize: " + james.size() );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );
  }//end main()

}//end class LList
