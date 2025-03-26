import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        if(L == null || L.isEmpty()){
            return 0;
        }

        int sum = 0;
        for (Integer i : L) {
            sum += i;
        }

        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> ans = new ArrayList<>();

        for (Integer i : L) {
            if(i % 2 == 0){
                ans.add(i);
            }
        }

        return ans;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> ans = new ArrayList<>();

        for (Integer i : L1) {
            for (Integer integer : L2) {
                if(Objects.equals(i, integer)){
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int ans = 0;

        for (String word : words) {
            char []chars = word.toCharArray();
            for (char aChar : chars) {
                if(aChar == c){
                    ans++;
                }
            }
        }

        return ans;
    }
}
