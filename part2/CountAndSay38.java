package part2;

public class CountAndSay38 {

	public static void main(String[] args) {
		System.out.println(countAndSay(2));
	}

	public static String countAndSay(int n) {
		String num="1";
		for(int i=1;i<n;i++)
		{
			num=getString(num);
		}
        return num;
    }
	
	public static String getString(String number)
	{
		char[] cs=number.toCharArray();
		String result="";
		
		int index=0;//遍历下标
		while(index<cs.length)
		{
			char num=cs[index];//此次数字
			int time=1;//此次数字个数
			
			while(index+1<cs.length && cs[index+1]==num)
			{
				time++;
				index++;
			}
			
			result=result+time+num;
			index++;
		}
		
		return result;
	}
}
