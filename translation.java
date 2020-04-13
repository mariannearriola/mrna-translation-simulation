import java.util.Scanner;
import java.util.ArrayList;

class translate {
    boolean stopCodonPresent = false;
    int count = 0;

    public static String findStartCodon(String mRNA)
    {
        //finding the start codon
        for(int i = 0; i < mRNA.length(); i++)
        {
            if(i < mRNA.length() - 3)
            {
                if(mRNA.charAt(i) == 'A' && mRNA.charAt(i+1) == 'U' && mRNA.charAt(i+2) == 'G')
                {
                    //removing the poly g cap and the start codon
                    mRNA = mRNA.substring(i+3);
                    return mRNA;
                }
            }
        }
        return mRNA;
    }
    public static String findStopCodon(String mRNA)
    {
        //finding the stop codon
        for(int i = mRNA.length()-1; i > 3; i--)
        {
            if(mRNA.charAt(i-2) == 'U' && ((mRNA.charAt(i-1) == 'A' && mRNA.charAt(i) == 'A')  || (mRNA.charAt(i-1) == 'A' && mRNA.charAt(i) == 'G') || (mRNA.charAt(i-1) == 'G' && mRNA.charAt(i) == 'A')))
            {
                //removing the poly a cap and the stop codon
                mRNA = mRNA.substring(0, i-2);
                return mRNA;
            }
        }
        return mRNA;
    }
    private static int countAminoAcids(String mRNA)
    {
        int count = 0;
        for(int i = 0; i < mRNA.length(); i++)
        {
            count++;
        }
        return count;
    }
    private static String findAminoAcids(String mRNA, int count)    
    {
        ArrayList<String> aminoAcids = new ArrayList<String>();
        for(int i = 0; i < count; i+=3)
        {
                //beginning with u + a
                if(mRNA.charAt(i) == 'U' && mRNA.charAt(i+1) == 'A')
                {
                    if(mRNA.charAt(i+2) == 'U' || mRNA.charAt(i+2) == 'C')
                    {
                        aminoAcids.add("Tyrosine");   
                    }
                }
                //beginning with u + g
                if(mRNA.charAt(i) == 'U' && mRNA.charAt(i+1) == 'G')
                {
                    if(mRNA.charAt(i+2) == 'G')
                    {
                        aminoAcids.add("Tryptophan");
                    }
                    else
                    {
                        aminoAcids.add("Cysteine");
                    }
                }
                //beginning with u + c
                if(mRNA.charAt(i) == 'U' && mRNA.charAt(i+1) == 'C')
                {
                    aminoAcids.add("Serine");
                }
                //beginning with u + u
                if(mRNA.charAt(i) == 'U' && mRNA.charAt(i+1) == 'U')
                {
                    if(mRNA.charAt(i+2) == 'U' || mRNA.charAt(i+2) == 'C')
                    {
                        aminoAcids.add("Phenylalanine");
                    }
                    else
                    {
                        aminoAcids.add("Leucine");
                    }
                }
                //beginning with g + a
                if(mRNA.charAt(i) == 'G' && mRNA.charAt(i+1) == 'A')
                {
                    if(mRNA.charAt(i+2) == 'U' || mRNA.charAt(i+2) == 'C')
                    {
                        aminoAcids.add("Aspartate");
                    }
                    else
                    {
                        aminoAcids.add("Lysine");
                    }
                }
                //beginning with g + g
                if(mRNA.charAt(i) == 'G' && mRNA.charAt(i+1) == 'G')
                {
                    aminoAcids.add("Glysine");
                }
                //beginning with g + c
                if(mRNA.charAt(i) == 'G' && mRNA.charAt(i+1) == 'C')
                {
                    aminoAcids.add("Alanine");
                }
                //beginning with g + u
                if(mRNA.charAt(i) == 'G' && mRNA.charAt(i+1) == 'U')
                {
                    aminoAcids.add("Valine");
                }
                //beginning with a + a
                if(mRNA.charAt(i) == 'A' && mRNA.charAt(i+1) == 'A')
                {
                    if(mRNA.charAt(i+2) == 'U' || mRNA.charAt(i+2) == 'C')
                    {
                        aminoAcids.add("Asparagine");
                    }
                    else
                    {
                        aminoAcids.add("Lysine");
                    }
                }
                //beginning with a + g
                if(mRNA.charAt(i) == 'A' && mRNA.charAt(i+1) == 'G')
                {
                    if(mRNA.charAt(i+2) == 'U' || mRNA.charAt(i+2) == 'C')
                    {
                        aminoAcids.add("Serine");
                    }
                    else
                    {
                        aminoAcids.add("Arginine");
                    }
                }
                //beginning with a + c
                if(mRNA.charAt(i) == 'A' && mRNA.charAt(i+1) == 'C')
                {
                    aminoAcids.add("Threonine");
                }
                //beginning with a + u
                if(mRNA.charAt(i) == 'A' && mRNA.charAt(i+1) == 'U')
                {
                    if(mRNA.charAt(i+2) == 'G')
                    {
                        aminoAcids.add("Methionine");
                    }
                    else
                    {
                        aminoAcids.add("Isoleucine");
                    }
                }
                //beginning with c + a
                if(mRNA.charAt(i) == 'C' && mRNA.charAt(i+1) == 'A')
                 {
                    if(mRNA.charAt(i+2) == 'U' || mRNA.charAt(i+2) == 'C')
                    {
                        aminoAcids.add("Histidine");
                    }
                    else
                    {
                        aminoAcids.add("Glutamine");
                    }
                 }
                //beginning with c + g
                if(mRNA.charAt(i) == 'C' && mRNA.charAt(i+1) == 'G')
                {
                    aminoAcids.add("Arginine");
                }
                //beginning with c + c
                if(mRNA.charAt(i) == 'C' && mRNA.charAt(i+1) == 'C')
                {
                    aminoAcids.add("Proline");
                }
                //beginning with c + u
                if(mRNA.charAt(i) == 'C' && mRNA.charAt(i+1) == 'U')
                {
                    aminoAcids.add("Leucine");
                }
            }  
            String result = "";
            if(aminoAcids.size()==0)
            {
               return "Does not exist.";
            }
            else 
            {
                if(aminoAcids.size()==1) 
                {
                    result += "The produced amino acid is: ";
                }
                else
                {
                    result += "The produced amino acids are: ";
                }
                for (int i = 0; i < aminoAcids.size()-1; i++)
                {
                    if(aminoAcids.size() == 2)
                    {
                        result += aminoAcids.get(i) + " ";
                    }
                    else
                    {
                        result += aminoAcids.get(i) + ", ";
                    }
                }
                if(aminoAcids.size() > 1)
                {
                    result += "and ";
                }
                result += aminoAcids.get(aminoAcids.size()-1) + ".";
            }
            return result;
        }
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Enter an mRNA strand with any number of codons (in capital letters).\nInclude the poly G cap and the poly A tail.\nThere must be an appropriate start and stop codon.\n");
        String input = getInput.nextLine();
        //running the methods
        if(findStartCodon(input).compareTo(input) !=  0)
        {
            String newInput = findStartCodon(input);
            if(findStopCodon(newInput).compareTo(newInput) !=  0)
            {
                newInput = findStopCodon(newInput);
                int count = countAminoAcids(newInput);
                ArrayList<String> aminoAcids = new ArrayList<String>();
                System.out.println(findAminoAcids(newInput, count));
            }
        }
        
    }
}