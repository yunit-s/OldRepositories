/*
// 10995-별 찍기 20

// 구현 방법


// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int n;
    cin >> n;

    //process

    //output
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if ((i + 1) % 2 == 0) cout << " *";
            else cout << "* ";
        }
        cout << endl;
    }

    return 0;
}


/*

// 제출 결과
구현 시간 - 10분
1번째 시도 - 채점 2초. 맞았습니다.

// test case


// test case 정답


*/
