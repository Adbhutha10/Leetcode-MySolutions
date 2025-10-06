class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = 0;
            char c = s.charAt(i);

            switch (c) {
                case 'I': value = 1; break;
                case 'V': value = 5; break;
                case 'X': value = 10; break;
                case 'L': value = 50; break;
                case 'C': value = 100; break;
                case 'D': value = 500; break;
                case 'M': value = 1000; break;
            }

            // If a smaller value appears before a larger one, subtract it
            if (value < prev)
                total -= value;
            else
                total += value;

            prev = value; // update previous value
        }

        return total;
    }
}
