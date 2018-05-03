package part2;

import java.util.Arrays;

public class PlusOne66 {

	public static void main(String[] args) {
		int[] digits={9};
		for(int i:plusOne(digits))
		{
			System.out.print(i);
		}
	}

	public static int[] plusOne(int[] digits) {
		boolean flag=true;//继续循环标志
		int index=digits.length-1;//操作下标
        do
        {
        	//进位到需要扩容
        	if(index<0)
        	{
        		digits=Arrays.copyOf(digits, digits.length+1);
        		System.arraycopy(digits, 0, digits, 1, digits.length-1);
        		digits[0]=0;
        		index=0;
        	}
        	
        	digits[index]+=1;
        	if(digits[index]>9)//进位
        	{
        		digits[index]=0;
        		index--;
        	}
        	else//不进位，操作结束
        	{
        		flag=false;
        	}
        }while(flag);
		
		return digits;
    }
}
