import java.util.ArrayList;
public class ALStack<E> implements Stack<E>{
  private ArrayList<E> _stack=new ArrayList<E>();
  //private int _stackSize;

  public boolean isEmpty(){
    if (_stack.size()==0) {
      return true;
    }
    return false;
  }

  //Return top element of stack without popping it.
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return _stack.get(_stack.size()-1);

  }

  //Pop and return top element of stack.
  public E pop(){
    if (isEmpty()) {
      return null;
    }
    E ret=peek();
    _stack.remove(_stack.size()-1);
    return ret;
  }

  //Push an element onto top of this stack.
  public void	push( E x ){
    _stack.add(x);
  }
  public static void main(String[] args) {

  }
}
