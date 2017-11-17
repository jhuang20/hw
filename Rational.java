public class Rational {
    private int p;//numerator
    private int q;//denominator
    public Rational() {//default constructor
         p=0;
	q=1;
    }
    public Rational(int a, int b) {//if given two params use this constructor
	//first number is numerator, second is demominator
         p=a;
	 q=b;
	
    }
    public String toString() {
	return p+"/"+q;//"p/q"
    }
    public double floatValue(Rational a) {//takes an instance of class Rational as input
	
	double x=p*1.0/q;//returns a double approximation of p/q
	return x;
    }
    public void multiply(Rational a) {//takes another instance of class Rational as input...
	p *= a.p;//sets the current instance of Rational's numerator to the product of the numerator and the other instance of Rational's numerator
	q *= a.q;//ditto for the denominator
    }
    public void divide(Rational a) {//ditto except its division!
	p /= a.p;
    q /= a.q;
    }
    public static void main(String[] args) {
	Rational r=new Rational(2,3);//initializes new Rational
	Rational s=new Rational(1,2);
        System.out.println(s.floatValue(s));//takes the floatValue of Rational s in instance s
	r.multiply(s);
	System.out.println(r);//2/6
	System.out.println(s);//1/2(unchanged)
	r.divide(s);
	System.out.println(r);//2/3
	System.out.println(s);//1/2(unchanged)
	
    }
}
