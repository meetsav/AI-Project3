import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class BasePair {

    public String baseString=new String();
    public ArrayList<Integer> visited;

    int count=0;

    public ArrayList<Integer> iterationIndex=new ArrayList<>();
    public BasePair(String str)
    {
        baseString=str;
    }
    public int getCount()
    {
        //this is method dows not use any algoritham, its like bruteforce
        visited=new ArrayList<>();

            for (int i = 0; i < baseString.length(); i++) {

                if (!visited.contains(i)) {

                    char ch1 = baseString.charAt(i);

                        for (int j = i + 1; j < baseString.length(); j++) {

                            if (ch1 == 'U') {
                                if (baseString.charAt(j) == 'A' || baseString.charAt(j) == 'G') {
                                    if (j - i >= 4 && !visited.contains(j)) {
                                        visited.add(j);
                                        visited.add(i);

                                        count++;
                                      //    System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                        break;

                                    }
                                }

                            }
                            else if (ch1 == 'G') {
                                if (baseString.charAt(j) == 'U' || baseString.charAt(j) == 'C') {
                                    if (j - i >= 4 && !visited.contains(j)) {
                                        visited.add(j);
                                        visited.add(i);

                                        count++;
                                        // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                        break;

                                    }
                                }

                            }
                            else if (ch1 == 'C') {
                                if (baseString.charAt(j) == 'G') {
                                    if (j - i >= 4 && !visited.contains(j)) {
                                        visited.add(j);
                                        visited.add(i);


                                        count++;
                                        // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                        break;

                                    }
                                }

                            }
                            else if (ch1 == 'A') {
                                if (baseString.charAt(j) == 'U') {
                                    if (j - i >= 4 && !visited.contains(j)) {
                                        visited.add(j);
                                        visited.add(i);


                                        count++;
                                      //   System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                        break;

                                    }
                                }

                            }


                        }
                }
        }
        return count ;
    }
    public int getRandomStart()
    {
      //this is random restart algoritham which rearrange the indexes which can be traverse and increase the number of count
      //  iterationIndex=new ArrayList<>();
        getIndexes();

        visited=new ArrayList<>();

       // count=0;
      //  System.out.println(in);
      //  System.out.println(iterationIndex);
        for (int i = 0; i < iterationIndex.size(); i++) {

            if (!visited.contains(iterationIndex.get(i))) {

                char ch1 = baseString.charAt(iterationIndex.get(i));

                for (int j = i + 1; j < iterationIndex.size(); j++) {

                    if (ch1 == 'U') {
                        if (baseString.charAt(iterationIndex.get(j)) == 'A' || baseString.charAt(iterationIndex.get(j)) == 'G') {
                            if (iterationIndex.get(j) - iterationIndex.get(i) >= 4 && !visited.contains(iterationIndex.get(j))) {
                                visited.add(iterationIndex.get(j));
                                visited.add(iterationIndex.get(i));
                               // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                count++;

                                break;

                            }
                        }

                    }
                    else if (ch1 == 'G') {
                        if (baseString.charAt(iterationIndex.get(j)) == 'C' || baseString.charAt(iterationIndex.get(j)) == 'U') {
                            if (iterationIndex.get(j) - iterationIndex.get(i) >= 4 && !visited.contains(iterationIndex.get(j))) {
                                visited.add(iterationIndex.get(j));
                                visited.add(iterationIndex.get(i));

                                count++;
                            //    System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);


                                break;

                            }
                        }

                    }
                    else if (ch1 == 'C') {
                        if (baseString.charAt(iterationIndex.get(j)) == 'G') {
                            if (iterationIndex.get(j) - iterationIndex.get(i) >= 4 && !visited.contains(iterationIndex.get(j))) {
                                visited.add(iterationIndex.get(j));
                                visited.add(iterationIndex.get(i));

                                count++;
                               // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                break;

                            }
                        }

                    }
                    else if (ch1 == 'A') {
                        if (baseString.charAt(iterationIndex.get(j)) == 'U') {
                            if (iterationIndex.get(j) - iterationIndex.get(i) >= 4 && !visited.contains(iterationIndex.get(j))) {
                                visited.add(iterationIndex.get(j));
                                visited.add(iterationIndex.get(i));

                                count++;
                                //  System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
                                break;

                            }
                        }

                    }

                }
            }
        }
        iterationIndex.removeAll(iterationIndex);

        return count;

    }
    public int runThisFUnction()
    {
        //this is the main function which is responsible for getting the output
        long start=System.currentTimeMillis();
       // System.out.println(start);
        double k;
        int max=0;
        int time=1;
       /*  max = getCount();
        count=0;
        int j = getRandomStart();
        System.out.println("--------------------"+j+"------------------------  "+max);

        if(j>=max)
        {

            return j;
        }
        return max;*/

        max = getCount();
        count=0;
//loop will run for maximum 1 minute if number of input is small then it will run several time until it gets output
        while(true) {
            k=setTimer(time);
            count=0;
            if(k<=0)
            {
                return max;
            }

            if((((System.currentTimeMillis()-start)*0.001)/60)>=0.99)
            {
              //  System.out.println(((System.currentTimeMillis()-start)*0.001)/60);
                return max;
            }
            else {
               // System.out.println("--------------------------------------------  "+max);

                int j = getRandomStart();

                //System.out.println(j);
              //  System.out.println("***********************"+max+"*********************  "+j);
                if (j >= max) {
                    max = j;
                }
            }
            time++;

        }

    }

    private double setTimer(int time) {

        return(1.0-(0.000002*time));
    }


    public void getIndexes()
    {
       /* for(int i=temp;i<baseString.length();i++)
        {
            iterationIndex.add(i);
        }
        for(int i=temp-1;i>=0;i--)
        {
            iterationIndex.add(i);
        }*/


        int length=baseString.length();
        int m=length;
        while(m!=0){
            int randPicker = (int)(Math.random()*length);
            if(!iterationIndex.contains(randPicker)) {
               // System.out.println(randPicker);
                iterationIndex.add(randPicker);
                m--;
               // output.append(characters.remove(randPicker));
            }

        }








    }

}
