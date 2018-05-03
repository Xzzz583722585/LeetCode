package part1;

import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums={};
		System.out.println(removeElement(nums,1));
	}

	public static int removeElement(int[] nums, int val) {
		int head=0,tail=nums.length-1;//从头尾同时开始扫描数组
		
		while(head<=tail)
		{
			while(head<=tail && nums[head]!=val)//找到待替换val的位置
			{
				head++;
			}
			while(head<=tail && nums[tail]==val)//找到可替换val的位置
			{
				tail--;
			}
			
			if(head<=tail)
			{
				nums[head++]=nums[tail--];//替换
			}
			else
			{
				break;
			}
		}
		
		nums=Arrays.copyOf(nums, head);//缩容
		
        return nums.length;
    }
}
