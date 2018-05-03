package part2;

public class IndexOf28 {

	public static void main(String[] args) {
		System.out.println(strStr("a",""));
	}

	public static int strStr(String haystack, String needle) {
		char[] hs=haystack.toCharArray();
		char[] ns=needle.toCharArray();
		int i=0;//haystack下标
		int j=0;//needle下标
		
		while(i<=hs.length && j<=ns.length)
		{
			int init=i;//记录起始位置
			
			while(i<hs.length && j<ns.length && hs[i]==ns[j])//匹配
			{
				i++;
				j++;
			}
			
			if(i-j<=hs.length-ns.length && j==ns.length)//匹配成功
			{
				return i-j;
			}
			else//匹配失败
			{
				i=init+1;
				j=0;
			}
		}

        return -1;
    }
}
