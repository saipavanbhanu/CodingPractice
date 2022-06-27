package leetcode.arrays;

public class MedianOfTwoSortedArrays {
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int len1 = nums1.length;
	        int len2 = nums2.length;
	        int totalLength = len1 + len2;
	        boolean evenFlag = false;
	        if( totalLength % 2 == 0){
	            //even case average of middle 2 nos
	            evenFlag = true;
	            
	        }else{
	            //middle of the entire merged array
	            evenFlag = false;
	        }
	        int medianIndex = totalLength / 2;
	        if(evenFlag){
	            medianIndex--;
	        }
	        
	        int count = 0;
	        int whichArray = -1;
	        //kind of popping from the merging of two sorted arrays.
	        int index1 = 0, index2 = 0;
	        while( ( index1 < len1 || index2 < len2) && count <= medianIndex ){
	            if(index1 < len1 && index2 < len2 ){
	                if(nums1[index1] < nums2[index2]){
	                    index1++;
	                    whichArray = 1;
	                }else{
	                    index2++;
	                    whichArray = 2;
	                }

	            }else if(index1 < len1){
	                index1++;
	                whichArray = 1;
	            }else{
	                index2++;
	                whichArray = 2;
	            }
	            count++;
	        }
	        
	        if(evenFlag){
	            double firstValue =  (whichArray == 1) ? nums1[index1-1] : nums2[index2-1];
	            double secondValue = -1;
	            if(index1 < len1 && index2 < len2){
	               if(nums1[index1] < nums2[index2]){
	                    secondValue = nums1[index1];
	                }else{
	                    secondValue = nums2[index2];
	               }
	            }else if(index1 < len1){
	                secondValue = nums1[index1];
	            }else{
	                secondValue = nums2[index2];
	            }
	            
	            return (firstValue + secondValue )/2;
	        }else{
	            return (whichArray == 1) ? nums1[index1-1] : nums2[index2-1];
	        }
	        
	        
	        
	    }
	    
	   
	    
	    
	    
	}
}
