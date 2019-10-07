
public class Main {

	public static void main(String[] args) {
//		String s = "abcdcba"; // return 7
		
//		String s = "abacde"; // return 3

		String s = "abccba"; // return 6
				
		System.out.println(new Solution().solution(s));
	}

}

class Solution {
	public int solution(String s) {
		int len = s.length();
		
		if (len == 0)
			return 0;
		
		while (len > 0) {
			for (int i = 0; i < s.length() - len + 1; i++) {
				String substring = s.substring(i, i + len);
				String reversedString = new StringBuilder(substring).reverse().toString();
				if (substring.equals(reversedString))
					return len;
			}
			len--;
		}
		
		return -1;
	}
}