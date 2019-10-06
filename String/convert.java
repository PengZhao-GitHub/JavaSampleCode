
public class convert{
   public static void main(String[] args){
        if (args.length!=1){
             System.out.println("Please input a string");
             return;
        }
        
        System.out.println(con(args[0]));
   }

   public static String con(String str){
         StringBuffer s = new StringBuffer(str);
         s.reverse();
         
         String tmpStr = codeFormat_4_4_2xxx_xx(new String(s));
         
         StringBuffer s1 = new StringBuffer(tmpStr);
         s1.reverse();
         
         return s1.toString(); 
  }

   public static String codeFormat_4_4_2xxx_xx(String str){
         StringBuffer res = new StringBuffer();
    
         if(str.length() < 10) {
                    return str;
         }
         
         if(str.length() > 4) {
             res.append(str.substring(0,4));
             res.append('-');
             str = str.substring(4,str.length());
         }
         
         
         if(str.length() > 4) {
             res.append(str.substring(0,4));
             res.append('-');
             str = str.substring(4,str.length());
         }
         
         
         if (str.length() <= 4){
             res.append(str.substring(0,str.length()));
         } else {
             res.append(str.substring(0,4));
             res.append('-');
             res.append(str.substring(4,str.length()));
             
         }
         
         return res.toString();
    
    }
}