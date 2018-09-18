import java.util.Arrays;

public class Anagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
            char[] c1 = a.toCharArray();
            char[] c2 = b.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String s1 =String.copyValueOf(c1);
        String s2 =String.copyValueOf(c2);

        if(s1.equals(s2)){
            return 0;
        }

        int len1 = c1.length;
        int len2 = c2.length;

        String toCheck = len1 > len2 ? s2:s1;
        String toEval = len1 > len2 ? s1:s2;
        int min = 0;
        while(toCheck.length() > 0){
            int index = toEval.indexOf(toCheck.charAt(0));
            if(index == -1){
                toCheck = toCheck.substring(1);
                min++;
            }
            else{
                min = index == 0 ? min : min + index ;
                toEval = toEval.substring(index+1);
                toCheck = toCheck.substring(1);
            }
        }
         return min + toEval.length();
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("abc","cde"));
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym","jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
