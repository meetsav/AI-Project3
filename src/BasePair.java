import java.util.ArrayList;
import java.util.Random;

public class BasePair {

    public String baseString=new String();
    public ArrayList<Integer> visited;
    public String basepair1="AU";
    public String basepair2="CG";
    public String basepair3="GU";
    public int count=0,A,G,C,U;

    public BasePair(String str)
    {
        baseString=str;
        visited=new ArrayList<>();
       //System.out.println(baseString);
       for(int i =0;i<baseString.length();i++)
       {
           if(baseString.charAt(i)=='A')
               A++;
           else if(baseString.charAt(i)=='G')
               G++;
           else if(baseString.charAt(i)=='C')
               C++;
           else if(baseString.charAt(i)=='U')
               U++;

       }
       // System.out.println(A+" "+G+" "+" "+C+" "+U);
    }
    public int getCount()
    {

            for (int i = 0; i < baseString.length(); i++) {

                if (!visited.contains(i)) {

                    char ch1 = baseString.charAt(i);
                    char ch2 = ' ';

                    {
                        if (ch1 == 'A') {
                            ch2 = 'U';
                        } else if (ch1 == 'C') {
                            ch2 = 'G';
                        }
                      /*  else if (ch1 == 'G') {
                            ch2 = 'U';
                        }
                         else if (ch1 == 'G') {
                             ch2 = 'C';
                         }*/

                        for (int j = i + 1; j < baseString.length(); j++) {

                            if (ch1 == 'U') {
                                if (baseString.charAt(j) == 'A' || baseString.charAt(j) == 'G') {
                                    if (j - i >= 4 && !visited.contains(j)) {
                                        visited.add(j);
                                        count++;
                                        //   System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                        break;

                                    }
                                }

                            }
                            if (ch1 == 'G') {
                                if (baseString.charAt(j) == 'U' || baseString.charAt(j) == 'C') {
                                    if (j - i >= 4 && !visited.contains(j)) {
                                        visited.add(j);
                                        count++;
                                        // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                        break;

                                    }
                                }

                            }
                            if (baseString.charAt(j) == ch2) {
                                if (j - i >= 4 && !visited.contains(j)) {
                                    visited.add(j);
                                    count++;
                                    // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                    break;

                                }
                            }
                        }
                    }
                }



            getRandomStart();
        }

        return count ;
    }
    public void getRandomStart()
    {
        Random rn=new Random();
        int in=rn.nextInt(baseString.length());
        int in1=rn.nextInt(baseString.length());
        String str=new String();
        if(in>in1)
        {
            str=baseString.substring(0,in1);
            str+=(baseString.substring(in1,in));
            str+=(baseString.substring(in));


            baseString=str;
        }
        else
        {
            str=(baseString.substring(0,in));
            str+=(baseString.substring(in,in1));
            str+=(baseString.substring(in1));
            baseString=str;

        }
       // System.out.println("-------------------->"+baseString);

    }

}
