/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 * If placed in current working dir, will be consulted instead of
 * built-in Java library interface.
 *****************************************************/

public interface List<E>
{

    //add node to list, containing input String as its data
    public boolean add( E x );

    //return data in element at position i
    public E get( int i );

    //overwrite data in element at position i
    public E set( int i, E x ); 

    //return length of list
    public int size();

}//end interface
