import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: olivergreenwald
 * Lab Name: StringCompression
 * Lab purpose: The goal of StringCompression is to create a program that
 * Date: 10/27/17
 * Collaborators: None
 */

//s.charAt(i-1) == ' ' && s.charAt(i+1) == ' ')

public class StringCompression extends ArrayDictionary{

    public StringCompression(){

    }

    public static String disemVoweling(String s){

        String toReturn = "";
        boolean isLoner = false;

        for (int i = 0; i < s.length() - 1; i++) {

            if (i != 0 && s.charAt(i-1) == ' ' && s.charAt(i+1) == ' '){
                toReturn+=s.charAt(i);
            }

            if (!((s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
                s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'))) {

                toReturn+=s.charAt(i);


            }
        }

        return toReturn;
    }

    public static String simpleCompression(String s){

        String simplified = "";
        int num = 0;
        s+=" ";

        for (int i = 0; i < s.length()-1; i++) {

            num++;

            if (s.charAt(i) != s.charAt(i+1)){
                simplified+=s.charAt(i);
                simplified+=num;
                num = 0;
            }
        }

        return simplified;
    }

    public String dictionaryCompression(String s){

        //MAKE A LOOP SO THAT THEY CAN REENTER MORE THINGS UNTIL THEY SAY "STOP"
        String phrase;
        int num = 0;
        ArrayDictionary a = new ArrayDictionary();
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input a single word phrase to condense: ");
            phrase = scan.nextLine();


            String toReturn = "";


            a.put(num, phrase);

            String delims = "[ ]";
            String[] tokens = s.split(delims);

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals(phrase)){
                    tokens[i] = "" + num;
                }
                toReturn+=tokens[i] + " ";
            }

            num++;

            int valuesSize = 0;

            for (int i = 0; i < values().size(); i++) {
                valuesSize+=((String)values.get(i)).length();
            }

            double equation = 1.0 * (s.length() - toReturn.length() + keys().size() + valuesSize) / s.length();

            s = toReturn;

            if (!phrase.equals("STOP")){
                System.out.println(toReturn + "\n" + a.toString() + "\nCompression Rate: " + equation + "\nIf you wish to continue, enter another phrase to condense. If you would like to stop, write \"STOP\".");
            }

        } while (!phrase.equals("STOP"));

        return "Thanks!";
    }

    public static void main(String[] args) {

        StringCompression s = new StringCompression();
        System.out.println(s.disemVoweling("Pressure is a privilege"));
        System.out.println(s.simpleCompression("aaaabbbbbhhhhhttttttrrrrrr"));
        System.out.println(s.dictionaryCompression("A Peter A Picked A Pack A of A Pickled A Peppers A"));

    }

}
