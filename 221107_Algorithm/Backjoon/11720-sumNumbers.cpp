/*
// 11720-숫자의 합

// 구현 방법
atoi() 쓰려고 했는데 안 되네...? (atoi() 쓸 때는 stdlib.h 추가해야함.)

// 변수 설명
a_A	: 테
b_B	: 스
c_C	: 트

*/

#include <iostream>

using namespace std;

int main(void) {
    int N;
    cin >> N;
    string num;
    cin >> num;

    // N 대신 num.length() 써도 됨
    int result = 0;
    for (int i = 0; i < N; i++) result += num[i] - '0';
    cout << result << endl;

    return 0;
}


/*

// 제출 결과
구현 시간 - 30분?
1번째 시도 - 맞았습니다.

// test case
1
8
100
1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890

// test case 정답
8
450

*/

