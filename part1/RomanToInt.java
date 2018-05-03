package part1;

public class RomanToInt {

	public static void main(String[] args) {
//		System.out.println(getInt('D'));
		System.out.println(romanToInt("IIII"));
	}

	public static int romanToInt(String s) {
		char[] cs=s.toCharArray();
		int[] nums=new int[cs.length];
		
		//得到各位代表数字
		for(int i=0;i<nums.length;i++)
		{
			nums[i]=getInt(cs[i]);
		}
		
		//计算结果
		int result=nums[nums.length-1];//从右向左计算
		int moreThree=1;//同一字母不连续超过三次，最后一个字母开始出现一次
		for(int i=nums.length-2;i>=0;i--)
		{
			int num=nums[i];
			result=(num>=nums[i+1])?result+num:result-num;
			
			if(num==nums[i+1])
			{
				moreThree++;
			}
			else
            {
                moreThree=1;
            }
			
			if(moreThree>3)
			{
				return 0;//错误，先输出0
			}
		}
		
        return result;
    }
	
	public static int getInt(char c)
	{
		switch(c)
		{
			case 'I':return 1;
			case 'V':return 5;
			case 'X':return 10;
			case 'L':return 50;
			case 'C':return 100;
			case 'D':return 500;
			case 'M':return 1000;
			default:return 0;
		}
	}
}
