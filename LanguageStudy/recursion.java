class n {
  int nn(int n) {
      int result;
      if (n==0)
	 result=1;
      else
	 result=nn(n-1)*n;
      
      return result;   
   }
}

class recursion {
   public static void main(String args[]) {
	n f = new n();
	
	int i ;
	
	for (i=0; i<= (args[0]).toInt(); i++)	
	     System.out.println(i+ " is " + f.nn(i));
   }
} 
