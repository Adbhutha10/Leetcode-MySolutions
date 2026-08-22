class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int ds=0, dp=1;
        while(n>0) {
            int rem=n%10;
            ds+=rem;
            dp*=rem;
            n=n/10;
        }
        if(temp%(ds+dp)==0) return true;
        else return false;
    }
}