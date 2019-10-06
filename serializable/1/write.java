import java.io.*;
import java.util.*;
import java.awt.*;

public class write{
	public static void main(String args[]){
		try {
			FileOutputStream f = new FileOutputStream("tmp");
			ObjectOutputStream s = new ObjectOutputStream(f);
			s.writeObject("Today");
			s.writeObject(new Date());
			s.flush();
		} catch (Exception e){

		}
	}
}