# Programmers.Level3_Java_TheLongestPalindrome

## 프로그래머스 > 코딩테스트 연습 > 가장 긴 팰린드롬

### 1. 문제설명

문제: https://programmers.co.kr/learn/courses/30/lessons/12904

input으로 `String s`가 들어온다. 문자열 s의 부분 문자열 중 가장 긴 팰린드롬의 길이를 return하는 문제

* 팰린드롬은 앞뒤를 뒤집어도 똑같은 문자열을 말한다.

### 2. 풀이

문자열의 길이를 받아와 `len`에 저장한 후, 문자열 `s`에서 길이 `len`의 부분 문자열을 가져온다. 이 부분문자열을 뒤집은 문자열과 가져온 부분문자열이 같다면 팰린드롬을 만족하므로 부분문자열의 길이인 `len`을 return한다. 모든 길이가 `len` 인 부분 문자열을 검사 하였으나 팰린드롬을 만족하지 않는다면 `len--`후 다시 위 과정을 반복한다. `len==0`일때는 input의 길이가 `0`인 경우이므로 `0`을 return 해주었다.

```java
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
```

### 3. 문제점

정확성 테스트는 모두 통과하였지만 효율성 테스트 1번과 2번중 1번에서 시간 초과가 일어났다. 이 문제는 아직 해결하지 못하여서 질문하기에도 어떠한 문제인지 물어보았다. 느낌상 `reversedString`을 구하는 과정에서 새로운 `StringBuilder`인스턴스를 계속 생성하는것이 이유인것 같은데 다른 방법을 더 생각해보아야 겠다.
