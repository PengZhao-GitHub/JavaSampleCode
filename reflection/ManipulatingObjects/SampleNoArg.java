import java.lang.reflect.*;
import java.awt.*;

class SampleNoArg {

   public static void main(String[] args) {

      for (int i=0; i<args.length; i++)
		System.out.println(args[i]);

      Object o = createObject(args[0]);
      Class  c = o.getClass();

      System.out.println(o.getClass().getName());
   }

   static Object createObject(String className) {
      Object object = null;
      try {
          Class classDefinition = Class.forName(className);
          object = classDefinition.newInstance();
      } catch (InstantiationException e) {
          System.out.println(e);
      } catch (IllegalAccessException e) {
          System.out.println(e);
      } catch (ClassNotFoundException e) {
          System.out.println(e);
      }
      return object;
   }
}
