import java.lang.reflect.*;
import java.awt.*;

public class SampleField {

   public static void main(String[] args) {
      GridBagConstraints g = new GridBagConstraints();
      printFieldNames(g);
      System.out.println("****************************");
      test t = new test();
      printFieldNames(t);
   }

   static void printFieldNames(Object o) {
      Class c = o.getClass();
      Field[] publicFields = c.getFields();
      for (int i = 0; i < publicFields.length; i++) {
         String fieldName = publicFields[i].getName();
         Class typeClass = publicFields[i].getType();
         String fieldType = typeClass.getName();
         System.out.println("Name: " + fieldName + 
           ", Type: " + fieldType);
      }
   }
}

class test{
	
	private int a;
	public int b;
	public void setA(int i){
		a =i;
	}
	public int getA() {
		return a;
	}
}