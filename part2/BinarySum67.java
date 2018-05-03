package part2;

import java.util.Arrays;

public class BinarySum67 {

	public static void main(String[] args) {
		int[] num1={1};
		int[] num2={0};
		System.out.println(addBinary("11","1"));
	}
	
	public static String addBinary(String a, String b) 
	{
		boolean isALong=a.length()>b.length();//a是不是较长的数
        int gap=isALong?a.length()-b.length():b.length()-a.length();//相差位数，高位补0
        
        String str="";
        for(int i=0;i<gap;i++)
        {
        	str+="0";
        }
        
        if(isALong)
    	{
        	b=str+b;
    	}
        else
        {
        	a=str+a;
        }
        System.out.println(a);
        System.out.println(b);
        
        return binarySum(a,b);
    }
	

	public static String binarySum(String num1,String num2)
	{
		StringBuilder result=new StringBuilder();
				
		int carry=0;//进位
		for(int i=num1.length()-1;i>=0;i--)
		{
			int a=new Integer(num1.substring(i, i+1));
			int b=new Integer(num2.substring(i, i+1));
			int add=a+b+carry;
			if(add>1)//产生进位
			{
				result.insert(0, add-2);
				carry=1;
			}
			else//无进位
			{
				result.insert(0, add);
				carry=0;
			}
		}
		
		if(carry==1)//仍有进位，扩容
		{
			result.insert(0, 1);
		}
		
		return result.toString();
	}
}
