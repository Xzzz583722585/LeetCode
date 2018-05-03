package part1;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"aa","a"}));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0)//无比较数
		{
			return "";
		}
		
		String result=strs[0];
		for(int i=1;i<strs.length;i++)
		{
			String target=strs[i];//本次比较的目标
			int j=0;
			int shortLength=result.length()<target.length()?result.length():target.length();
			while(j<shortLength && result.charAt(j)==target.charAt(j))
			{
				j++;
			}
			result=result.substring(0, j);
		}
		
        return result;
	}
}
