package part1;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(-101));
	}

	public static boolean isPalindrome(int x) {
		StringBuilder num=new StringBuilder(""+x);
		String reNum=num.reverse().toString();

        return reNum.equals(""+x);
    }
}
