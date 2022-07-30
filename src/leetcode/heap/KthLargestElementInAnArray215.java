package leetcode.heap;

public class KthLargestElementInAnArray215 {
	class Solution {
	    public int findKthLargest(int[] nums, int k) {
	        
	        int pivot = -1;
	        int start = 0, end = nums.length-1;
	        do{
	            //System.out.println("start:"+start+",end:"+end);
	            pivot = partition(nums, start, end);
	            //System.out.println("pivot-value:"+nums[pivot]+"; index:"+pivot);
	            //System.out.println(Arrays.toString(nums));
	            if(pivot+1 == k){
	                return nums[pivot];
	            }else if(pivot+1 < k){
	                start = pivot + 1;
	            }else{
	                end = pivot - 1; 
	            }
	        }while(true);
	        
	    }
	    
	    int partition(int[] nums, int left, int right){
	        int i = left;
	        int pivot = right;
	        int j = right-1;
	        if(i == j){
	            if(nums[pivot] < nums[i]){
	                //do nothing;
	                return pivot;
	            }else{
	                //swap the pivot and i
	                int temp = nums[pivot];
	                nums[pivot] = nums[i];
	                nums[i] = temp;
	                return pivot;
	            }
	        }else{
	            //System.out.println("i:"+i+",j:"+j);
	            while(i < j){
	                while(i < j && nums[i] > nums[pivot]){
	                    i++;
	                }
	                while(j > 0 && j > i && nums[j] <= nums[pivot]){
	                    j--;
	                }
	                if(i < j){
	                    int temp = nums[i];
	                    nums[i] = nums[j];
	                    nums[j] = temp;
	                }
	            }
	            //System.out.println("i:"+i+",j:"+j+",pivot-value:"+nums[pivot]);
	            
	            int temp = nums[i];
	            nums[i] = nums[pivot];
	            nums[pivot] = temp;            
	            return i;    
	        }
	    }
	}
}
