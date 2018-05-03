package part1;

public class ReverseInt {

	public static void main(String[] args) {
		System.out.println(reverse(-1230));
	}

	public static int reverse(int x) {
		String num=""+x;
		boolean isNeg=(num.charAt(0)=='-');//是否为负数
		StringBuilder numb=new StringBuilder(num.replaceAll("-", ""));
		numb=numb.reverse();
		num=isNeg?"-"+numb.toString():numb.toString();
		
        try{
        	return Integer.parseInt(num);
        }catch(Exception e){
        	return 0;
        }
    }
}
