//james huang
//hw07-- a man a plan a canal-panama!
//2018-02-13
//brown apcs pd01

public class RevString {
  //string creator
    public static final String ALPHABET="abcdefghijklmnopqrstuvwxyz";
    public static String makeString(int length) {
	String str="";
	for(int i=0; i<length; i++) {
	    int randLetter=(int)(Math.random()*26);
	    str=str+ALPHABET.substring(randLetter,randLetter+1);

	}
	return str;
    }//end makeString
    /***
    revStringR takes a string, and reverses the position of all the letters. Using recursion,
    we can achieve an O(logn) runtime.
    The algorithm works by splitting the string into halves until a string of length 1 is made. A
    string of length 1 reversed is the same. This 1 length string then combines with the letter it was
    split up with, and that 2 letter string is reversed because I added the one that was formerly "after"
    it first. Thus, the 2 letter string is reversed, and is combined with the adjacent 2 letter string to form
    a 4 letter reversed string. This eventually gives us our O(logn) <ceiling function>. No comparisons are needed,
    so there is no additional impediment to runtime(unlike mergeSort)
    */
    public String revStringR(String n) {//O(logn) runtime
	if(n.length()==1) {
    return n;
	}
	else {
	    return revStringR(n.substring(n.length()/2,n.length()))+revStringR(n.substring(0,n.length()/2));
	}
}//end revStringR()
/***
revString is the standard reverse function of runtime O(n). We create a new string and go through the string from back to front,
filling the new string up in the process.
*/
    public String revString(String n) {//O(logn)
      String ret="";
      int len=n.length();
      for(int i=0; i<n.length(); i++) {
        ret+=n.substring((len-1)-i, len-i);
      }
      return ret;
    }//end revString()
    public static void main(String[] args) {
      String p=makeString(10);
      System.out.println("initial string:"+p);
      RevString r=new RevString();
      System.out.println("reversed string with O(n) runtime: "+r.revString(p));
      System.out.println("reversed string with O(logn) runtime: "+r.revStringR(p));
    }
}
