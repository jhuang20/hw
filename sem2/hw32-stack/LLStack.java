//james haung
//apcs pd01 brown
//hw32 Leonwood Leonwood Stack
//2018-4-11
import java.util.LinkedList;
public class LLStack<E> implements Stack<E>{
  private LinkedList<E> _stack=new LinkedList<E>();
  //private int _stackSize;
  //although many of these functions are linear time, they actually are constant time because its always at the last or first indicies, making it effectively constant time

  public boolean isEmpty(){
    if (_stack.size()==0) {//this is a build in method
      return true;
    }
    return false;
  }

  //Return top element of stack without popping it.
  public E peek() {
    if (isEmpty()) {//if its empty then return null
      return null;
    }
    return _stack.get(_stack.size()-1);//retrives element at that index

  }

  //Pop and return top element of stack.
  public E pop(){
    if (isEmpty()) {
      return null;
    }
    E ret=peek();
    _stack.removeLast();
    return ret;
  }

  //Push an element onto top of this stack.
  public void	push( E x ){
    _stack.add(x);
  }
  public static void main(String[] args) {

  }
}
