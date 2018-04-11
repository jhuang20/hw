//james huang
//2018-4-10
//hw31-Stack What is it good for (; ; ) {
//apcs pd 01 brown

}
/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
    String ret="";
    int p=s.length();
    Latkes lis=new Latkes(p);
    for(int i=0; i<p; i++) {
      lis.push(s.substring(i,i+1));
    }
    for(int j=0; j<p; j++) {
      ret+=lis.pop();
    }
    return ret;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static String tempOpposite(String s) {
    if(s.equals(")")) {
      return "(";
    }
    else if(s.equals("]")) {
      return "[";
    }
    else {
      return "{";
    }
  }
  public static boolean allMatched( String s )
  {
    boolean yes=true;
    int p=s.length();
    Latkes lis=new Latkes(p);
    for(int i=0; i<p; i++) {
      //checks for stray beginning, end
      String checker=s.substring(i,i+1);
      if(i==0 && (checker.equals(")") || checker.equals("]") || checker.equals("}"))) {
        return false;
      }
      else if(i==p-1&& (checker.equals("(") || checker.equals("[") || checker.equals("{"))) {
        return false;
      }
      lis.push(s.substring(i,i+1));
    }

    //this deals with the middle section of the string, and checks to see if the pair in the center works out!
      String temp=lis.pop();
      String character=lis.peekTop();
      //System.out.println(temp);
      //System.out.println(character+"\n");
      while(!(character.equals(tempOpposite(temp)))) {
        if(lis.peekTop()==null) {
          yes=false;
          break;
        }
        temp=lis.pop();
        if(lis.peekTop()==null) {
          yes=false;
          break;
        }
        character=lis.peekTop();
        //System.out.println(temp);
        //System.out.println(character+"\n");
        //System.out.println(tempOpposite(temp)+"\n");



      }

    return yes;
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {

    System.out.println(flip("stressed"));
    System.out.println(flip("pantomine"));

    System.out.println(allMatched( "({}[()])" )); //true

    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
