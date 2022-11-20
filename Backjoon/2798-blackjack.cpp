/*
// 2798-블랙잭

// 구현 방법
경우의 수 적으니까 그냥 완전탐색.

// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int n, target, num[100];
    cin >> n >> target;
    for (int i = 0; i < n; i++)
        cin >> num[i];

    //process
    int sum, max = 0;
    for (int i = 0; i < n - 2; i++) {
        for (int j = i + 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                sum = num[i] + num[j] + num[k];
                if (sum > max && sum <= target) max = sum;
            }
        }
    }
    
    //output
    cout << max << "\n";

    return 0;
}


/*

// 제출 결과
구현 시간 - 20분
1번째 시도 - 맞았습니다!

// test case
10 500 93 181 245 214 315 36 185 138 216 295

// test case 정답
497

*/
