/*
// 4153-직각삼각형

// 구현 방법
변의 길이 입력받고, 최댓값 찾고, 제곱해서 비교하기

// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int a, b, c;

    //process
    while(1) {
        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0) break;
        else {
            if (a > b) swap(a, b);
            if (b > c) swap(b, c);
            if (c * c == a * a + b * b) cout << "right" << "\n";
            else cout << "wrong" << "\n";
        }
    }

    //output

    return 0;
}


/*

// 제출 결과
구현 시간 - 15분
1번째 시도 - 맞았습니다! 채점 시간 0.1초

// test case
6 8 10
25 52 60
5 12 13
0 0 0

// test case 정답
right
wrong
right

*/
