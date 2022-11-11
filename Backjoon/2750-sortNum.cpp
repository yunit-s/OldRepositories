/*
// 2750-수 정렬하기

// 구현 방법
표본이 작아서 알고리즘 연습하기 좋은 문제.
병합 정렬. 이해한 걸 바탕으로 내 마음대로 짜보기. 제출한 다음 다시 보니 불필요한 코드들이 좀 있어서 수정함.

// 변수 설명


*/

#include <iostream>

using namespace std;

void merge(int num[], int iFirst, int iCen, int iLast) {
    int iL = iFirst, iR = iCen + 1, iCur = 0;
    int numTemp[iLast - iFirst];
    while(iCur <= iLast - iFirst) {
        // 왼쪽에서 숫자를 가져와야 하는 경우
        if (iR > iLast || (iL <= iCen && num[iL] <= num[iR])) numTemp[iCur++] = num[iL++];
        // 오른쪽에서 숫자를 가져와야 하는 경우
        else numTemp[iCur++] = num[iR++];
    }
    // 임시로 정렬된 배열 저장하기
    for (int i = 0; i < iLast - iFirst + 1; i++)
        num[iFirst + i] = numTemp[i];
}

void mergeSort(int num[], int iFirst, int iLast) {
    if (iFirst < iLast) {
        int iCen = (iFirst + iLast) / 2;
        mergeSort(num, iFirst, iCen);
        mergeSort(num, iCen + 1, iLast);
        merge(num, iFirst, iCen, iLast);
    }
}

int main(void) {
    //input
    int N, num[1001] = { 0, };
    cin >> N;
    for (int i = 0; i < N; i++) cin >> num[i];

    //process
    mergeSort(num, 0, N - 1);

    //output
    for (int i = 0; i < N; i++) cout << num[i] << "\n";

    return 0;
}


/*

// 제출 결과
구현 시간 - 1번째 시도 1시간 30분
1번째 시도 - 맞았습니다! 채점 시간 5초.

// test case
1 4
2 4 2
2 2 4
5 5 2 3 4 1
13 38 14 72 91 31 78 51 11 64 27 85 50 42

// test case 정답
4
2 4
2 4
1 2 3 4 5
11 14 27 31 38 42 50 51 64 72 78 85 91

*/
