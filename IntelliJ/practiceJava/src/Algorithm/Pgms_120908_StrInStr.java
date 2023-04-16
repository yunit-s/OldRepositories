/*
// 120908-문자열안에 문자열
// 구현 방법
3중 for문...?

 */

package Algorithm;

import java.util.Scanner;

class Solution120908 {

    public int solution(String str1, String str2) {
        int answer = 0;
        
        if (str1.indexOf(str2) != -1)
            answer = 1;
        else
            answer = 2;
        
        return answer;
    }
}

public class Pgms_120908_StrInStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		String str1, str2;
		str1 = sc.next();
		str2 = sc.next();
		
		// process
		Solution120908 s = new Solution120908();
		s.solution(str1, str2);

	}
}

/*

//제출 결과
구현 시간 - 20분
1번째 시도 - 맞았습니다!

//test case

//test case 정답

*/
