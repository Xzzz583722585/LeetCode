package part1;

public class twoSum {

	public static void main(String[] args) {
		int[] r=twoSum(new int[]{-3,4,3,90},0);
		System.out.println(r[0]+" "+r[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=0;//最终返回的下标
        
        end:
        for(i=0;i<nums.length;i++)
        {
            for(j=0;j<nums.length;j++)
            {
                if(i!=j && nums[i]+nums[j]==target)//找到
                {
                	System.out.println(i+" "+j+" "+nums[i]+" "+nums[j]);
                    break end;
                }
            }
        }

        return new int[]{i,j};
    }
}
