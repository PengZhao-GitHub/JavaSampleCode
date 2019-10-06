package fileio;

import java.io.*;
import java.util.Vector;
/**
 * タイトル:  File IO study
 * 説明:
 * 著作権:   Copyright (c) 2002
 * 会社名:   Cool Family
 * @author
 * @version 1.0
 */

public class pspakszj00_001 {
  private static pspakszj00_001 comm = new pspakszj00_001();

  public pspakszj00_001() {
  }

  public static pspakszj00_001 ksz_Get_Instance(){
          return comm;
  }

  public int ksz_Send_Request(String cDiverge_Flg,
				String cProgram_ID,
				String cTelegram_ID,
				Vector cIn_Data,
				StringBuffer cOut_Data)
  {
          String reqFile = "d:" + File.separator + "req" + File.separator  + cTelegram_ID;
          String ansFile = "d:" + File.separator + "ans" + File.separator  + cTelegram_ID;
          FileWriter out = null;
          FileReader in = null;
          char[] buffer = new char[2048];
          int i=0;
          int c;

          //通信電文を書く
          try{
                File outputFile = new File(reqFile);
                out = new FileWriter(outputFile);
                for (i=0; i < cIn_Data.size(); i++){
                  out.write((String)cIn_Data.elementAt(i));
                }
                out.close();
          } catch(java.io.IOException ex){
                System.out.println(ex);
                return -1;
          }

          //応答電文を読む
          try{
                i = 0;
                File inputFile = new File(ansFile);
                in = new FileReader(inputFile);
                while((c=in.read())!= -1){
                     buffer[i++] = (char)c;
                }
                String str = String.valueOf(buffer,0,i);
                in.close();
                //応答電文復帰する
                cOut_Data.append(str);
          } catch(java.io.IOException ex){
                System.out.println(ex);
                return -1;
          }

          return 0;
  }
}