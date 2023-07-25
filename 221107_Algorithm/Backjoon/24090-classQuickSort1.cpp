/*
// 24090-알고리즘 수업 - 퀵 정렬 1

// 구현 방법
본문 의사코드를 적용, 지역변수로 해결해보기. 퀵 정렬 구현방식이 내가 알던 거랑 미묘하게 달라서 시간이 오래 걸림...

// 변수 설명


*/

#include <iostream>

using namespace std;

int sCnt, sCntTarget, sNum1, sNum2;

int partition(int num[], int iFirst, int iLast) {
    int comp = num[iLast]; // 비교 기준 원소(배열 중 맨 마지막 수)
    int i = iFirst - 1; // i : comp보다 작거나 같은 수를 저장할 위치 - 1
    for (int j = iFirst; j < iLast; j++) {
        // j : comp보다 작거나 같은 수의 위치
        if (num[j] <= comp) {
            i++;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;

            // swap 횟수 체크
            if (sCnt < sCntTarget) {
                sCnt++;
                if (sCnt == sCntTarget) {
                    sNum1 = num[i];
                    sNum2 = num[j];
                }
            }
        }
    }

    // 작은 수들은 왼쪽으로 보냈으니, 기준값(comp)을 작은 수들의 맨 오른쪽에 붙여줌. 이제 그 기준값은 자리 고정됨.
    if (i + 1 != iLast) {
        int temp = num[i + 1];
        num[i + 1] = num[iLast];
        num[iLast] = temp;

        // swap 횟수 체크
        if (sCnt < sCntTarget) {
            sCnt++;
            if (sCnt == sCntTarget) {
                sNum1 = num[i + 1];
                sNum2 = num[iLast];
            }
        }
    }

    return i + 1;
}

void quickSort(int num[], int iFirst, int iLast) {
    if (iFirst < iLast) {
        int iPivot;
        iPivot = partition(num, iFirst, iLast); // 분할
        quickSort(num, iFirst, iPivot - 1); // 왼쪽 배열 정렬
        quickSort(num, iPivot + 1, iLast); // 오른쪽 배열 정렬
    }
}

int main(void) {
    //input
    int N, num[10000];
    cin >> N >> sCntTarget;
    for (int i = 0; i < N; i++) cin >> num[i];

    //process
    quickSort(num, 0, N - 1);

    //output
    if (sCnt == sCntTarget) cout << sNum1 << " " << sNum2 << "\n";
    else cout << -1 << "\n";

    return 0;
}


/*

// 제출 결과
구현 시간 - 3~4시간
1번째 시도 - 맞았습니다!

// test case
5 1 2 5 1 4 3
7 6 6 5 2 5 1 4 3
7 10 6 5 2 5 1 4 3


// test case 정답
2 2
5 5
-1

*/
