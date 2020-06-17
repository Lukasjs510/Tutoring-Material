import java.util.*;
import java.lang.*;
public class LetterCounter{
    String[] alphabetArray;
    double totalLetters;
    double[] lCount;
    int[] hCount;
    int maxLetterIndex;
    double maxLetter; 
    double MAX_HASH = 60;

    public LetterCounter(){
        alphabetArray =  new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        lCount = new double[26];
        hCount = new int[26];
        maxLetter = -1;
    }

    public void countLetters(String text){
        int index = 0;
        text = text.toLowerCase();
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c >= 'a' && c <= 'z'){
                totalLetters++;
                index = c - 'a';
                lCount[index]++;
            }
        }
        findMax();
    }

    private void findMax(){
        maxLetter = lCount[0];
        for(int i = 1; i < 26; i++){
            if (maxLetter < lCount[i]){
                maxLetter = lCount[i];
                maxLetterIndex = i;
            }
        }
    }

    public double getTotalCount(){
        return totalLetters;
    }

    public String toString(){
        double appears = 0;
        double percent = 0;
        String statement = "Frequencies after " + totalLetters + " characters:\n";
        for (int i = 0; i < lCount.length; i++){
            appears = lCount[i];
            percent = appears / totalLetters * 100;
            statement += alphabetArray[i]+":";
            statement += hashPrint((double)lCount[i]);
            statement+= "("+percent+"%)";
            statement+= "\n";
        }
        return statement;
    }

    private String hashPrint(double freq){
        double numHash = ((MAX_HASH * freq) / maxLetter);
        String hashString = "";
        for (double i = 0; i < numHash; i++){
            hashString += "#";
        }
        return hashString;
    }

}