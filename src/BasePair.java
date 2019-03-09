public class BasePair {

    public String baseString=new String();
    public String basepair1="AU";
    public String basepair2="CG";
    public String basepair3="GU";
    public int count=0;

    public BasePair(String str)
    {
        baseString=str;
       System.out.println(baseString);
    }
    public int getCount()
    {
        for(int i=0;i<baseString.length()-3;i++)
        {
            char ch1=baseString.charAt(i);
            char ch2=' ';

            if(ch1=='A' || ch1=='C' || ch1=='G')
            {
                if (ch1 == 'A')
                {
                    ch2 = 'U';
                }
                if (ch1 == 'C')
                {
                    ch2 = 'G';
                }
                if (ch1 == 'G')
                {
                    ch2 = 'U';
                }
                for (int j = i + 1; j < baseString.length(); j++) {
                    if (baseString.charAt(j) == ch2) {
                        if (j - i >= 4) {
                            count++;
                        }
                    }
                }
            }
            else
            {
                continue;
            }
        }


        return count;
    }

}
