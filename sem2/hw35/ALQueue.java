//Team Coachella -- James Huang, Zane Wang
//APCS2 pd1
//HW35 -- ...Nor Do Aussies
//2018-04-17T

import java.util.ArrayList;

public class ALQueue<E> {
    
    //instance var
    private ArrayList<E> line;
    
    //constructor
    public ALQueue() {
	line = new ArrayList<E>();
    }
    
    //methods
    public void enqueue(E x) {
	line.add(x);
    }
    
    public E dequeue() {
	return line.remove(0);
    }
    
    public E peekFront() {
	if (!isEmpty()) {
	    return line.get(0);
	}
	return null;
    }
    
    public boolean isEmpty() {
	return line.size()<=0;
    }
    
    public static void main(String[] args) {
	ALQueue b = new ALQueue();
	System.out.println(b.isEmpty());//true
	b.enqueue("tam");
	System.out.println(b.isEmpty());//false
	System.out.println(b.dequeue());//tam
	System.out.println(b.isEmpty());//true

	ALQueue hour = new ALQueue();
	System.out.println(hour.isEmpty());//true
	System.out.println(hour.peekFront());//null
	hour.enqueue("minutes");
	hour.enqueue("seconds");
	System.out.println(hour.peekFront());//minutes
	System.out.println(hour.dequeue());//minutes
	System.out.println(hour.peekFront());//seconds
	System.out.println(hour.dequeue());//seconds
    }
}
