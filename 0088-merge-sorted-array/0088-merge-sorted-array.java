class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
        //nums1.length > nums2.length
        //push num1 elements to the end of the array;
        int j = m-1;
        int i, count = 0;
        for( i = num1.length-1; j >= 0; i--){
            num1[i] = num1[j];
            j--;
            count++;
        }
        
        //System.out.println(Arrays.toString(num1));
        
        i = num1.length - m;
        int k = 0;
        j = 0;
        while( i < num1.length && j < n && count != 0 ){
            if(num1[i] < num2[j]){
                num1[k++] = num1[i++];
            }else{
                num1[k++] = num2[j++];
            }
            //System.out.println(num1[--k]);
        }
        
        while(i < num1.length && count != 0 ){
            num1[k++] = num1[i++];
        }
        
        while(j < n){
            num1[k++] = num2[j++];
        }
        
    }
}