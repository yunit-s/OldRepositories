/*
// 10952-A+B - 5

// 구현 방법
10951 코드 가져와서 조금 수정

// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int a, b;
    while(1) {
        cin >> a >> b;
        if (a == 0 && b == 0) break;
        cout << a + b << "\n";
    }

    //process

    //output

    return 0;
}


/*

// 제출 결과
구현 시간 - 5분
1번째 시도 - 맞았습니다! 채점 시간 1초

// test case
1 1
2 3
3 4
9 8
5 2
0 0

// test case 정답
2
5
7
17
7

*/
