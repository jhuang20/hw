//james huang
//hw34--The English Do not wait in line!
//2018-04-15
//brown apcs pd01
public class NodeQueue<Quasar> implements Queue<Quasar> {
  //instance vars
  private LLNode<Quasar> cen;//transverser
  private LLNode<Quasar> first;//stays at first pos
    private int size;
  //constructor
  public NodeQueue() {
    //LLNode<Quasar> cen=new LLNode("blank",null);
    size=0;//set size attribute to 0
  }
  public Quasar dequeue() {
    if (isEmpty()) {
      return null;
    }
    //System.out.println(first.getValue());
    Quasar ret=first.getValue();//gets present value at front
    first=first.getNext();//gets the next value, sets as first
    size-=1;//decrement size by 1
    return ret;//return removed value

  }
  public void enqueue(Quasar x) {
    if (isEmpty()) {//if this a totally new queue
      first=new LLNode<Quasar>(x,null);//set first pointer as new one!
      first.setNext(cen);
      size+=1;
    }
    else if(size==1) {
      cen=new LLNode<Quasar>(x,null);
      first.setNext(cen);
      size+=1;
    }
    else {
    LLNode<Quasar> temp=new LLNode<Quasar>(x, null);//make a temp variable, temp, to be added to end!

    cen.setNext(temp);
    cen=temp;
    size+=1;
  }
  }
  public boolean isEmpty() {
    if (size<=0) {
      return true;
    }
    return false;
  }
  public Quasar peekFront() {
    return first.getValue();
  }
  public static void main(String[] args) {
    NodeQueue a=new NodeQueue();
    a.enqueue("tam");
    System.out.println(a.isEmpty());//false
    System.out.println(a.dequeue());
    System.out.println(a.isEmpty());//true
    //System.out.println(acen);
    a.enqueue("a");
    a.enqueue("b");
    a.enqueue("c");
    a.enqueue("d");
    a.enqueue("e");
    //System.out.println(a.cen.getNext());
    System.out.println(a.peekFront());//a
    System.out.println(a.dequeue());//a
    System.out.println(a.dequeue());//b
    System.out.println(a.dequeue());
    System.out.println(a.dequeue());
    System.out.println(a.dequeue());//e

    System.out.println(a.isEmpty());//true
  }
}
