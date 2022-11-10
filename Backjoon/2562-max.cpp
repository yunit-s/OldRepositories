/*
// 2562-최댓값

// 구현 방법
1회 탐색. 최댓값 max, 그 인덱스 iMax

// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int max = 0, iMax, input;
    for (int i = 0; i < 9; i++) {
        cin >> input;
        if (input > max) {
            max = input;
            iMax = i + 1;
        }
    }

    //process

    //output
    cout << max << "\n" << iMax << "\n";

    return 0;
}


/*

// 제출 결과
구현 시간 - 5분
1번째 시도 - 맞았습니다! 채점 시간 0.1초

// test case
3 29 38 12 57 74 40 85 61

// test case 정답
85 8

*/
