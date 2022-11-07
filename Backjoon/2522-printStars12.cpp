/*
// 2522-별 찍기 12

// 구현 방법


// 변수 설명
a_A	: 테
b_B	: 스
c_C	: 트

*/

#include <iostream>

using namespace std;

int main(void) {
    int N = 0;
    cin >> N;
    for (int i = 1; i < N + 1; i++) {
        for (int j = 0; j < N - i; j++) cout << " ";
        for (int j = 0; j < i; j++) cout << "*";
        cout << endl;
    }
    for (int i = N - 1; i > 0; i--) {
        for (int j = 0; j < N - i; j++) cout << " ";
        for (int j = 0; j < i; j++) cout << "*";
        cout << endl;
    }

    return 0;
}


/*

// 제출 결과
구현 시간 - 10분?
1번째 시도 - 맞았습니다.

// test case


// test case 정답


*/

