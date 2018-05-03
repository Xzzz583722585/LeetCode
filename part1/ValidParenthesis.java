package part1;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(isValid("{[]"));
	}

	public static boolean isValid(String s) {
		char[] cs=s.toCharArray();
		Deque<Character> slist=new LinkedList<Character>();//栈
		
		for(int i=0;i<cs.length;i++)
		{
			if(slist.peek()!=null)
			{
				char c1=slist.peek();
				char c2=cs[i];
				if(isPair(c1,c2))//配对成功，弹栈消除
				{
					slist.pop();
					continue;
				}
			}
			slist.push(cs[i]);
		}
		
        return slist.isEmpty();
    }
	
	public static boolean isPair(char c1,char c2) {
		if('('==c1)
		{
			return ')'==c2;
		}
		else if('['==c1)
		{
			return ']'==c2;
		}
		else//{
		{
			return '}'==c2;
		}
	}
}
