class cmdline{
   public static void main(String args[]) {
	for(int i=0; i< args.length; i++)
	{
	   System.out.println(args[i]);
	   try {
	   	System.out.println(Integer.parseInt(args[i]));
	   } catch (NumberFormatException e) {
		System.out.println("Invalid format");
	   }	
	}
   }
}