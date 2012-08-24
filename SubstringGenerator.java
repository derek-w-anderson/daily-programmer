import java.util.*;

/**
 * Challenge #82 (Easy) - http://www.reddit.com/r/dailyprogrammer/comments/x8rl8/7272012_challenge_82_easy_substring_list/
 */
public class SubstringGenerator
{
    public Set<String> getSubstrings(int n) {
        char[] c = new char[n];
        for (int i = 0; i < n; i++) c[i] = (char) ('a' + i);
        return getSubstrings(c);
    }

    public Set<String> getSubstrings(String s) {
        return getSubstrings(s.toCharArray());
    }

    private Set<String> getSubstrings(char[] c) {
        Set<String> set = new LinkedHashSet<String>();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < (c.length - i); j++) {
                StringBuilder s = new StringBuilder();
                for (int k = i; k <= (i + j) && k < c.length; k++) {
                    s.append(c[k]);
                }
                set.add(s.toString());
            }
        }
        return set;
    }

    public int numSubstrings(int nChars) {
        return (nChars == 1) ? 1 : nChars + numSubstrings(nChars - 1);
    }

    public static void main(String[] args) {
        SubstringGenerator sg = new SubstringGenerator();
        System.out.println(sg.getSubstrings(5));
        System.out.println(sg.numSubstrings(6)); // Bonus 1
        System.out.println(sg.getSubstrings("hello")); // Bonus 2
    }
}
