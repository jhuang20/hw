//james huang
//apcs pd01
//2017-12-06
//hw48-Keep Guessing
/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int user;//instance var for recursive version of game
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo=1;//default upper and lower bounds
	_hi=100;
	_guessCtr=1;
	_target=(int)(Math.random()*100)+1;
	
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  guess must be in range, otherwise the game will be futile.
      post: you win the game!
      ==================================================*/
    public void playIter() 
    {
	int user=0;//set user input as 0
	System.out.println("welcome to the guessing game! here You will guess a number between 1 and 100!GUESS AWAY!");//intro message
	
	
	while(user!=_target) {//while the user guess isnt correct
	    
	    System.out.println("guess a number between "+_lo+" and "+_hi);//guess a number between upper and lower bounds
	    user=Keyboard.readInt();//user input
	    _guessCtr+=1;//add one to the guess counter
	    if (user<_target) {//if the user guess is less than targer
		_lo=user+1;//set low value to 1 larger than guess
	    }
	    if (user>_target) {
		_hi=user-1;//
	    }
	}
	
	System.out.print("you won in "+(_guessCtr-1)+" tries");//you won in x number of tries
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
        
	if (_guessCtr==1)//on first guess, introduce the rules of the game
	    System.out.println("welcome to the guessing game! here You will guess a number between 1 and 100!GUESS AWAY!");
	if(user!=_target) {//if the user guess is not equal to the actual number
	    System.out.println("guess a number between "+_lo+" and "+_hi);
	    user=Keyboard.readInt();
	    _guessCtr+=1;
	    if (user<_target) {
		_lo=user+1;
	    }
	    if (user>_target) {
		_hi=user-1;
	    }
	    playRec();//run it again
	}
	else {//if the guess=target
	    System.out.print("you won in "+(_guessCtr-1)+" tries");//show that user won and in how many tries 
	}
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 

	playRec();//play the game!
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	//*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class
