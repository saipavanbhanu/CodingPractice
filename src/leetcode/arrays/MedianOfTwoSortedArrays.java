package leetcode.arrays;


//https://www.youtube.com/watch?v=yD7wV8SyPrc&ab_channel=KeertiPurswani

public class MedianOfTwoSortedArrays {
	
	//using binary search approach
	//TC O(log(min(len1,len2)));
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        if(nums1.length > nums2.length){
	            int temp[] = nums1;
	            nums1 = nums2;
	            nums2 = temp;
	        }
	        
	        int len1 = nums1.length;
	        int len2 = nums2.length;
	        int cut1 = len1/2;
	        int cut2 = (len1+len2)/2 - cut1;
	            
	        int l = 0, h = len1;
	        while(l <= h){
	            cut1 = ( l + h )/2;
	            cut2 = (len1 + len2)/2 - cut1;
	            int l1 = ( cut1 == 0 ) ? Integer.MIN_VALUE : nums1[cut1-1];
	            //System.out.println(cut1+" "+cut2);
	            int l2 = ( cut2 == 0 ) ? Integer.MIN_VALUE : nums2[cut2-1];
	            int r1 = ( cut1 == len1 ) ? Integer.MAX_VALUE : nums1[cut1];
	            int r2 = ( cut2 == len2 ) ? Integer.MAX_VALUE : nums2[cut2];
	            if( l1 > r2 ){
	                h = cut1 - 1;
	            }else if( l2 > r1 ){
	                l = cut1 + 1;
	            }else{
	                if ( (len1 + len2)%2 == 0 ){
	                    return ( Math.max((double)l1, (double)l2) + Math.min((double)r1, (double)r2) )/2;
	                }else{
	                    return Math.min(r1, r2);
	                }
	            }
	        }
	        return -1;
	    }
	}
	
	
	//using merge method of merge sort
	class Solution2 {
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
