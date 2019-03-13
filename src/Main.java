import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

         ArrayList<String> sample;
         String initial=new String();
         File fl;
         Scanner out;
     //   System.out.println(System.currentTimeMillis());
         for(int i=1;i<=10;i++) {
             fl = new File(i+".txt");
             out = new Scanner(fl);
             initial=out.nextLine();
            // System.out.println(initial);
             BasePair bp=new BasePair(initial);
           //  System.out.println(bp.getCount());
             System.out.println( bp.runThisFUnction());


         }
      //  System.out.println(System.currentTimeMillis());












    }
}
