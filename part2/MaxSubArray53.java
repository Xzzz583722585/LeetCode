package part2;

public class MaxSubArray53 {

	public static void main(String[] args) {
		int[] nums={-3,-2,0,-1};
		System.out.println(maxSubArray(nums));
		
	}

	public static int maxSubArray(int[] nums) {
		int max=nums[0];//记录真正最大值
		int temp=0;//当前和>=0就保留，因为他对后面促进作用
		  				//当前和<0就删除，因为他对后面抑制作用
		for(int i=0;i<nums.length;i++)
		{
			temp+=nums[i];
			if(temp>max)
			{
				max=temp;
			}
			else if(temp<0)
			{
				temp=0;
			}
		}
		
		return max;
    }
}
