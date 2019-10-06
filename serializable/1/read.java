import java.io.*;
import java.util.*;
import java.awt.*;

public class read{
	public static void main(String args[]){
		try {
			FileInputStream in = new FileInputStream("tmp");
			ObjectInputStream s = new ObjectInputStream(in);
			String today = (String)s.readObject();
			Date date = (Date)s.readObject();
			
			System.out.println(today);
			System.out.println(date);

		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
}