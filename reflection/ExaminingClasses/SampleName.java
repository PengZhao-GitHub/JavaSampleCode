import java.lang.reflect.*;
import java.awt.*;

class SampleName {

	public static void main(String[] args) {
		Button b = new Button();
		printName(b);
		
		Object o = new Object();
		printName(o);
	}

	static void printName(Object o) {
		Class c = o.getClass();
		String str = c.getName();
		System.out.println(str);
		
		Class s = c.getSuperclass();
		str = s.getName();
		System.out.println(str);

	}
}