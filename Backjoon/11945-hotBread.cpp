/*
// 11945-뜨거운 붕어빵

// 구현 방법


// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int n, m;
    cin >> n >> m;

    //process
    string bread;
    for (int i = 0; i < n; i++) {
        cin >> bread;
        for (int j = 0; j < m; j++) {
            cout << bread.at(m-j-1);
        }
        cout << endl;
    }

    //output
    return 0;
}


/*

// 제출 결과
구현 시간 - 20분
1번째 시도 - 채점 0.3초. 맞았습니다.

// test case
3 5
11110
12345
98765

// test case 정답
01111
54321
56789

*/
