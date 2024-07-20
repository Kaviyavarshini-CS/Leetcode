class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int s1=nums1.length;
        int s2=nums2.length;
        int TotSize=s1+s2;
        double med=0;
        int[] Result=new int[TotSize];
        int i;
        for(i=0;i<s1;i++)
        {
            Result[i]=nums1[i];
        }
        for (i = 0; i < s2; i++)
        {
            Result[s1 + i] = nums2[i];
        }
        Arrays.sort(Result);
        int n=TotSize/2;
        if(TotSize%2==0)
        {
            med=(Result[n]+Result[n-1])/2.0;
        }
        else
        {
            med=Result[n];
        }
        return med;
    }
}