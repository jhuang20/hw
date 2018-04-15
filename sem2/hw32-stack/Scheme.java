/*****************************************************
james Huang
hw33
2018-4-12
apcs brown pd01
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. Talk to Rubber Duck
 *   3. Set up two stacks, one is the MAIN stack, the other is the SIDE stack.
 *   4. Iterate through the string, pushing each element
 into the MAIN stack, until reaching the END parenthesis.
      a. If there is another open parenthesis, remove that segment from the string, evaluate it, then replace the expression with its result
      b. work outwards from there

 *
 * STACK OF CHOICE: ALStack by ME
 * b/c i honestly think i couldve used LList for better results, and perhaps my subtraction wouldve worked!
 ******************************************************/

public class Scheme
{
  /******************************************************
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr )
  {
    String[] p=expr.split("\\s+");//splits, removes those gosh darn annoying spaces!
    Stack<String> main=new ALStack<String>();
    Stack<String> side=new ALStack<String>();
    String ret="";//return value
    for(int i=0; i<p.length; i++) {

      main.push(p[i]);//pushes to main stack
      if (main.peek().equals("(")) {
        i++;
        int cu=0;
        //System.out.println(main.peek());
        //System.out.println(i);
        //begin opteratio
        if(p[i].equals("+")) {
          cu=1;
        }
        else if(p[i].equals("-")) {
            cu=2;
          }
        else {
            cu=3;
          }
        i++;
        while(!p[i].equals(")")) {
          if (p[i].equals("(")) {//if theres another parenthesis)

            String sub="";
            while(!p[i].equals(")")) {
              sub+=p[i]+" ";
              i++;
            }
            sub+=p[i];
            //System.out.println(sub);
            //System.out.println(evaluate(sub));

            side.push(evaluate(sub));//evaluate the substring of number
            System.out.println(evaluate(sub));
            //break;//this magical line will allow for 3 nested parens maybe even 4, but it screws over 2 parens
          }
          //System.out.println(p[i]);
          if (!p[i].equals(")")) {//we already dealt with the parenthesis, so now we can IGNORE THEM
            side.push(p[i]);//keep on pushing
          }
          i++;
        }
        ret=unload(cu, side);
      }

    }
    return ret;
  }//end evaluate()


  /******************************************************
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
    int ret=Integer.parseInt(numbers.pop());
    if (op==1) {
    while (!numbers.isEmpty()) {
    ret+=Integer.parseInt(numbers.pop());
  }

  }
  else if (op==2) {
  while(!numbers.isEmpty()) {
    ret+=Integer.parseInt(numbers.peek());
    System.out.println(ret);
    String p=numbers.peek();
    //System.out.println(numbers.peek().equals(p));
    if(!numbers.pop().equals(null)) {
      ret-=Integer.parseInt(p);
      System.out.println(ret);
      numbers.push(p);
      break;
    }

  }
System.out.println(ret);
  ret=Integer.parseInt(numbers.pop())-ret;
}
else {
while (!numbers.isEmpty()) {
ret*=Integer.parseInt(numbers.pop());
}
}
return ret+"";
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29
//cant fiture out this one!
      String zoo4 = "( + 3 ( * 4 ( + 3 ( - 12 4  ) ) ) )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...12 72 78
      /*^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
