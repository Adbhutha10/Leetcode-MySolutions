import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        int maxWater=0;
        int lp=0, rp=height.length-1;
        while(lp<rp) {
            int h=Math.min(height[lp], height[rp]);
            int w=rp-lp;
            int cw = h*w;
            maxWater = Math.max(maxWater, cw);
            if(height[lp] < height[rp]) 
                lp++;
            else
                rp--;
        }
        return maxWater;
    }
}