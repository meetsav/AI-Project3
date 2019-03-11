import java.util.*;

public class BasePair {

    public String baseString=new String();
    public ArrayList<Integer> visited;
    public String basepair1="AU";
    public String basepair2="CG";
    public String basepair3="GU";

    int count=0;

    public ArrayList<Integer> iterationIndex=new ArrayList<>();
    public BasePair(String str)
    {
        baseString=str;
        visited=new ArrayList<>();

    }
    public int getCount()
    {

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
                                        //  System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
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
                                        // System.out.println(baseString.charAt(i) + " " + baseString.charAt(j) + " " + i + " " + j);
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
        Random rn=new Random();
        int in=rn.nextInt(baseString.length());
        getIndexes(in);
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
        iterationIndex=new ArrayList<>();
        return count;

    }
    public void runThisFUnction()
    {
        int k=100;
        if(baseString.length()<=2000)
        {
            k=50;
        }
        if(baseString.length()<=4000)
        {
            k=25;
        }
        if(baseString.length()<=8000 && baseString.length()>=6000)
        {
            k=5;
        }
        else
        {
            k=1;
        }


        int max=getCount();
        for(int i=0;i<k;i++)
        {
            int j=getRandomStart();
            if(j>max)
            {
                max=j;
            }
        }
        System.out.println(max);

    }
    public void getIndexes(int temp)
    {
        for(int i=temp;i<baseString.length();i++)
        {
            iterationIndex.add(i);
        }
        for(int i=temp-1;i>=0;i--)
        {
            iterationIndex.add(i);
        }

    }

}
