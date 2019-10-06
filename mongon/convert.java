public class convert{
   public static void main(String args[]){
       String testStr = "•¶Œ¾‚P[~~]F•¶Œ¾‚Q[||]F•¶Œ¾‚RF[--]";
       System.out.println(testStr);
       System.out.println(restoreChars(testStr));

       testStr = "~~~|||~~~|||---~~~|||---~~~~~~|||---~~~|||---|||------";
       System.out.println(testStr);
       System.out.println(restoreChars(testStr));
   }

   public static String restoreChars(String str){
        int pos = -1;
        
        if (str == null ){
           return "";
        }
        
        for (int i=0; i < str.length(); i++){
           pos = str.indexOf("~~");
           if (pos != -1){
               str = str.substring(0,pos) + "`" + str.substring(pos + 2, str.length());
           }
        }
        
        for (int i=0; i < str.length(); i++){
           pos = str.indexOf("||");
           if (pos != -1){
               str = str.substring(0,pos) + "a" + str.substring(pos + 2, str.length());
           }
        }
        
        for (int i=0; i < str.length(); i++){
           pos = str.indexOf("--");
           if (pos != -1){
               str = str.substring(0,pos) + "|" + str.substring(pos + 2, str.length());
           }
        }
        
        return str;
    }
}