public class CodingBat {
    public int fibonacci(int n) {
	if(n==0) 
	    return 0;
	else if(n==1)
	    return 1;
	else {
	    return fibonacci(n-1)+fibonacci(n-2);
	}
    }
    public int bunnyEars2(int n) {
	int ret=0;
	if(n==1) {
	    return 2;
	}
	if (n==0) {
	    return 0;
	}
	if (n%2==0) 
	    ret+=3;
	if(n%2==1)
	    ret+=2;
	ret+=bunnyEars2(n-1);
	return ret;
    }
    public int triangle(int n) {
	int ret=0;
	if(n==0)
	    return 0;
	if(n==1)
	    return 1;
	ret+=n+triangle(n-1);
	return ret;
    }
    public int sumDigits(int n) {
	int ret=0;
  
	if (n<10)
	    return n;
	else {
	    ret+=sumDigits(n%10)+sumDigits(n/10);
	}
	return ret;
    }
    public int count7(int n) {
  	int ret=0;
	if(n==7) 
	    return 1;
	else if (n<10)
	    return 0;
	else {
	    ret+=count7(n%10)+count7(n/10);
	}
	return ret;
    
    }
    public int count8(int n) {//how does this work
  	int ret=0;
	if(n%10==8 && (n/10)%10==8) {
	    
	    ret+= 1;
	}
	else if(n==8) {
	    return 1;
	}
	else if (n<10){
	    return 0;
	}
	
	ret+=count8(n%10)+count8(n/10);
	
	return ret;
    }
    public int powerN(int base, int n) {
	if(n==1)
	    return base;
	else 
	    return base*powerN(base,n-1);
    }
    public int countX(String str) {
	if(str.equals("x") && str.length()==1) {
	    return 1;
	}
	else if(str.length()=<1){
	    return 0;
	}
	else {
	    return countX(0,str.substring(n/2))+countX(str.substring(n/2,str.length()));
	}
    }
    public int countHi(String str) {
	int ret=0;
	if(str.length()<2) {
	    ret+=0;
	}
  
	else {
	    if(str.substring(str.length()-2,str.length()).equals("hi")) 
		ret+=1;
	    ret+=countHi(str.substring(0,str.length()-1));
    
	}
	return ret;
  
    }
    public String changePi(String str) {
	if(str.length()<2) {
	    return str;
	}
	if(str.substring(str.length()-2,str.length()).equals("pi"))
	    return changePi(str.substring(0,str.length()-2))+"3.14";
	else 
	    return changePi(str.substring(0,str.length()-1))+str.substring(str.length()-1);
  

    }
    public String changeXY(String str) {
	if(str.equals("x") && str.length()==1) {
	    return "y";
	}
	else if(str.length()<=1){
	    return str;
	}
	else {
	    return changeXY(str.substring(0,str.length()/2))+changeXY(str.substring(str.length()/2,str.length()));
	}
    }
    public boolean array6(int[] nums, int index) {
	boolean ret=false;
	if(index>=nums.length) {
	    return false;
	}
	else if(nums[index]==6){
	    return true;
    
	}
	else {
	    ret=array6(nums, index+1);
	}
	return ret;
    }
    public int array11(int[] nums, int index) {
	int ret=0;
	if(index>=nums.length) {
	    ret=0;
	}
	else if(nums[index]==11){
	    ret+= 1;
	    ret+=array11(nums,index+1);
	}
	else {
	    ret+=array11(nums, index+1);
	}
	return ret;
    }
    public boolean array220(int[] nums, int index) {
	boolean ret=false;
	if(index>nums.length-2) 
	    return ret;
  
	else {
	    if(nums[index]*10==nums[index+1]) {
		return true;
	    }
	    ret=array220(nums,index+1);
    
	}
	return ret;

    }

    public String allStar(String str) {
	int n=str.length();
	if(str.length()==0) {
    
	    return str;
	}
	else if(str.length()==1) {
    
	    return str;
	}
	else {
	    return allStar(str.substring(0,n/2))+"*"+allStar(str.substring(n/2,str.length()));
	}
    }
    public String pairStar(String str) {
	int n=str.length();
	if(str.length()==0) {
    
	    return str;
	}
	else if(str.length()==1) {
    
	    return str;
	}
	else {
	    if (str.substring(n/2-1,n/2).equals(str.substring(n/2,n/2+1))) 
		return pairStar(str.substring(0,n/2))+"*"+pairStar(str.substring(n/2,str.length()));
	    else
		return pairStar(str.substring(0,n/2))+""+pairStar(str.substring(n/2,str.length()));
	}
    }

public int countAbc(String str) {
  int ret=0;
  if (str.length()<3) {
    return 0;
  }
  else if(str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba")) {
    ret+=1;
  }
  ret+=countAbc(str.substring(1));
  return ret;
}

public int count11(String str) {
  int ret=0;
  if (str.length()<2) {
    return 0;
  }
  else if(str.substring(0,2).equals("11")) {
    ret+=count11(str.substring(2));
    ret+=1;
  }
  /*if (str.length()>3 && str.substring(1,3).equals("11")) 
    ret+=count11(str.substring(2));*/
  else 
    ret+=count11(str.substring(1));
  return ret;
}
    public String endX(String str) {
  //base case
  if(str.length()<1) {
    return str;
  }
  
  else if(str.substring(0,1).equals("x")) {
    //str+=endX(str.substring(1));
    return endX(str.substring(1))+"x";
  }
  else {
    return str.substring(0,1)+endX(str.substring(1));
  }
}
    public int countPairs(String str) {
  if(str.length()<3) {
    return 0;
  }
  else if(str.substring(0,1).equals(str.substring(2,3))) {
    return 1+countPairs(str.substring(1));
  }
  else {
    return countPairs(str.substring(1));
  }
}

    public static void main(String[] args) {
	CodingBat test=new CodingBat();
	System.out.println("fibonaci"+test.fibonacci(8));//21
	System.out.println("bunny ears mod:"+test.bunnyEars2(10));//25
	System.out.println("traignle:"+test.triangle(0));//0
	System.out.println("triangle"+test.triangle(2));//3
	System.out.println("sumdigits"+test.sumDigits(126));//9
	System.out.println("count7:"+test.count7(717));
	System.out.println("countx"+test.countX("xxx"));
	
        
	
    }
}
