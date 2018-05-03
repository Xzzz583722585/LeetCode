package part2;

public class SearchIndex35 {

	public static void main(String[] args) {
		int[] nums={1,3,5,6};
		System.out.println(searchInsert(nums,5));
	}

	public static int searchInsert(int[] nums, int target) {
        //默认数组有序，不重复
		int index=0;
		while(index<nums.length && nums[index]<target)
		{
			index++;
		}
		
		return index;
    }
}
