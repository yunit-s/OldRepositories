/*
// 10951-A+B - 4

// 구현 방법
10950 코드에서 살짝 수정
end-of-file 무시하지 말자. cin.eof() 적합한 곳에 활용하기
cin.eof() 는 실제로 가장 최근에 실행된 cin이 eof를 받아온 다음에야 true를 반환한다.

// 변수 설명


*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    int a, b;
    while(!(cin >> a >> b).eof()) {
        cout << a + b << "\n";
    }

    //process

    //output

    return 0;
}


/*

// 제출 결과
구현 시간 - 20분
1번째 시도 - 출력 초과. 이거 무한루프 돌려야돼? 뭐지?
2번째 시도 - 틀렸습니다. 너무 쉽게 보고, 생각없이 바로 제출함. eof() 위치 제대로 쓰자.
3번째 시도 - 맞았습니다! 채점 시간 1초

// test case
1 1
2 3
3 4
9 8
5 2

// test case 정답
2
5
7
17
7

*/
