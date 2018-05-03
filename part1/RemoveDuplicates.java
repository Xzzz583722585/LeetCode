package part1;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums={1,1};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if(nums.length==0)//空数组
		{
			return 0;
		}
		
		int nowNum=nums[0];
		int targetIndex=1;
		int srcIndex=1;
		while(targetIndex<nums.length && srcIndex<nums.length)
		{
			//寻找重复元素下标
			while(srcIndex<nums.length && nums[srcIndex]==nowNum)
			{
				srcIndex++;
			}
			
			if(srcIndex<nums.length)
			{
				nowNum=nums[targetIndex++]=nums[srcIndex++];
			}
		}
		
		//缩容
		nums=Arrays.copyOf(nums, targetIndex);

        return targetIndex;
    }
}
