class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // simply increment and return if not 9
                return digits;
            }
            digits[i] = 0; // if 9, set to 0 and carry over
        }

        // if all digits were 9 (e.g., [9,9,9]), we need a bigger array
        int[] result = new int[n + 1];
        result[0] = 1; // the rest are 0 by default
        return result;
    }
}
