class Solution {

public boolean checkInclusion(String s1, String s2) {

    int[] freq1 = new int[26];  // frequency of s1
    int[] freq2 = new int[26];  // frequency of current window in s2

    int n = s1.length();
    int m = s2.length();

    // If s1 longer than s2 → impossible
    if (n > m) return false;

    // Build frequency array for s1
    for (int i = 0; i < n; i++) {
        freq1[s1.charAt(i) - 'a']++;
    }

    int left = 0;

    // Slide window over s2
    for (int right = 0; right < m; right++) {

        // Add current character to window
        freq2[s2.charAt(right) - 'a']++;

        // If window exceeds size n,
        // remove leftmost character
        if (right - left + 1 > n) {
            freq2[s2.charAt(left) - 'a']--;
            left++;
        }

        // If window size equals n,
        // compare frequency arrays
        if (right - left + 1 == n &&
            Arrays.equals(freq1, freq2)) {

            return true;
        }
    }

    return false;
}
}