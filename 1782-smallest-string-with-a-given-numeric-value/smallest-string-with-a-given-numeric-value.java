class Solution {
    public String getSmallestString(int n, int k) {
        char[] res=new char[n];
        for(int i=0; i<n; i++) {
            res[i]='a';
        }
        k=k-n;
        int idx=n-1;
        while(k>0) {
            int add=Math.min(25, k);
            res[idx]=(char)(res[idx]+add);
            k-=add;
            idx--;
        }
        return new String(res);
    }
}