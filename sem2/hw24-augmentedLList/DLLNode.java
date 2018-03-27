/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a E
 *****************************************************/

public class DLLNode<E>
{
    //instance vars
    private E _cargo;    //cargo may only be of type E
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _prevNode;

    // constructor -- initializes instance vars
    public DLLNode( E value, DLLNode next, DLLNode prev) {
	_cargo = value;
	_nextNode = next;
  _prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public E getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }
    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public E setCargo( E newCargo ) {
	E foo = getCargo();
	_cargo = newCargo;
	return foo;
    }
public DLLNode setPrev (DLLNode newPrev) {
  DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
}
    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toE
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args )
    {
/*
	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", null, null) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null) );

	/* A naive list traversal, has side effects.... ??
	   while( first != null ) {
	   System.out.println( first );
	   first = first.getNext();
	   }
	*/

	//Q: when head ptr moves to next node in list, what happens to the node it just left?

	//...so better: ?
	//
	//
	//

    }//end main

}//end class DLLNode
