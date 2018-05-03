package part2;

public class LengthOfLastWord58 {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
	}

	public static int lengthOfLastWord(String s) {
		String[] strs=s.split(" ");
		if(strs.length==0)
		{
			return 0;
		}
        return strs[strs.length-1].length();
    }
}
