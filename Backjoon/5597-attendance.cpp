/*
// 5597-과제 안 내신 분...?

// 구현 방법


// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int student[30] = { 0, };
    int input;
    for (int i = 0; i < 28; i++) {
        cin >> input;
        student[input - 1] = 1;
    }

    //process

    //output
    for (int i = 0; i < 30; i++) {
        if (student[i] == 0) cout << i + 1 << "\n";
    }

    return 0;
}


/*

// 제출 결과
구현 시간 - 5분
1번째 시도 - 맞았습니다! 채점 시간 0.5초

// test case


// test case 정답


*/
