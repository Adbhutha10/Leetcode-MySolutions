import java.util.Arrays;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
        int a = gap(h);
        int b = gap(v);
        int s = Math.min(a, b);
        return s * s;
    }
    private int gap(int[] arr) {
        Arrays.sort(arr);
        int max = 1, cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max + 1;
    }
}
