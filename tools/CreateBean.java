import java.util.Vector;
import java.io.*;
import java.util.*;

public class CreateBean{

    public static void main(String args[]){
           
          if (args.length != 2){
              System.out.println("usage: java CreateBean inputFilePath outputFilePath");
              return;
          }

          String inputFileName = args[0];
          String outputFileName = args[1];
                   
          try{
          		//Input Stream
                FileInputStream inputFile = new FileInputStream(inputFileName);
                LineNumberReader in = new LineNumberReader(new InputStreamReader(inputFile,"SJIS"));
                
                //Output Stream
                FileOutputStream outputFile = new FileOutputStream(outputFileName, true);
                OutputStreamWriter out = new OutputStreamWriter(outputFile,"SJIS");

                String item; 
                while((item=in.readLine())!= null){
                     
                     //Get
                     out.write("    public String get" + item.substring(0,1).toUpperCase() + item.substring(1,item.length()) + "(){");
                     out.write("\n");
                     out.write("        return " + item + ";");
                     out.write("\n");
                     out.write("    }");
                     out.write("\n");
                     
                     //Set
                     out.write("    public void set"   + item.substring(0,1).toUpperCase() + item.substring(1,item.length()) + "(String str){");
                     out.write("\n");
                     out.write("        " + item + "= str;");
                     out.write("\n");
                     out.write("    }");
                     out.write("\n");
                     out.write("\n");
                }

                in.close();
                out.close();
                
                System.out.println("データベーン関数を作成しました。");
          } catch(java.io.IOException ex){
                System.out.println(ex);
          }
    }
}