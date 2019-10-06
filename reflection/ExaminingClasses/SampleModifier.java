import java.lang.reflect.*;
import java.awt.*;

class SampleModifier {
        private static class inner{

        }
	public static void main(String[] args) {
		//String s = new String();
		inner s = new inner();
		printName(s);
		printModifier(s);
	}
	
	public static void printModifier(Object o){
		Class c = o.getClass();
		int m = c.getModifiers();
		if(Modifier.isPublic(m))
			System.out.println("public");
		if(Modifier.isAbstract(m))
			System.out.println("abstract");
		if(Modifier.isFinal(m))
			System.out.println("final");
		if(Modifier.isPrivate(m))
                        System.out.println("private");
	}

	public static void printName(Object o){
		Class c = o.getClass();
		String str = c.getName();
		System.out.println(str);
	}
}
