package coding.leetCode.mayChalange;

public class NumberComlement {
	public static void main(String[] args) {
		int n = 5;
		while(n > 0) {
			n = n >> 1;
			System.out.println(n);
		}
	}
}
