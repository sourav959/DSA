class Solution{
    static int heapHeight(int N, int arr[]){
        // code here
        int sum=0,count=0,mul=1;
        
        while(sum<N){
            sum+=mul;
            mul*=2;
            count++;
        }
        return count-1;
    }
}