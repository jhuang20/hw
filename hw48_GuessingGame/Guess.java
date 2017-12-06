import cs1.Keyboard;
public class Guess {
    //instance vars
    private static int win=(int)(Math.random()*100)+1;
    private static int _lower=1;
    private static int _upper=100;
    private static int user;
    private static int user_count=1;
    public static void main(String[] args) {
	System.out.println("welcome to the guessing game! here You will guess a number between 1 and 100!GUESS AWAY!");
	System.out.println("guess a number between 1-100");
	user=Keyboard.readInt();
	user_count+=1;
	
	while(user!=win) {
	    
	    System.out.println("guess a number between "+_lower+" and "+_upper);
	    user=Keyboard.readInt();
	    user_count+=1;
	    if (user<win) {
		_lower=user+1;
	    }
	    if (user>win) {
		_upper=user+1;
	    }
	}
	
	System.out.print("you won in");
    }
}
