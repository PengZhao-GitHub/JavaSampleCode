import java.util.*;

public class time{
	public static void main(String args[]){
		Calendar c = Calendar.getInstance();
		long time1 = System.currentTimeMillis();
		long time2 = new Date().getTime();
		//long time3 = c.getTimeInMillis();
		System.out.println(time1);
		System.out.println(time2);
		//System.out.println(time3);
	}
}