/*
// 1008-A/B

// 구현 방법
문법 - 유효 소숫점자릿수 확보하기
cout.precision() 멤버함수 활용

// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int a, b;
    cin >> a >> b;

    //process
    cout.precision(15);

    //output
    cout << (double)a/b << endl;
    return 0;
}


/*

// 제출 결과
구현 시간 - 20분
1번째 시도 - 맞았습니다. 채점 시간 1.5초

// test case
100 133

// test case 정답
0.75187969924812026...

*/
