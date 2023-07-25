/*
// 1152-단어의 개수

// 구현 방법
공백도 한 번에 입력받기 위해 getline() 함수 사용
바로 앞이 char가 아니었을 때 char를 만나게 되면 개수 1 추가
맨 앞, 맨 뒤에도 공백이 올 수 있음을 조심할 것

// 변수 설명
isChar	: 문자를 만나면 true, 공백을 만나면 false로 바뀜

*/

#include <iostream>

using namespace std;

int main(void) {
    //input
    string sentence;
    getline(cin, sentence);

    //process
    int result = 0;
    bool isChar = false;
    for (int i = 0; i < (int)sentence.length(); i++) {
        if (sentence[i] != ' ') {
            if (isChar == false) {
                isChar = true;
                result++;
            }
        }
        else if (isChar == true) isChar = false;
    }

    //output
    cout << result << endl;
    return 0;
}


/*

// 제출 결과
구현 시간 - 20분
1번째 시도 - 틀렸습니다. 마지막 출력때 디버깅용 출력을 넣어놔서 틀림. 형변환 빼먹은 부분 warning 떠서 수정함
2번째 시도 - 맞았습니다. 채점 시간 0.5초.

// test case
The Curious Case of Benjamin Button
 The first character is a blank
The last character is a blank 
 The  last  character  is  a  blank 



// test case 정답
6
6 (맨 앞에 공백 있음)
6 (맨 뒤에 공백 있음)
6 (맨 앞, 맨 뒤에 공백 있고, 연속 공백 있음)

*/

