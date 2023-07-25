/*
// 24060-알고리즘 수업 - 병합 정렬 1

// 구현 방법
문제에서 주어진 의사 코드 참고하여 코드 작성.
오류 잡고, 코드 최적화하는데 시간 많이 사용함...

// 변수 설명


*/

#include <iostream>

using namespace std;

int num[500000];
int sCntTarget, sCnt, sCntNum;

void merge(int iFirst, int iCen, int iLast) {
    if (sCnt == sCntTarget) return; // 문제에서 원하는 조건 만족 시, 바로 리턴

    int iL = iFirst, iR = iCen + 1, iCur = 0;
    int numTemp[iLast - iFirst + 1];
    // 왼쪽 오른쪽 둘 다 배열이 남은 경우
    while (iL <= iCen && iR <= iLast) {
        if (num[iL] <= num[iR]) numTemp[iCur++] = num[iL++];
        else numTemp[iCur++] = num[iR++];
    }
    // 왼쪽 배열 부분만 남은 경우
    while (iL <= iCen) numTemp[iCur++] = num[iL++];
    // 오른쪽 배열 부분만 남은 경우
    while (iR <= iLast) numTemp[iCur++] = num[iR++];
    // 임시로 정렬된 배열 저장하기
    int i = iFirst, j = 0;
    while (i <= iLast) {
        num[i++] = numTemp[j++];

        // 문제에서 원하는 조건 만족 시, 정답 숫자 추출
        if (++sCnt == sCntTarget) {
            sCntNum = num[i - 1];
            break;
        }
    }
}

void mergeSort(int iFirst, int iLast) {
    if (iFirst < iLast) {
        int iCen = (iFirst + iLast) / 2;
        mergeSort(iFirst, iCen);
        mergeSort(iCen + 1, iLast);
        merge(iFirst, iCen, iLast);
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    //input
    int N;
    cin >> N >> sCntTarget;
    for (int i = 0; i < N; i++) cin >> num[i];

    //process
    mergeSort(0, N - 1);

    //output
    if (sCnt == sCntTarget) cout << sCntNum << "\n";
    else cout << -1 << "\n";

    return 0;
}


/*

// 제출 결과
구현 시간 - 1시간 반
1번째 시도 - 틀렸습니다. 채점 초반에 바로 틀림. merge에서 오른쪽 배열 저장하는 부분 틀림.
2번째 시도 - 맞았습니다! 채점 시간 8초. 수행 시간 92ms... 버퍼 설정 안 하면 무조건 터질 듯...

// test case
5 7 4 5 1 3 2
5 13 4 5 1 3 2

// test case 정답
3
-1

*/
