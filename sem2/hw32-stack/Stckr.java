/*****************************************************
*James Huang
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{
    public static void main( String[] args )
    {
	Stack cakes = new ALStack();
  cakes.push("foo");
  System.out.println(cakes.peek());
  System.out.println(cakes.pop());
  cakes.push("boo");
  cakes.push("moo");
  System.out.println(cakes.pop());
  System.out.println(cakes.pop());
  System.out.println(cakes.pop());//should be null
  System.out.println(cakes.pop());
	Stack akes = new LLStack();
  akes.push("foo");
  System.out.println(akes.peek());
  System.out.println(akes.pop());
  akes.push("boo");
  akes.push("moo");
  System.out.println(akes.pop());
  System.out.println(akes.pop());
  System.out.println(akes.pop());//should be null
  System.out.println(akes.pop());

	//...

    }//end main

}//end class
