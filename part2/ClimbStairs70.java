package part2;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs70 {

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}

	//递归，效率低下
//	public static int climbStairs(int n) 
//	{
//        if(n==1 || n==2)//刚好爬完
//        {
//        	return n;
//        }
//        
//        //继续爬
//        int ways=0;//它及以后的分支所产生的方法数
//        ways+=(climbStairs(n-1)+climbStairs(n-2));
//        
//        return ways;
//    }
	
	public static int climbStairs(int n) 
	{
        Map<Integer,Integer> result=new HashMap<>();
        result.put(1, 1);
        result.put(2, 2);
        
        for(int i=3;i<=n;i++)
        {
        	result.put(i, result.get(i-1)+result.get(i-2));
        }
        
        return result.get(n);
    }
}
