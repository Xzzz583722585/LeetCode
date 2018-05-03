package part2;

import java.math.BigInteger;

public class Sqrt69 {

	public static void main(String[] args) {
		System.out.println(mySqrt(1));
	}

	public static int mySqrt(int x) {
		if(x==1)
		{
			return 1;
		}
		
		double result=x/2;
		double before;
		do
		{
			before=result;
			result=(result+x/result)/2;
		}while(Math.abs(result-before)>0.00001);
		return (int)result;
    }
}
