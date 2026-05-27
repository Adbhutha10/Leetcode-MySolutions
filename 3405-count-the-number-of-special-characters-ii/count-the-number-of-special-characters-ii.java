import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        int[] ll = new int[26];
        int[] fu = new int[26];
        Arrays.fill(ll, -1);
        Arrays.fill(fu, -1);
        Set<Integer> invalid = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                ll[idx] = i;
                if (fu[idx] != -1) {
                    invalid.add(idx);
                }
            } else {
                int idx = ch - 'A';
                if (fu[idx] == -1) {
                    fu[idx] = i;
                }
            }
        }
        int sc = 0;
        for (int i = 0; i < 26; i++) {
            if (ll[i] != -1 &&
                fu[i] != -1 &&
                !invalid.contains(i)) {
                sc++;
            }
        }
        return sc;
    }
}